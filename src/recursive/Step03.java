package recursive;

// 정수 n 에 대하 n 이 홀수이면, 3 * n + 1, n이 짝수 이면 n을 2로 나눈
// n 이 1이 될때까지 반복한다 1이 되는 과정을 출력 하시오

public class Step03 {

    public static void main(String[] args) {
        int number = 3;
        solution(number);
    }

    private static int solution(int number) {
        System.out.println("number = " + number);
        if(number == 1) return number;
        if(number%2 != 0){return solution(3 * number + 1);}
        else{  return solution(number/2);}
    }
}
