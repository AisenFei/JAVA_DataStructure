package heap;
public class PriorityQueueDemo {
    public static void main(String[] args) {
        MyPriorityQueue queue = new MyPriorityQueue();
        queue.add(3);
        queue.add(5);
        queue.add(2);
        queue.add(7);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}
