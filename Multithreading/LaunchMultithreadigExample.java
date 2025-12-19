import java.util.Scanner;

public class LaunchMultithreadigExample {
    public static void main(String[] args) {

        System.out.println("Banking Applicaion started");
        System.out.println("Enter your account number :");

        Scanner sc = new Scanner(System.in);
        int accountNumber = sc.nextInt();

        System.out.println("Enter the password");
        int password = sc.nextInt();

        System.out.println("Bank activity terminated");
        System.out.println("********************");

        System.out.println("Printing stars activity started");
        for(int i=0;i<4;i++)
        {
            System.out.println("**");
        }
        System.out.println("Printing activity terminated");
        System.out.println("******************************");


        System.out.println("Important message started...");
        System.out.println("Important message is to focus on skills that you make you great");
        System.out.println("Message activity terminated");
        System.out.println("********************************");




        

        
    }
    
}
