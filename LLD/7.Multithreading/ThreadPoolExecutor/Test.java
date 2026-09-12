

// class MyGreeting implements  Runnable{

//     @Override 
//     public void run(){
//         System.out.println("hello");
//     }
// }
public class Test {
   
    public static void boilWater(){
        System.out.println("Hello");
    }
    public static void main(String[] args) {
        
        // Runnable r=new  Runnable(){
        //     public void run (){
        //         boilWater();
        //     }
        // };

        Runnable r=() -> boilWater();

        r.run();

        // Thread smathread=new Thread(() -> boilWater());

        


    }
    
}
