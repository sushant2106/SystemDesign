class PurchaseCounter{

    private int count=0;

    public void increment(){
        //its not unitry operation
        //read, increment ,write 
        count++; //not thread safe 
    }

    public int getCount(){
        return count;
    }
}


public class RaceCondition {

    public static void main(String[] args)  throws InterruptedException{


        PurchaseCounter counter=new PurchaseCounter();

        Runnable task=() -> {
            for(int i=0;i<10000;i++){
                counter.increment();
            }
        };

        Thread t1=new Thread(task);
        Thread t2=new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + counter.getCount());


        
    }
}