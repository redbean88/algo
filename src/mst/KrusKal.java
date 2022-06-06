package mst;

import java.util.*;

public class KrusKal {

    static Map<String, String> parent = new HashMap<>();
    static Map<String, Integer> rank = new HashMap<>();

    public static void main(String[] args) {
        List<Node> edges = new LinkedList<>();
        edges.add(new Node(7,"A","B"));
        edges.add(new Node(5,"A","D"));

        edges.add(new Node(7,"B","A"));
        edges.add(new Node(8,"B","C"));
        edges.add(new Node(9,"B","D"));
        edges.add(new Node(7,"B","E"));

        edges.add(new Node(8,"C","B"));
        edges.add(new Node(5,"C","E"));

        edges.add(new Node(5,"D","A"));
        edges.add(new Node(9,"D","B"));
        edges.add(new Node(7,"D","E"));
        edges.add(new Node(6,"D","F"));

        edges.add(new Node(7,"E","B"));
        edges.add(new Node(5,"E","C"));
        edges.add(new Node(7,"E","D"));
        edges.add(new Node(8,"E","F"));
        edges.add(new Node(9,"E","G"));

        edges.add(new Node(6,"F","D"));
        edges.add(new Node(8,"F","E"));
        edges.add(new Node(11,"F","G"));

        edges.add(new Node(9,"G","E"));
        edges.add(new Node(11,"G","F"));

        Graph graph =new Graph(edges);
        List<Node> mst = solution(graph, "A");
        mst.forEach(node -> {
            System.out.println("node.getName() +node.getCname() = " + node.getName() +node.getCname());
        });
    }

    public static List<Node> solution(Graph graph, String startNode){
        List<Node> mst = new ArrayList<>();

        //초기화
        makeSet(graph);

        //sort
        Collections.sort(graph.getEdges(),Comparator.reverseOrder());

        //사이클 없는 간선 연결

        graph.getEdges().forEach(node -> {
            if(false == find(node.getName()).equalsIgnoreCase(find(node.getCname()))){ // 같은 루트 부모를 가지는지 확인
                union(node.getName() , node.getCname());
                mst.add(node);
            }
        });

        return mst;
    }

    private static void union(String name, String cname) {
        String root1 = find(name);
        String root2 = find(cname);

        if(rank.get(root1) > rank.get(root2)){
            parent.put(root2 , root1);
        }else{
            parent.put(root1 , root2);
            if(rank.get(root1) == rank.get(root2)){
                Integer rankv = rank.get(root2);
                rank.put(root2, rankv++);
            }
        }


    }

    private static String find(String x) {
        if(false == x.equalsIgnoreCase(parent.get(x))){
            parent.put(x , find(parent.get(x)));
        }
        return parent.get(x);
    }

    private static void makeSet(Graph graph) {
        graph.getVertices().forEach(x-> {
            parent.put(x , x);
            rank.put(x, 0);
        });
    }
}

class Graph{
    List<String> vertices = new ArrayList<>();
    List<Node> edges = new ArrayList<>();

    public Graph(List<Node> edges) {
        this.edges = edges;
        edges.forEach(node -> {
            if(false == vertices.contains(node.getName())){
                vertices.add(node.getName());
            }
        });
    }

    public List<String> getVertices() {
        return vertices;
    }

    public List<Node> getEdges() {
        return edges;
    }
}
