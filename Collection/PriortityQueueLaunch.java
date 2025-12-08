import java.util.PriorityQueue;

public class PriortityQueueLaunch {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue<>();
        pq.add(400);
        pq.add(100);
        pq.add(300);
        pq.add(200);

        System.out.println(pq);

        // it follows the min-heap data structure
        // it always keeps the minimum element at the head
        // insertion order is not maintained
    }
    
}