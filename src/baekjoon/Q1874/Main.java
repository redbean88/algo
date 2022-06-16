package baekjoon.Q1874;

// 스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다.
// 스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.
// 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
// 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
// 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다.
// 이를 계산하는 프로그램을 작성하라.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] targets = new int[size];
        for (int i = 0; i < size; i++) {
            targets[i] = Integer.parseInt(br.readLine());
        }

        new Main().solution(targets);
    }

    public void solution(int[] targets){
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();

        int startNumber = 1;
        for (int i = 0; i < targets.length; i++) {
            int target = targets[i];
            if(stack.isEmpty() || stack.peek() < target){
                for (int j = startNumber; j <= target; j++) {
                    sb.append("+\n");
                    stack.push(j);
                    startNumber++;
                }
                sb.append("-\n");
                stack.pop();
            }else if(stack.peek() == target){
                sb.append("-\n");
                stack.pop();
            }else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb.toString());
    }
}
