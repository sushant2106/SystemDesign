public class Main {

    

    public static void main(String[] args) {
        
         
        OrderProcessor orderProcessor=new OrderProcessor(new USTaxCalculator());

        orderProcessor.processOrder(1000.0);

    }
    
}
