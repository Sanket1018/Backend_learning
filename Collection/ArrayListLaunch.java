import java.util.ArrayList;

public class ArrayListLaunch{
    public static void main(String[] args) {
        ArrayList al = new ArrayList<>();
        al.add(10);
        al.add(200);
        al.add("Sanket");
        al.add("Khokade");

        System.out.println(al);
        al.remove(1);
        System.out.println(al);
        
    }
}

// When we want to store the data into a collection and process it at the run time then we are going to use collections.
// Arraylist :
// 1. Dynamic
// 2. stores different type of data
// 3. continues memory