class PurchaseCounterSyncMethod{

    private volatile int count=0;  //one threads write and everyone reads

    public  void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }



}

class PurchaseCounterSyncBlock{
    private int count=0;

    public void increment(){

        //
         synchronized(this){
            count++;
         }
         //
    }

    public  int getCount(){
        return count;
    }
}

public class Main {

    public static void main(String[] args) {
           

        PurchaseCounterSyncMethod counter=new PurchaseCounterSyncMethod();

        Runnable task=() ->{
             for(int i=0;i<100000;i++){
                counter.increment();
            }
        };

        Thread t1=new Thread(task);
        Thread t2=new Thread(task);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("Final Count: " + counter.getCount());



    }
    
}
