package recursive;


// 1-num 까지의 곱을 출력 하시오
public class Step00 {

    public static void main(String[] args) {

        System.out.println("solution = " + solution(10));
        System.out.println("solution2 = " + solution2(10));
    }

    public static int solution(int num){
        if(num <= 1){
            return 1;
        }
        return num * solution(num -1 );
    }

    public static int solution2(int num){
        int result = 1;
        for (int i = 2; i <= num; i++) {
            result = result * i;
        }
        return result;
    }

}
