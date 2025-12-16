class Person{
    String name = "John";
    int age = 10;

    static class Phone{
        String  mob_name = "iphone";
        void display(){
            System.out.println("Mobile Name: " + mob_name);
        }
    }
    
}




public class Inner {
    public static void main(String[] args) {

        Person p = new Person();
        System.out.println(p.name);
        System.out.println(p.age);

        Person.Phone ph = new Person.Phone();
        ph.display();   
    } 
}