public class LaunchMultithreading {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = Thread.currentThread();
        System.out.println("Current thread name: " + thread.getName());
        System.out.println("Current thread priority: " + thread.getPriority());

        Thread.sleep(4000);
        thread.setName("MyMainThread");
        thread.setPriority(4);

        System.out.println(thread.getName() + " " + thread.getPriority());


       
    }
}