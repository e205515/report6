package jp.ac.uryukyu.ie.e205515;

public class Judge {
    int judge;
    int win;
    int lose;
    int even;
  
    public void judgement(int cpuHand, int playerHand) {
      judge = (cpuHand - playerHand + 3 ) % 3;
  
      switch(judge) {
        case 0:
          System.out.println("あいこです！");
          break;
        case 1:
          System.out.println("あなたの勝ちです！");
          break;
        case 2:
          System.out.println("あなたの負けです！");
          break;
        default:
      }
      System.out.println("--------------------");
    }
  
    public void result() {
      System.out.println("【勝敗の結果】");
      System.out.println("");
      switch (judge){
        case 0:
          System.out.println("ポーカーゲームを3回行うことができます");
          break;
        case 1:
          System.out.println("ポーカーゲームを5回行うことができます");
          break;
        case 2:
          System.out.println("ポーカーゲームを1回行うことができます");
          break;
        default :
      }
    }
  }
