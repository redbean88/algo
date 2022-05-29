package dq;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSortMain {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,5,3,2,7,4,23,8,9,324,654,4,2,3,8);

        List<Integer> sort = QuickSort.sort(list);
        System.out.println("sort = " + sort);

    }
}


class QuickSort{
    public static List<Integer> sort(List<Integer> numbers) {
        if (numbers.size() <= 1) {
            return numbers;
        } else {
            int pivot = (Integer)numbers.get(0);
            List<Integer> left = new LinkedList();
            List<Integer> center = new LinkedList();
            List<Integer> right = new LinkedList();
            Iterator var5 = numbers.iterator();

            while(var5.hasNext()) {
                int number = (Integer)var5.next();
                if (number > pivot) {
                    right.add(number);
                } else if (number < pivot) {
                    left.add(number);
                } else {
                    center.add(number);
                }
            }

            return (List) Stream.of(sort(left), center, sort(right)).flatMap((x) -> {
                return x.stream();
            }).collect(Collectors.toList());
        }
    }
}