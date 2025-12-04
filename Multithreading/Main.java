// Online Java Compiler
// Use this editor to write, compile and run your Java code online


public class Main {
      private static int highestNumber(int[] arr)
        {
         int max =arr[0];
        for(int i=1;i<arr.length;i++)
        {
         if(arr[i] > max) max = arr[i];
    }
    return max;
    }
        private static void secondhighest(int[] arr)
        {
            int max = highestNumber(arr);
            //int second =0;
            for(int i=0; i<arr.length;i++){
                if(arr[i]<max){
                    //second=arr[i];
                    System.out.println(arr[i]);
                }
            }
//        return second;
        }
        
      
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int arr[] = {10,20,30,90,60,20};
        //Main.highestNumber(arr);
       Main.secondhighest(arr);
       ///System.out.println(r);
        
    
}


    
}