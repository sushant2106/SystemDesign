import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class SMSThread extends Thread{
    
    @Override 
    public  void run(){
       try{
            Thread.sleep(2000);
           System.out.println("SMS sent using thread..");
       }
       catch(Exception e){
           e.printStackTrace();
       }
    }
}

class EmailThread implements Runnable{
    @Override 
    public void run(){
           try{
            Thread.sleep(2000);
           System.out.println("Email sent using thread..");
       }
       catch(Exception e){
          e.printStackTrace();
       }
    }
}

class ETACalculator implements  Callable<String>{

    private final String location;

    public  ETACalculator(String location){
        this.location=location;
    }
    
    @Override 
    public String call() throws Exception{
          System.out.println("[" + Thread.currentThread().getName() + "] Calculating ETA to : " + location);
        Thread.sleep(3000);
        return "ETA to " + location + " : 20 minutes ";


    }



}


public class Test {
    public static void main(String[] args) {


        SMSThread smsThread=new SMSThread();
        Thread emailThread=new Thread(new EmailThread());
        FutureTask etacalculatorrunnable=new FutureTask<>(new ETACalculator("Delhi"));
         
        Thread etacalculator=new Thread(etacalculatorrunnable);
        System.out.println("Task Started...");
        smsThread.start();
        System.out.println("Task 1 ongoing..");
        emailThread.start();
        System.out.println("Task 2 ongoing...");
        etacalculator.start();

        try{
              smsThread.join();
              emailThread.join();
               String etafare=(String)etacalculatorrunnable.get();
              System.out.println("Task done...");
               System.out.println(" Eta is " + etafare );
              System.out.println("Task done...")
        }
        catch(Exception e){
                
            e.printStackTrace();
             
        }
        
    }
}
