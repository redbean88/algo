package recursive;

// 정수 4를 1,2,3 으로 조합하는 방법은 7 가지다
// 정수 n 으로 입력 받을 경우 조합하는 경우의 수를 출력하라
public class Step04 {

    public static void main(String[] args) {
    int number = 5;
        System.out.println("solution(number) = " + solution(number));
    }

    private static int solution(int number) {

        if(number == 1) return 1;
        else if(number == 2) return 2;
        else if(number == 3){ return 4;}
        else
            return solution(number-1) + solution(number-2) +  solution(number-3);
    }
}
