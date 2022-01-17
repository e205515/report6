package jp.ac.uryukyu.ie.e205515;

/**
 * じゃんけんの実装、ポーカーへの移行
 */
public class Janken {
    static String[] handList = {"グー","チョキ","パー"};
    /**
     * じゃんけん開始の挨拶
     */
    static void startMessage() {
      System.out.println("--------------------");
      System.out.println("じゃんけんをしましょう!");
    }
    /**
     * じゃんけん、ポーカーの全てのゲーム終了の挨拶
     */
    static void endMessage() {
      System.out.println("ありがとうございました!また遊びましょうね!");
      System.out.println("--------------------");
    }
    /**
     * じゃんけんにおけるメインメソッド
     * Playerクラス、CPUクラス,Judgeクラスから呼び出す
     */
    public void jankenGame(){
      Player player = new Player();
      CPU cpu = new CPU();
      Judge judge = new Judge();
  
      /**
       * じゃんけん開始の挨拶
       */
      startMessage();
  
      /**
       * CPUが手をランダムに作成
       */
      cpu.setHand();
  
      /**
       * Playerが手を入力
       */
      player.setHand();
  
      /**
       * Player,CPUの手を表示
       */
      System.out.println("・あなたの手：" + handList[player.getHand()]);
      System.out.println("・わたしの手：" + handList[cpu.getHand()]);
    
      /**
       * 判定
       */
      judge.judgement(cpu.getHand(), player.getHand());
      
      /**
       * 結果を表示
       */
      judge.result();

      /**
       * じゃんけんからポーカーへのゲーム移行
       */
      judge.gameChange();

      /**
       * 終了の挨拶
       */
      endMessage();
    }
  }
  
