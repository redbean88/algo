package tree.bst;

public class NodeMgmt {
    private Node head;

    public NodeMgmt(Node head) {
        this.head = head;
    }

    public void insert (int value){
        Node currentNode = head;
        while (true){
            if (value < currentNode.getValue()){
                if(null != currentNode.getLeft()){
                    currentNode = currentNode.getLeft();
                }else{
                    currentNode.setLeft(new Node(value));
                    break;
                }
            }else{
                if(null != currentNode.getRight()){
                    currentNode = currentNode.getRight();
                }else{
                    currentNode.setRight(new Node(value));
                    break;
                }
            }
        }
    }

    public boolean search(int value){
        Node currentNode = head;

        while (null != currentNode){
            if(value == currentNode.getValue()){
                return true;
            }else{
                if(value < currentNode.getValue()){
                    currentNode = currentNode.getLeft();
                }else {
                    currentNode = currentNode.getRight();
                }
            }
        }
        return false;
    }
}
