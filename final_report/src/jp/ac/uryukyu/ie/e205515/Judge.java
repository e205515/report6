package jp.ac.uryukyu.ie.e205515;

public class Judge {
    int judge;
  
    public void judgement(int cpuHand, int playerHand) {
      judge = (cpuHand - playerHand + 3 ) % 3;
  
      switch(judge) {
        case 0:
          System.out.println("あいこです!");
          break;
        case 1:
          System.out.println("あなたの勝ちです!");
          break;
        case 2:
          System.out.println("あなたの負けです!");
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
          System.out.println("ポーカーゲームを3回行うことができます!");
          break;
        case 1:
          System.out.println("ポーカーゲームを5回行うことができます!");
          break;
        case 2:
          System.out.println("ポーカーゲームを1回行うことができます!");
          break;
        default :
      }
      System.out.println("");
    }
    public void gameChange() {
      System.out.println("--------------------");
      System.out.println("【ポーカーゲームの結果】");
      System.out.println("");
      int[] loopcount = {3,5,1};
      int count = 0;
      Poker poker = new Poker();
      switch (judge) {
        case 0:
          for(int i = 0; i < loopcount[count]; i++){
            poker.pokerGame();
          }
          break;
        case 1:
        for(int i = 0; i < loopcount[count+1]; i++){
          poker.pokerGame();
        }
          break;
        case 2:
          for(int i = 0; i < loopcount[count+2]; i++){
            poker.pokerGame();
          }
          break;
        default:
      }
    }
  }
