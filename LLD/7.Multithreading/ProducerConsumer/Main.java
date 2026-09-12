import java.util.LinkedList;
import java.util.Queue;

class BoundedBuffer<T> {

    private final Queue<T> queue=new LinkedList<>();
    private int capacity;

    public  BoundedBuffer(int capacity){
        this.capacity=capacity;
    }

    public  synchronized void put(T item) throws InterruptedException{

        while ( queue.size() >=capacity) {
            wait();
            
        }
        queue.add(item);
        notifyAll();
    }

    public  synchronized T take() throws InterruptedException{

        while (queue.isEmpty()) {
            wait();
            
        }
        T item=queue.remove();
        notifyAll();
        return  item;
    }

    public  synchronized int size() {
        return queue.size();
    }


}
public class Main {

    public static void main(String[] args) throws InterruptedException {

        BoundedBuffer<Integer> buffer = new BoundedBuffer<>(3);

        buffer.put(10);
        buffer.put(20);
        buffer.put(30);

        System.out.println("Buffer size: " + buffer.size());

        System.out.println("Taken: " + buffer.take());
        System.out.println("Taken: " + buffer.take());

        System.out.println("Buffer size: " + buffer.size());
    }
}