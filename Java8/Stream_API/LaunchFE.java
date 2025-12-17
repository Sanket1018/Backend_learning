import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LaunchFE {
    public static void main(String[] args) {
       List<Integer> list = new ArrayList<>();
       list.add(5);
       list.add(10);
       list.add(30);
       list.add(40);
       list.add( 50);

       System.out.println(list);

       // for accessing elements using for-each loop
       for(Integer i : list){
        System.out.println(i);
       }

       // using annymous class

       Consumer<Integer> c = new Consumer<>()
       {

        @Override
        public void accept(Integer n) {
          System.out.println(n);
       };

    };



    // using lambda expression

    list.forEach((n) -> System.out.println(n));


    }
    
}
