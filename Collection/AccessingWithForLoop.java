import java.util.ArrayList;
import java.util.Iterator;

public class AccessingWithForLoop {
    public static void main(String[] args) {
        ArrayList al = new ArrayList<>();
        al.add(100);
        al.add(200);
        al.add(300);
        al.add(400);

        int a = (int) al.get(2); // downcasting
        System.out.println(a);

        for(int i=0;i<al.size();i++){
            System.out.println(al.get(i));
        }

        for(Object o:al)
        {
            System.out.println(o);
        }

        // Doing concurrent modification when accessing the for loop

        for(int i=0;i<al.size();i++){
            Integer  value = (Integer)al.get(i);
            System.out.println(value);
            // al.add(500); // goes to infinite loop not recommended
        }

        // solution is to use Iterator gives the concurrent modification exception
        Iterator itr = al.iterator(); // provides cursor based access
        while(itr.hasNext()){
            System.out.println(itr.next());
            // next method fetches the next element and moves the cursor forward
            al.add(600); // ConcurrentModificationException and it callesd fail-fast behavior
        }


        
    }
    
}
