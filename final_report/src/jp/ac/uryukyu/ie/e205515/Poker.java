package jp.ac.uryukyu.ie.e205515;

public class Poker {
    //メイン
    public void pokerGame(){
        //トランプクラスを作成
        CardsManager cards = new CardsManager();

        int[] cards5 = new int[5];
        
        //1回処理
        //トランプのシャッフル
        cards.shuffle();

        //トランプを上から順番に引いていく
        int card_num = 0;
        for(int i = 1; i <= 53; i++){
            //i番目のカードを取得
            int card = cards.getCard(i);

            //ジョーカーだったら配列に入れない
            if(0==card){
                continue;
            }

            //カードが5枚になったらループを抜ける
            cards5[card_num] = card;
            ++ card_num;
            if(5==card_num){
                break;
            }
        }

        //カードを表示
        for(int i = 0; i < 5; i++){
            //マーク
            int mark = cards5[i] / 100;
            //番号
            int num = cards5[i] % 100;

            //番号を文字列に変更
            String strnum = PokerHands.getStringNumber(num);

            //表示
            switch(mark){
                case 1://スペード
                    System.out.print("♤"+strnum);
                    break;
                case 2://ハート
                    System.out.print("♡"+strnum);
                    break;
                case 3://ダイヤ
                    System.out.print("♢"+strnum);
                    break;
                case 4://クラブ
                    System.out.print("♧"+strnum);
                    break;
            }
            System.out.print(" ");
        }

        //役の判定
        int hand = PokerHands.getPokerHand(cards5);
        switch(hand){
            case 1:
                System.out.println("ロイヤルストレートフラッシュ");
                break;
            case 2:
                System.out.println("ストレートフラッシュ");
                break;
            case 3:
                System.out.println("フォーカード");
                break;
            case 4:
                System.out.println("フルハウス");
                break;
            case 5:
                System.out.println("フラッシュ");
                break;
            case 6:
                System.out.println("ストレート");
                break;
            case 7:
                System.out.println("スリーカード");
                break;
            case 8:
                System.out.println("ツーペア");
                break;
            case 9:
                System.out.println("ワンペア");
                break;
            default:
                System.out.println("ノーペア");
                break;

        }
        
    }
    
}

