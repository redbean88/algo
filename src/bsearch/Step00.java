package bsearch;

// https://www.acmicpc.net/problem/1920
// N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
// 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
// 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다.
// 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Step00 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(4, 1, 5, 2, 3);
        Collections.sort(list);
        List<Integer> list2 = Arrays.asList(1, 3, 7, 9, 5);
        List<Integer> result = new ArrayList<>();

        for (int number : list2) {
            result.add(solution(list, number));
        }

        System.out.println("result = " + result);

    }

    private static int solution(List<Integer> list,  int number) {
        int center = list.size()/2;

        if(list.size() == 1 && list.get(0) == number){
            return 1;
        }else if(list.size() == 1 && list.get(0) != number){
            return 0;
        }else{
            return list.get(center) > number ?
                    solution(list.subList(0,center), number) :
                    solution(list.subList(center,list.size()), number);
        }

    }
}
