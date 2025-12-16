class A{
    void display(){
        System.out.println("Inside class A");
    }
}


// suppose I want to override display method of class A without creating a subclass
public class Annoymous {
    public static void main(String[] args) {
        A a = new A(){
            void display(){
                System.out.println("Inside Annoymous class");
            }
        };
        
    }
    
// works only if there is one method.It can be used with functional interfaces also.
// replacement for annoymous class using lambda expression
   
}
