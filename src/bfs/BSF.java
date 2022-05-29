package bfs;

import java.util.*;

public class BSF {

    public static Map<String, List<String>> graph = new LinkedHashMap<>();

    public static void main(String[] args) {
        init();

        Queue<String> visited = new LinkedList<>();
        Queue<String> need_visited = new LinkedList<>();

        Queue<String> result = bsf(graph, "A");
        System.out.println("result = " + result);
    }

    private static Queue<String> bsf(Map<String,List<String>> graph, String start_node) {
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

    private static void init() {
        graph.put("A" , Arrays.asList("B","C"));
        graph.put("B" , Arrays.asList("A","D"));
        graph.put("C" , Arrays.asList("A","G","H","I"));
        graph.put("D" , Arrays.asList("B","E","F"));
        graph.put("E" , Arrays.asList("D"));
        graph.put("F" , Arrays.asList("D"));
        graph.put("G" , Arrays.asList("C"));
        graph.put("H" , Arrays.asList("C"));
        graph.put("I" , Arrays.asList("C","J"));
        graph.put("J" , Arrays.asList("I"));
    }

}
