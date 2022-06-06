package mst;

import java.util.*;

public class Prim {
    public static void main(String[] args) {

        List<Node> edges = new LinkedList<>();
        edges.add(new Node(7,"A","B"));
        edges.add(new Node(5,"A","D"));

        edges.add(new Node(8,"B","C"));
        edges.add(new Node(9,"B","D"));
        edges.add(new Node(7,"B","E"));

        edges.add(new Node(5,"C","E"));

        edges.add(new Node(7,"D","E"));
        edges.add(new Node(6,"D","F"));

        edges.add(new Node(8,"E","F"));
        edges.add(new Node(9,"E","G"));

        edges.add(new Node(11,"F","G"));

        List<Node> result = solution(edges, "A");

        result.forEach(r -> {
            System.out.println("r.getDist() + r.getName() + r.getCname() = " + r.getDist() + r.getName() + r.getCname());
        });
    }

    public static List<Node> solution(List<Node> edges, String startNode){

        List<Node> mst = new LinkedList<>();
        List<String> connected_edges = new ArrayList<>();
        Map<String , List<Node>> adjacent_edges = new HashMap<>();
        PriorityQueue<Node> cadidated_edges = new PriorityQueue<>(Comparator.reverseOrder());

        // 간선 정보를 위한 MAP
        makeAdjacentEdges(edges, adjacent_edges);

        // 시작값 설정
        connected_edges.add(startNode);
        adjacent_edges.get(startNode).forEach( node -> {
            cadidated_edges.offer(node);
        });

        while (false == cadidated_edges.isEmpty()){
            Node node = cadidated_edges.poll();
            if(false == connected_edges.contains(node.getCname())){
                connected_edges.add(node.getCname());
                mst.add(node);
                List<Node> nodes = adjacent_edges.get(node.getCname());
                nodes.forEach(n -> {
                    if(false == connected_edges.contains(n.getCname())){
                        cadidated_edges.offer(n);
                    }
                });
            }
        }

        return mst;

    }

    private static void makeAdjacentEdges(List<Node> edges, Map<String, List<Node>> adjacent_edges) {
        edges.forEach(node -> {
            List<Node> nodes = adjacent_edges.get(node.getName());
            if (nodes == null){
                List<Node> newNodes = new ArrayList<>();
                newNodes.add(new Node(node.getDist() , node.getName() ,node.getCname()));
                adjacent_edges.put(node.getName(), newNodes);
            }else {
                nodes.add(new Node(node.getDist() , node.getName() ,node.getCname()));
            }

            List<Node> cnodes = adjacent_edges.get(node.getCname());
            if (cnodes == null){
                List<Node> newNodes = new ArrayList<>();
                newNodes.add(new Node(node.getDist(), node.getCname(), node.getName()));
                adjacent_edges.put(node.getCname(), newNodes);
            }else{
                cnodes.add(new Node(node.getDist(), node.getCname(), node.getName()));
            }
        });
    }
}

