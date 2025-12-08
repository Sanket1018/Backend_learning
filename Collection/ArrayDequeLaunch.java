import java.util.ArrayDeque;

public class ArrayDequeLaunch {

    public static void main(String[] args) {
        ArrayDeque ad = new ArrayDeque<>();
        ad.add(400);
        ad.add(100);
        ad.add(300);
        ad.add(200);
        System.out.println(ad);
        // ad.addFirst(100);
        // ad.addLast(500);
        System.out.println(ad);

        // index based insertion is not allowed.
        // maintains the insertion order also
        // we can insert from both the ends

        
    }
    
}
