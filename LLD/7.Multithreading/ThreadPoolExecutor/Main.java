import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
 
//fixed vs Cached vs Schedule Thread 
class EmailService{

    private static  final ExecutorService executor=Executors.newFixedThreadPool(10);

    public  static  void sendEmail(String recipent){

       executor.execute( () ->{
         System.out.println("Sending email to" + recipent + " on " + Thread.currentThread().getName());

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println("Email sent to " + recipent);
       });


    }

    public  static  void main(String[] args){
        
        for(int i=1;i<=25;i++){
            sendEmail("User" + i + "@gmail.com");
        
        }
         executor.shutdown();
    }

}

class FutureExample {

    public static void main(String[] args) throws Exception{
        ExecutorService executor=Executors.newFixedThreadPool(2);

        Future<Integer> future=executor.submit(() ->{
            Thread.sleep(1000);
            return 42;
        });

        System.out.println("Doing other work ");

        Integer result= future.get();//block until result is ready 

        System.out.println("Result: " + result);

        executor.shutdown();
        
    }
}

public class Main {

    public static  void main(String[] args){
      

        
    }
}