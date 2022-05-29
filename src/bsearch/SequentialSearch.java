package bsearch;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SequentialSearch {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(10);
        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 100));
        }
        Collections.sort(list);
        System.out.println("list = " + list);

        int solution = solution(list, 10);
        System.out.println("solution = " + solution);
    }

    private static int solution(List<Integer> list,int target) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == target){
                return i+1;
            }
        }
        return -1;
    }
}
