package baekjoon.Q2920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다.
// 이 문제에서 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. c는 1로, d는 2로, ..., C를 8로 바꾼다.
// 1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed 이다.
// 연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.
public class Main {

    public static void main(String[] args) {

        Queue<Integer> numbers = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()){
                numbers.offer(Integer.parseInt(st.nextToken()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = new Main().solution(numbers, true,true);
        System.out.println("result = " + result);
    }

    public String solution(Queue<Integer> numbers, boolean ascending, boolean descending){
        if(numbers.size() == 1){
            if(ascending) return "ascending";
            else if(descending) return "descending";
            else return "mixed";
        }

        int before = numbers.poll();
        int after = numbers.peek();

        if (before < after) {
            return solution(numbers ,ascending, false);
        } else {
            return solution(numbers ,false, descending);
        }
    }
}

