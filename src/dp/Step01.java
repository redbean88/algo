package dp;

// https://www.acmicpc.net/problem/11726
// 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

public class Step01 {
    public static void main(String[] args) {
        int number = 10;
        System.out.println("solution(number) = " + solution(number) % 1007);
        System.out.println("solution(number) = " + dp_solution(number) % 1007);

    }

    private static int solution(int number) {
        if(number == 1) return 1;
        else if(number == 2) return 2;
        else
            return solution(number-1) + solution(number-2);
    }

    private static int dp_solution(int number) {
        int[] arr = new int[number+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[number];
    }



}
