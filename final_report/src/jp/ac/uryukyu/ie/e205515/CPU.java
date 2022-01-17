package jp.ac.uryukyu.ie.e205515;

/**
 * コンピュータのじゃんけんの手を実装
 * [グー、チョキ、パー]の中からランダムで手を決定し、取得する
 */
public class CPU {
    int hand;
    /**
     * コンピュータの手を設定する
     */
    public void setHand() {
     double rand = Math.random() * 3;
     hand = (int)rand;
    }
    /**
     * コンピュータの手を取得する
     */
    public int getHand() {
      return this.hand;
    }
}
