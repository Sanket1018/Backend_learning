import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailsSafeIteraor {
    
    public static void main(String[] args) {
        CopyOnWriteArrayList cowal = new CopyOnWriteArrayList<>();
        cowal.add(100);
        cowal.add(200);
        cowal.add(300);
        cowal.add(400);
        System.out.println(cowal);

        // Iterator i = cowal.iterator();
        // while(i.hasNext()){
        //     System.out.println(i.next());
        //     cowal.add(500); // no ConcurrentModificationException and safe to use
        // }

        ListIterator l = cowal.listIterator(cowal.size());
        while(l.hasPrevious())
        {
            System.out.println(l.previous());
            cowal.add(600); // no ConcurrentModificationException and safe to use
            // we can add elements while traversing in reverse direction
        }
        
    }
}
