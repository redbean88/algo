package dp;

// n 을 입력 받알을 때, 피보나 수열로 결과값을 출력하라
public class Step00 {

    public static void main(String[] args) {
        int number = 5;
        System.out.println("solution(number) = " + solution(number));
        System.out.println("solution(number) = " + dp_solution(number));
    }

    private static int dp_solution(int number) {
        int[] cache = new int[number + 1];
        cache[0]= 0;
        cache[1]= 1;

        for (int i = 2; i < cache.length; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[number];
    }

    private static int solution(int number) {
        if(number <= 1) return number;
        else return solution(number-1) + solution( number -2);
    }


}
