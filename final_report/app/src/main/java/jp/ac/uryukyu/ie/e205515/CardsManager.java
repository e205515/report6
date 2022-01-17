package jp.ac.uryukyu.ie.e205515;

/**
 * トランプを操作するクラス
 * トランプの配列を用意する(初期化)し、整列させる。
 * トランプのシャッフル、取得までを実装
 */
public class CardsManager {
    /**
     * トランプ配列
     * 配列の値
     * 000 : ジョーカー
     * 101～113 : スペードの1～13
     * 201～213 : ハートの1～13
     * 301～313 : ダイヤの1～13
     * 401～413 : クラブの1～13
     */
    private int[] cards;
    
    /**
     * トランプの配列を作成し、初期化する
     */
    public CardsManager(){
        //配列の作成
        cards = new int[13 * 4 + 1];
        //初期化
        organize();
    }

    /**
     * トランプの整列(初期化用メソッド)
     * 各マークごとの格納番号を設定
     * ジョーカーを格納(添字：0)
     * スペードを格納(添字：1~13)
     * ダイヤを格納(添字：14~26)
     * クラブを格納(添字：27~39)
     * ハートを格納(添字：40~52)
     */

    public void organize(){
        //ジョーカーの格納
        cards[0] = 0;

        for (int i = 1; i<=13; i++){
            //スペードを格納(添字：1~13)
            cards[i] = 100 + i;
            //ダイヤを格納(添字：14~26)
            cards[i + 13] = 200 + i;
            //クラブを格納(添字：27~39)
            cards[i + 26] = 300 + i;
            //ハートを格納(添字：40~52)
            cards[i + 39] = 400 + i;
         }
    }
    /**
     * トランプのシャッフル
     */
    public void shuffle(){
        for (int i = 0; i<cards.length; i++){
            //0~(配列aryの個数-1)の乱数を発生
            int rnd = (int)(Math.random()*(double)cards.length);

            //cards[i]とcards[rnd]を入れ替える
            int w = cards[i];
            cards[i] = cards[rnd];
            cards[rnd] = w;
        }
    }
    /**
     * トランプの取得
     * @param num 1~53までのカード番号を表す。
     */
    public int getCard(int num) {
        //numが、1~53番目以外の場合、-1を戻す
        if((1>num) ||(53<num)){
            return -1;
        }
        //カードを戻す
        return cards[num -1];
    }
}