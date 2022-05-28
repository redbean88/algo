package dp;

// https://www.acmicpc.net/problem/9461

// 오른쪽 그림과 같이 삼각형이 나선 모양으로 놓여져 있다. 첫 삼각형은 정삼각형으로 변의 길이는 1이다. 그 다음에는 다음과 같은 과정으로 정삼각형을 계속 추가한다. 나선에서 가장 긴 변의 길이를 k라 했을 때, 그 변에 길이가 k인 정삼각형을 추가한다.
// 파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다. P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.
// N이 주어졌을 때, P(N)을 구하는 프로그램을 작성하시오.
public class Step02 {

    public static void main(String[] args) {
        int number = 12;
        System.out.println("dp_solution(number) = " + dp_solution(number));

    }

    private static int dp_solution(int number) {

        int[] cache = new int[number +1];
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 1;
        cache[3] = 1;
        cache[4] = 2;

        for (int i = 5; i < cache.length; i++) {
            cache[i] = cache[i-2] + cache[i-3];
        }
        return cache[number];
    }

}
