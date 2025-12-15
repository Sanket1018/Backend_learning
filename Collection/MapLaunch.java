import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapLaunch {
    public static void main(String[] args) {
        // HashMap hm1 = new HashMap<>();
        // hm1.put(1,"Java");
        // hm1.put(2,"Springboot");
        // hm1.put(3,"Microservices");
        // hm1.put(null,"AWS");
     
        // System.out.println(hm1);

        // keys should be unique
        // values can be duplicate
        // keys can have one null value
        // No order of inertion maintained


        // LinkedHashMap hm2 = new LinkedHashMap<>();
        // hm2.put(1,"Python");
        // hm2.put(2,"Shell scripting");
        // hm2.put(3,"AI");

        // System.out.println(hm2);

        // LinkedHashMap maintains the order of insertion
        // it is a child class of HashMap

        // Hashtable ht = new Hashtable<>();
        // ht.put(1,"Core Java");
        // ht.put(2,"Spring Framework");
        // ht.put(3,"Hibernate");
        // ht.put(null,"Docker");  // it will throw NullPointerException

        // it doesn't allow null key and null values

        TreeMap tm = new TreeMap<>();
        tm.put(3,"DevOps");
        tm.put(1,"Kubernetes");
        tm.put(2,"Terraform");

        System.out.println(tm);
    }
}
