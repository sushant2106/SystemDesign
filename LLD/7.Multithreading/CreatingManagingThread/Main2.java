import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class SMSThread  implements Runnable{
   
 
    public void run(){

        try{
           Thread.sleep(2000);
           System.out.println("SMS sent using thread..");
        }
        catch(InterruptedException e){
             e.printStackTrace();
        }

    }
}

class EmailThread  implements Runnable{
   
 
    public void run(){

        try{
           Thread.sleep(2000);
           System.out.println("SMS sent using thread..");
        }
        catch(InterruptedException e){
             e.printStackTrace();
        }

    }
}

class ETACalculator implements Callable<String>{

    private final String location;

    public ETACalculator(String location){
        this.location=location;
    }

    @Override
    public String call() throws Exception{

        System.out.println("[" + Thread.currentThread().getName() + "] Calculating ETA to : " + location);
        Thread.sleep(3000);
        return "ETA to " + location + " : 20 minutes ";

    }
}



public class Main2 {
    
    public static void main(String[] args) {

        Thread smsThread=new Thread(new SMSThread());
        Thread emailThread=new Thread(new EmailThread());
        FutureTask etaThreadRunnable=new FutureTask<>(new ETACalculator("BLR"));
        
        Thread etaThread=new Thread(etaThreadRunnable);


        System.out.println("Task Started...");
        smsThread.start();
        emailThread.start();
        etaThread.start();

        System.out.println("Task 1 ongoing..");
        System.out.println("Task 2 ongoing...");
        try{
              smsThread.join();
              emailThread.join();
              String eta=(String) etaThreadRunnable.get();
              System.out.println(" Eta is " + eta );
              System.out.println("Task done...");
        }
        catch(Exception e){
                
            e.printStackTrace();
             
        }

        
    }
}
