package recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 리스트에 들어있는 숫자의 합을 구하식오
public class Step01 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        System.out.println("solution(list) = " + solution(list ));
        System.out.println("solution2(list) = " + solution2(list));
    }

    private static Integer solution(List<Integer> list) {
        if(list.size() == 1){
            return list.get(0);
        }else{
            List<Integer> newList = list.subList(1,list.size());
            return  list.get(0) + solution(newList);
        }

    }

    private static Integer solution2(List<Integer> list) {
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result = result + list.get(i);
        }
        return result;
    }
}
