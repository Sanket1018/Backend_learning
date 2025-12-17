import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class LaunchStream {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(20);
        list.add(10);
        list.add(50);
        list.add(40);

        // Collections.sort(list);
        // System.out.println(list);
        // It will change the original list
        
        // using stream api

        Stream<Integer> streamData1 = list.stream();
        Stream<Integer>sortedStream = streamData1.sorted();

        sortedStream.forEach((n) -> {System.out.println(n);});
        // one steam can be used only one time

        

        
    }
}
