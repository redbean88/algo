package greedy;

// 지불해야하는 값이 4720원 일 떄, 1원 50원 100원 500원 동전으로 동전의 수가 가장 적게 지불하시오

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Step00 {

    public static List<Integer> coins = Arrays.asList(500,100, 50, 1);

    public static void main(String[] args) {
        int pck = 4720;
        Collections.sort(coins, Collections.reverseOrder());
        int result = solution(pck);
        System.out.println("result = " + result);

    }

    private static int solution(int pck) {
        int result = 0;

        for (int coin : coins) {
            int count = pck / coin; // 몫
            result += count;
            pck -= coin * count;
        }

        return result;
    }


}
