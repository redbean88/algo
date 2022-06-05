package shortestPath.dijkstra;

import java.util.*;
import java.util.stream.Collectors;

public class ShortestPath {

    public static void main(String[] args) {

        Map<String, List<Node>> graph = new LinkedHashMap<>();
        graph.put("A", Arrays.asList(new Node("B", 8) , new Node("C",1), new Node("D", 2)));
        graph.put("B",null);
        graph.put("C", Arrays.asList(new Node("B", 5) , new Node("D", 2)));
        graph.put("D", Arrays.asList(new Node("E", 3) , new Node("F", 5)));
        graph.put("E", Arrays.asList(new Node("F", 1)));
        graph.put("F",null);

        Map<String, Integer> list = new Dijkstra().solution(graph, "A");
        System.out.println("list = " + list);
    }
}

class Dijkstra{
    private PriorityQueue<Node> pQueue = new PriorityQueue<>(Comparator.reverseOrder());
    private Map<String, Integer> result = new HashMap<>();

    public Map<String , Integer> solution(Map<String, List<Node>> graph,String startNode){
        setup(graph,startNode);
        pQueue.offer(new Node(startNode,0));

        while (false == pQueue.isEmpty()){
            Node node = pQueue.poll();
            List<Node> nodes = graph.get(node.getName());
            if(nodes == null) continue;
            if(result.get(node.getName()) < node.getDist()) continue;
            nodes.forEach(x -> {
                int distance = node.getDist() + x.getDist();
                if(distance < result.get(x.getName())){
                    result.put(x.getName(),distance);
                    pQueue.offer(new Node(x.getName(),distance));
                }
            });
        }

        return result;
    }

    private void setup(Map<String, List<Node>> graph, String startNode) {
        graph.entrySet().stream()
                .forEach(node -> {
                    result.put(node.getKey(),Integer.MAX_VALUE);
                });
        result.put(startNode,0);
    }
}

class Node implements Comparable<Node>{
    private int dist;
    private String name;

    public Node(String name, int dist ) {
        this.dist = dist;
        this.name = name;
    }

    public int getDist() {
        return dist;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Node node) {
        return this.dist <= node.dist ? 1 : -1;
    }
}