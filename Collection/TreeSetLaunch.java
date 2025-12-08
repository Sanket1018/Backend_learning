import java.util.TreeSet;

public class TreeSetLaunch {
    public static void main(String[] args) {
        TreeSet ta = new TreeSet<>();
        ta.add(100);
        ta.add(25);
        ta.add(300);
        ta.add(500);
        ta.add(100); // duplicate value
        System.out.println(ta);

        // it stores the data in sorted order
        // it does not allow the duplicate values
        // it uses Binary search tree data structure


    }
    
}
