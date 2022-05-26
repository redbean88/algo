package sort;

import sort.bubble.BubbleSort;
import sort.insertion.InsertionSort;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(4);
        test.add(3);
        test.add(6);
        test.add(2);
        test.add(10);
        test.add(1);

        BubbleSort sort = new BubbleSort(test);
        List<Integer> result = sort.getResult();
        System.out.println("result = " + result);

        InsertionSort sort1 = new InsertionSort(test);
        List<Integer> result1 = sort1.getResult();
        System.out.println("result1 = " + result1);
    }

}
