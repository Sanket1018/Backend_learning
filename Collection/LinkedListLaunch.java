import java.util.LinkedList;

public class LinkedListLaunch {
    public static void main(String[] args) {
        LinkedList  ll = new LinkedList<>();
        ll.add(100);
        ll.add("Sanket");
        ll.add("Khokade");
        ll.add(200);
        System.out.println(ll);  
        ll.addFirst("10000"); 
        System.out.println(ll);
        System.out.println(ll.contains("Sanket"));
        ll.offer("Sumit");
        ll.offer("Koulapure"); 
        System.out.println(ll);
        ll.offerFirst("111");
        System.out.println(ll);
        System.out.println(ll.peek());
        System.out.println(ll.poll());
        System.out.println(ll);
    }

    // dynamic
    // stores different data
    // connected with nodes in memory
    // we can add the data at any point
    // maintains the order of insertion
    // in case of mainting the insertion order we are going to use linkedlist

    // what is the difference between add and offer
    // add : must be adding
    // offer : may be added or not based on requirement
    // peek : gives the first element in the linkedlist
    // poll : Removes the first element and gives the value of removed element
    // other methods will see in the stream API
    
}
