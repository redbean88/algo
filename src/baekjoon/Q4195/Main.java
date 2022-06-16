package baekjoon.Q4195;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 민혁이는 소셜 네트워크 사이트에서 친구를 만드는 것을 좋아하는 친구이다.
// 우표를 모으는 취미가 있듯이, 민혁이는 소셜 네트워크 사이트에서 친구를 모으는 것이 취미이다.
// 어떤 사이트의 친구 관계가 생긴 순서대로 주어졌을 때, 두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.
// 친구 네트워크란 친구 관계만으로 이동할 수 있는 사이를 말한다.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int relationCase = Integer.parseInt(br.readLine());

            for (int j = 0; j < relationCase; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

            }

        }
    }

    void solution(){

    }

    class Graph{

        public Queue<String> bsf(Map<String, List<String>> graph, String start_node) {
            Queue<String> visited = new LinkedList<>(), need_visited = new LinkedList<>();
            need_visited.add(start_node);

            while (false == need_visited.isEmpty()){
                String node = need_visited.poll();
                if(false == visited.contains(node)){
                    visited.add(node);
                    graph.get(node).stream().forEach(x -> need_visited.add(x));
                }
            }
            return visited;
        }
    }
}
