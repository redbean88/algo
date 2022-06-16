package baekjoon.Q5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 창영이는 강산이의 비밀번호를 훔치기 위해서 강산이가 사용하는 컴퓨터에 키로거를 설치했다.
// 며칠을 기다린 끝에 창영이는 강산이가 비밀번호 창에 입력하는 글자를 얻어냈다.
// 키로거는 사용자가 키보드를 누른 명령을 모두 기록한다.
// 따라서, 강산이가 비밀번호를 입력할 때, 화살표나 백스페이스를 입력해도 정확한 비밀번호를 알아낼 수 있다.
// 강산이가 비밀번호 창에서 입력한 키가 주어졌을 때, 강산이의 비밀번호를 알아내는 프로그램을 작성하시오.
// 강산이는 키보드로 입력한 키는 알파벳 대문자, 소문자, 숫자, 백스페이스, 화살표이다.
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCnt = Integer.parseInt(br.readLine());

        Main main = new Main();
        for (int i = 0; i < testCaseCnt; i++) {
            System.out.println(main.solution(br.readLine()));
        }
        br.close();
    }

    public String solution(String target){
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        StringBuilder sb= new StringBuilder();

        for (int i = 0; i < target.length(); i++) {
            char chr = target.charAt(i);
            if(chr == '<'){
                if(!left.empty()){
                    right.push(left.pop());
                }
            }else if(chr == '>'){
                if(!right.empty()){
                    left.push(right.pop());
                }
            }else if(chr == '-'){
                left.pop();
            }else{
                left.push(chr);
            }
        }

        while (!left.empty()){
            right.push(left.pop());
        }
        while (!right.empty()){
            sb.append(right.pop());
        }
        return sb.toString();
    }
}
