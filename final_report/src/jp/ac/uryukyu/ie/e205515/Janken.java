package jp.ac.uryukyu.ie.e205515;

public class Janken {
    static String[] handList = {"グー","チョキ","パー"};
  
    static void startMessage() {
      System.out.println("--------------------");
      System.out.println("じゃんけんをしましょう！");
    }
  
    static void endMessage() {
      System.out.println("ありがとうございました！また遊びましょうね！");
      System.out.println("--------------------");
    }
  
    public static void main(String[] args) {
      Player player = new Player();
      CPU cpu = new CPU();
      Judge judge = new Judge();
  
      // 開始の挨拶
      startMessage();
  
      // CPUが手をランダムに作成
      cpu.setHand();
  
      // Playerが手を入力
      player.setHand();
  
      // Player,CPUの手を表示
      System.out.println("・あなたの手：" + handList[player.getHand()]);
      System.out.println("・わたしの手：" + handList[cpu.getHand()]);
    
      // 判定
      judge.judgement(cpu.getHand(), player.getHand());
      
      // 結果を表示
      judge.result();
      /* 終了の挨拶
      endMessage();
      */
    }
  }
  
