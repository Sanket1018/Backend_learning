public class LaunchingSynchronize {

    public static void main(String[] args) {

        Car c = new Car();

        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(c);

        t1.setName("Sanket");
        t2.setName("Akash");
        t3.setName("Rohan");

        t1.start();
        t2.start();
        t3.start();

   
    }

}

    class Car implements Runnable{

        synchronized public void run()
        {
            System.out.println(Thread.currentThread().getName()+" is entered into the parking lot");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" is entering into the car");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" has started driving the car");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
     



    }
