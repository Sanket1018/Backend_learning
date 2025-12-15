import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import java.util.Iterator;

class Passport{
    private String name;
    private int passportNumber;
    private String country;

    public Passport(String name, int passportNumber, String country) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.country = country;

    }

    public String getName() {
        return "Passport Holder Name: " + name + ", Passport Number: " + passportNumber + ", Country: " + country;
    }

    public String toString() {
        return "Passport{" +
                "name='" + name + '\'' +
                ", passportNumber=" + passportNumber +
                ", country='" + country + '\'' +
                '}';
    }

}


public class Passport_Details {

    public static void main(String[] args) {
        Passport p1 = new Passport("Alice", 123456, "USA");
        Passport p2 = new Passport("Bob", 654321, "Canada");
        Passport p3 = new Passport("Charlie", 112233, "UK");

        
        Integer id1 = Integer.valueOf(101);
        Integer id2 = Integer.valueOf(102);
        Integer id3 = Integer.valueOf(103);

        HashMap<Integer,Passport> hm = new HashMap<>();
        hm.put(id1, p1);
        hm.put(id2, p2);
        hm.put(id3, p3);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Passport ID to search: ");
        Integer userN = sc.nextInt();

        Set<Entry<Integer,Passport>> entry = hm.entrySet();
        boolean flag = false;
        Iterator<Entry<Integer,Passport>> itr = entry.iterator();

        while(itr.hasNext()){
            Entry<Integer,Passport> keyValue = itr.next();
            Integer key =keyValue.getKey();

            if(key.equals(userN)){
                System.out.println("Passport Found: " + keyValue.getValue().getName());
                flag = true;
            }
        }

        if(flag==false){
            System.out.println("Passport ID not found.");
        }

        


    }
    
}
