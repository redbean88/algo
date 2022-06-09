package backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class Nqueen {
    public static void main(String[] args) {
        List<List<Integer>> result = solution(4);
        System.out.println("result = " + result);
    }

    private static List<List<Integer>>  solution(int n) {

        LinkedList<List<Integer>> result = new LinkedList<>();
        dfs(n , 0, new LinkedList<>(), result);
        return result;
    }

    private static void dfs(int n, int current_row, List<Integer> current_candidate, List<List<Integer>> result) {
        if(current_row == n){
            List<Integer> copy = new LinkedList<>();
            copy.addAll(current_candidate);
            result.add(copy);
        }

        for (int current_col = 0; current_col < n; current_col++) {
            if(isAvailable(current_candidate , current_col)){
                current_candidate.add(current_col);
                dfs(n, current_row+1 , current_candidate, result);
                current_candidate.remove(current_candidate.size()-1);
            }
        }
    }

    private static boolean isAvailable(List<Integer> current_candidate, int current_col) {
        int current_row = current_candidate.size();

        for (int queen_row = 0; queen_row < current_row; queen_row++) {
            if(current_candidate.get(queen_row) == current_col ||
               Math.abs(current_col - current_candidate.get(queen_row)) == Math.abs(current_row - queen_row)){
                return false;
            }
        }
        return true;
    }
}
