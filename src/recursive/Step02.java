package recursive;

import java.util.Arrays;

// 회문을 판단하시오
public class Step02 {

     public static void main(String[] args) {
          String twxt = "level";
          char[] txt = twxt.toCharArray();
          System.out.println("solution(txt) = " + solution(txt));
          System.out.println("solution2(txt) = " + solution2(txt));
     }


     private static boolean solution(char[] txt) {
          if(txt.length <= 1){
               return true;
          }

          if(txt[0] == txt[txt.length -1]){
               return solution(Arrays.copyOfRange(txt,1,txt.length - 1));
          }else{
               return false;
          }

     }

     private static boolean solution2(char[] txt) {
          for (int i = 0; i < txt.length/2; i++) {
               if(txt[i] != txt[txt.length -1 -i]){
                    return false;
               }
          }
          return true;
     }
}
