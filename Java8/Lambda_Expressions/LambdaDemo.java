@FunctionalInterface
interface A{
    void display();
}

public class LambdaDemo{
    public static void main(String[] args) {
        A a = () -> {
            System.out.println("Inside Lambda expression");
        };
        a.display();
    }
}
