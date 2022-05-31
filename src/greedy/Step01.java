package greedy;

// 무게 제한이 k인 배낭에 최대 가치를 가질 수 있도록 하는 문제
// [이름, 무게, 가치]
// [물건1, 10 , 10]
// [물건2, 15 , 12]
// [물건3, 20 , 10]
// [물건4, 25 , 8]
// [물건5, 30 , 5]

import java.util.*;
import java.util.stream.Collectors;

public class Step01 {

    public static List<List<Double>> packs = new LinkedList<>();

    public static void main(String[] args) {

        packs.add(Arrays.asList(10D, 10D));
        packs.add(Arrays.asList(15D,12D));
        packs.add(Arrays.asList(30D,5D));
        packs.add(Arrays.asList(20D,10D));
        packs.add(Arrays.asList(25D,8D));

        packs = packs.stream()
                .sorted(Comparator.comparingDouble(x -> (int) (x.get(0) / x.get(1))))
                .collect(Collectors.toList());

        int packageSize = 30;

        List<List<Double>> solution = solution(packageSize);
        System.out.println("solution = " + solution);

    }

    private static List<List<Double>> solution(int packageSize) {
        List<List<Double>> result = new LinkedList<>();

        for (List<Double> pack: packs ) {
            if(packageSize > pack.get(0)){
                result.add(Arrays.asList(pack.get(0) ,pack.get(1), 1D));
                packageSize -= pack.get(0);
            }else{
                Double w = Double.valueOf(packageSize / pack.get(0));
                Double price = packageSize * pack.get(1) / pack.get(0);
                result.add(Arrays.asList(pack.get(0) , price ,w));
                break;
            }
        }

        return result;
    }
}
