package baekjoon.Q1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
public class Main {
    public static void main(String[] args) throws IOException {

        Map<Integer,Integer> As = new TreeMap<>();
        Queue<Integer> Ms = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            As.put(Integer.parseInt(st.nextToken()),1);
        }
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        while (st2.hasMoreTokens()){
            Ms.offer(Integer.parseInt(st2.nextToken()));
        }

        new Main().solution(As,Ms);
    }

    private void solution(Map<Integer, Integer> as, Queue<Integer> ms) {
        while (!ms.isEmpty()){
            Integer poll = ms.poll();
            if(as.get(poll) != null){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}
