package jp.ac.uryukyu.ie.e205515;
import java.util.*;

public class Player {
    int hand;
  
    public void setHand() {
      System.out.print("「グー」「チョキ」「パー」のどれかを入力してください。＞");
      Scanner sc = new Scanner(System.in);
      String inputHand = sc.nextLine();
      sc.close();
  
      switch(inputHand) {
        case "グー":
          hand = 0;
          break;
        case "チョキ":
          hand = 1;
          break;
        case "パー":
          hand = 2;
          break;
        default:
          System.out.println("間違えたので終了します…。");
      }
    }
  
    public int getHand() {
      return this.hand;
    }
  }