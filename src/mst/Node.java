package mst;

public class Node implements Comparable<Node>{
    private int dist;
    private String name;
    private String cname;

    public Node(int dist, String name, String cname) {
        this.dist = dist;
        this.name = name;
        this.cname = cname;
    }

    public int getDist() {
        return dist;
    }

    public String getName() {
        return name;
    }

    public String getCname() {
        return cname;
    }

    @Override
    public int compareTo(Node node) {
        return this.dist <= node.dist ? 1 : -1;
    }
}
