import java.lang.reflect.Executable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class TicketBooking{

    private int availableSeats=1;
    private final ReentrantLock lock=new ReentrantLock();
    
    public void bookTicket(String user){
       System.out.println(user + " is trying to book...");
       lock.lock();
       try{
        System.out.println(user + " acquired lock..");

        if(availableSeats >0 ){
            System.out.println(user + " successfully booked the ticket..");
            availableSeats --;
        }
        else{
            System.out.println(user + " could not book the ticket.No seats left");

        }
       }
       finally{
        System.out.println(user + " is releasing the lcok...");
        lock.unlock();
       }

    }

}

class ExpiringReentrantlock{

    private final ReentrantLock lock=new ReentrantLock();

    private final ScheduledExecutorService scheduler=Executors.newSingleThreadScheduledExecutor();
    private volatile boolean islocked=false;


    private  boolean trylockWithExpiry(long timeoutMillis){

        boolean acquired=lock.tryLock();
        if(acquired){
            islocked=true;
        

        //Sceduler unlock adtertimeout
        scheduler.schedule(() ->{
            if(lock.isHeldByCurrentThread() || islocked){
               System.out.println("Auto Releaseing lock after timeout ..");

               unlockSafely();
            }
        },timeoutMillis,TimeUnit.MICROSECONDS);
    }

    return acquired;
}



public  void unlockSafely(){

    if(lock.isHeldByCurrentThread() ||islocked){
        islocked=false;
        if(lock.isHeldByCurrentThread()){
            lock.unlock();
            System.out.println("lock released..");
        }
    }
}
}

public class Main{

    public static  void main(String[] args){


    }
}