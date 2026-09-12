package ATOMIC;

import java.util.concurrent.atomic.AtomicInteger;

class PurchaseAtomicCounter{

    private AtomicInteger likes=new AtomicInteger(0);


    public void  incrementlikes(){
        int prev,next;
        do{
            prev=likes.get();
            next=prev+1;
        }while(!likes.compareAndSet(prev, next));
    }

    public  int getCount(){
        return likes.get();
    }
}
public class Main {

    public static void main(String[] args) {
        
    }
    
}
