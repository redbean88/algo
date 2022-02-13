package tree.bst;

public class Main {
    public static void main(String[] args) {

        Node node = new Node(1);
        NodeMgmt BST = new NodeMgmt(node);
        BST.insert(2);
        BST.insert(0);
        BST.insert(3);
        BST.insert(4);
        BST.insert(5);

        System.out.println(BST.search(5));
        System.out.println(BST.search(7));
    }
}
