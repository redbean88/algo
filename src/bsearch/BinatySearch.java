package bsearch;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// 1~100 까지 숫자가 적혀 있는 병이 순서대로 나열되어 있다.
// 70이 적혀있는 병을 찾는 최소 값은?
public class BinatySearch {
    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 30; i++) {
            list.add((int) (Math.random() * 100));
        }
        Collections.sort(list);
        System.out.println("list = " + list);
        int target = 70;
        int dq_solution = dq_solution(list, target, 0);
        System.out.println("dq_solution = " + dq_solution);

    }

    private static int dq_solution(List<Integer> list, int target, int count) {
        System.out.println("list = " + list);
        int center = list.size()/2;

        if(list.size() ==1 && list.get(0) != target) {
            return -1;
        }else if(list.size() ==1 && list.get(0) == target){
            return count + 1;
        }
        return list.get(center) > target ?
                dq_solution(list.subList(0,center), target , count + 1)
                : dq_solution(list.subList(center, list.size() ) , target , count +1);
    }

}
