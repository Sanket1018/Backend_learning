public class MultithreadingExample{
    public static void main(String[] args)
    {
        // Mythread t1 = new Mythread();
        // t1.start();
        // for(int i=0;i<=10;i++)
        // {
        //     System.out.println("Main thread");
        // }

        MyRunnable m1 = new MyRunnable();
        Thread t1 = new Thread(m1);
        t1.start();

       
        
    }
}

// class Mythread extends Thread{
//     @Override
//     public void run()
//     {
//        for(int i=0;i<9;i++)
//        {
//         System.out.println("Child method");
//        }
//     }
// }

class MyRunnable implements Runnable
{
    public void run()
    {
        System.out.println("tun method called");
    }
}