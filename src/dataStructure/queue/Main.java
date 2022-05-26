package dataStructure.queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.inQueue("1");
        queue.inQueue("3");
        queue.inQueue("2");

        System.out.println("dataStructure.queue.deQueue() = " + queue.deQueue());
        System.out.println("dataStructure.queue.deQueue() = " + queue.deQueue());
        System.out.println("dataStructure.queue.deQueue() = " + queue.deQueue());
    }
}
