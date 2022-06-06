package mst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class KrusKal {
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
        System.out.println("graph.getVertices() = " + graph.getVertices());
    }

    public List<Node> solution(List<Node> edges, String startNode){
        List<Node> mst = new ArrayList<>();

        //초기화

        //sort

        //사이클 없는 간선 연결


        return null;
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