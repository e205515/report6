package jp.ac.uryukyu.ie.e205515;

public class PokerHands {
    //エラー
    static final int ERROR = 0;

    //ポーカーの役の定数を定義する
    //ロイヤルストレートフラッシュ
    static final int Royal_Flush = 1;
    //ストレートフラッシュ
    static final int Straight_Flush = 2;
    //フォーカード
    static final int Four_Of_A_Kind = 3;
    //フルハウス
    static final int A_Full_House = 4;
    //フラッシュ
    static final int Flush = 5;
    //ストレート
    static final int Straight = 6;
    //スリーカード
    static final int Three_Of_A_Kind = 7;
    //ツーペア
    static final int Two_Pair = 8;
    //ワンペア
    static final int One_Pair = 9;
    //ブタ
    static final int No_Pair = 10;

    //カード5枚を配列で渡して役を判定するメソッド
    public static int getPokerHand(int[] cards){
        //配列がnullだった場合、エラー
        if(null == cards){
            return ERROR;
        }
        //配列の個数が5でなければエラー
        if(5!=cards.length){
            return ERROR;
        }
        //トランプのマークの個数を格納する配列
        int[] suit = new int[4];
        //トランプのマークの個数に0を代入(初期化)
        for(int i = 0; i<suit.length;i++){
            suit[i] = 0;
        }

        //トランプの番号(1~13)の個数を格納する配列
        //number[0]とnumber[13]の両方にAの個数を格納
        int[] number = new int[14];

        //トランプの番号の個数に0を代入(初期化)
        for(int i = 0; i<number.length; i++){
            number[i] = 0;
        }

        //5枚のカードのマークと番号の個数を格納
        for(int i = 0; i <cards.length; i++){
            //マーク
            int mark = cards[i] / 100;
            //番号
            int num = cards[i] %100;

            //markが1~4の範囲から外れるとエラー
            if((1>mark)||(4<mark)){
                return ERROR;
            }

            //numが1~13の範囲を外れるとエラー
            if((1>num)||(13<num)){
                return ERROR;
            }
            //マークの個数に1を足す
            ++ suit[mark - 1];

            //番号の個数に1を足す
            ++ number[num - 1];
        }

        //number[13]にAの個数を代入
        number[13] = number[0];

        //番号の個数の最大値を取得
        int number_max = 0;
        for(int i = 0; i < number.length -1;i++){
            if(number_max < number[i]){
                number_max = number[i];
            }
        }

        //ここから判定処理

        //個数の最大が4の場合、フォーカード確定
        if(4==number_max){
            return Four_Of_A_Kind;
        }

        //マークの個数の最大を取得
        //5枚のカードが同じマークの場合、suit_max=5となる
        int suit_max = 0;
        for(int i = 0; i<suit.length; i++){
            if(suit_max<suit[i]){
                suit_max = suit[i];
            }
        }

        //ストレートの判定
        boolean isStraight = false;
        int continuous1 = 0;
        int firstnum = 0;
        for(int i = 0; i<number.length; i++){
            if(1 != number[i]){
                continuous1 = 0;
                firstnum = 0;
            }else{
                ++continuous1;
                //ストレートの最初の番号を格納
                if(1==continuous1){
                    firstnum = i +1;
                }
                //5回連続だったら
                if(5==continuous1){
                    //ストレートは確定
                    isStraight = true;
                    break;
                }
            }
        }

        //マークが全て同じで、ストレートだったら
        if((5==suit_max) && isStraight){
            //ストレートの先頭の番号が10だったら
            if(10==firstnum){
                //ロイヤルストレートフラッシュ確定
                return Royal_Flush;
            }
            //ストレートフラッシュ確定
            return Straight_Flush;
        }

        //個数の最大が3で、もう1つペアが存在したら
        if(3==number_max){
            for(int i = 0; i< number.length-1; i++){
                if(2==number[i]){
                    //フルハウス確定
                    return A_Full_House;
                }

            }
        }

        //マークが全て同じだったら
        if(5==suit_max){
            //フラッシュ確定
            return Flush;
        }

        //ストレートだったら
        if(isStraight){
            //ストレート確定
            return Straight;
        }

        //個数の最大が3の場合、スリーカード確定
        if(3==number_max){
            return Three_Of_A_Kind;
        }

        //ペアの個数
        int pair_num = 0;
        for(int i = 0; i<number.length - 1; i++){
            if(2==number[i]){
                ++pair_num;
            }
        }

        //ペアが2つあれば
        if(2==pair_num){
            return Two_Pair;
        }
        //ペアが1つあれば
        if(1==pair_num){
            return One_Pair;
        }
        //ブタ
        return No_Pair;
    }

    //番号を文字に変換
    public static String getStringNumber(int num){
        switch(num){
            case 1:
                return "A";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
        }
        return "";
    }

    
}
