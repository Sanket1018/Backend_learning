import java.util.HashMap;
import java.util.LinkedHashMap;

public class MapLaunch {
    public static void main(String[] args) {
        HashMap hm1 = new HashMap<>();
        hm1.put(1,"Java");
        hm1.put(2,"Springboot");
        hm1.put(3,"Microservices");
        hm1.put(null,"AWS");
     


        System.out.println(hm1);

        // keys should be unique
        // values can be duplicate
        // keys can have one null value
        // No order of inertion maintained


        LinkedHashMap hm2 = new LinkedHashMap<>();
        hm2.put(1,"Python");
        hm2.put(2,"Shell scripting");
        hm2.put(3,"AI");

        System.out.println(hm2);

        // LinkedHashMap maintains the order of insertion
    }
}
