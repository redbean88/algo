package dq;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeSortMain {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,5,3,2,7,4,23,8,9,324,654,4,2,3,8);
        List<Integer> sort = MergeSort.split(list);
        System.out.println("sort = " + sort);
    }
}

class MergeSort{
    public static List<Integer> split(List<Integer> list){
        if(list.size() <= 1) return list;
        int center = list.size() / 2;
        List<Integer> left = list.subList(0,center);
        List<Integer> right = list.subList(center, list.size());
        return merge(split(left),split(right));
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right){
        List<Integer> result = new LinkedList<>();
        int leftPivot =0 ,rightPivot  = 0;

        while (left.size() > leftPivot && right.size() > rightPivot){
            if(left.get(leftPivot) > right.get(rightPivot)){
                result.add(right.get(rightPivot));
                rightPivot++;
            }else{
                result.add(left.get(leftPivot));
                leftPivot++;
            }
        }

        while (left.size() > leftPivot){
            result.add(left.get(leftPivot));
            leftPivot++;
        }

        while (right.size() > rightPivot) {
            result.add(right.get(rightPivot));
            rightPivot++;
        }

        return result;
    }
}
