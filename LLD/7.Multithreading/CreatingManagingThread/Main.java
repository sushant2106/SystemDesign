

class SMSThread extends Thread{
   
    @Override
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

// class EmailThread extends Thread{
   
//     @Override
//     public void run(){

//         try{
//            Thread.sleep(3000);
//            System.out.println("Email sent using thread..");
//         }
//         catch(InterruptedException e){
//              e.printStackTrace();
//         }

//     }
// }

class EmailThread implements Runnable{
   
    @Override
    public void run(){

        try{
           Thread.sleep(3000);
           System.out.println("Email sent using thread..");
        }
        catch(InterruptedException e){
             e.printStackTrace();
        }

    }
}

public class Main {

    public static void main(String[] args) {
       
        SMSThread smsThread=new SMSThread();
        // EmailThread emailThread=new EmailThread();

        Thread emailThread=new Thread(new EmailThread());

        System.out.println("Task Started...");
        smsThread.start();
        System.out.println("Task 1 ongoing..");
        emailThread.start();
        System.out.println("Task 2 ongoing...");
        try{
              smsThread.join();
              emailThread.join();

              System.out.println("Task done...");
        }
        catch(InterruptedException e){
                
            e.printStackTrace();
             
        }

    

    }
}