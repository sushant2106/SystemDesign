
interface PaymentProcessor{
    void processPayment(double amount, String currency);
    boolean isPaymentSuccessful();
    String getTransactionId();
}


class InHousePaymentProcessor  implements  PaymentProcessor{

    private String transactionId;
    private boolean paymentSuccessful;

    @Override 
    public void processPayment(double amount,String currency){
         System.out.println("InHouseProcessor: Processing " + amount + " " + currency);
        transactionId = "TXN_" + System.currentTimeMillis();
        paymentSuccessful = true;
        System.out.println("InHouseProcessor: Success. Txn ID: " + transactionId);
    }
    
    @Override 
    public boolean isPaymentSuccessful(){
        return paymentSuccessful;
    }

    @Override 
    public String  getTransactionId(){
        return transactionId;
    }
}

class LegacyGateway {
    private long transactionReference;
    private boolean paymentSuccessful;

    public void executeTransaction(double totalAmount, String currency) {
        System.out.println("LegacyGateway: Executing " + currency + " " + totalAmount);
        transactionReference = System.nanoTime();
        paymentSuccessful = true;
        System.out.println("LegacyGateway: Done. Ref: " + transactionReference);
    }

    public boolean checkStatus(long ref) {
        System.out.println("LegacyGateway: Checking status for ref: " + ref);
        return paymentSuccessful;
    }

    public long getReferenceNumber() {
        return transactionReference;
    }
}

class LegacyGatewayAdapter implements  PaymentProcessor{

    private final LegacyGateway legacyGateway;
    private long currentRef;

    public LegacyGatewayAdapter(LegacyGateway legacyGateway) {
        this.legacyGateway = legacyGateway;
    }

    @Override 
    public  void  processPayment(double amount,String currency){
         System.out.println("Adapter: Translating processPayment() for " + amount + " " + currency);
        legacyGateway.executeTransaction(amount, currency);
        currentRef = legacyGateway.getReferenceNumber(); 
    }

    @Override 
    public  boolean isPaymentSuccessful(){
        return legacyGateway.checkStatus(currentRef);
    }

    @Override 
    public String getTransactionId() {
        return "LEGACY_TXN_" + currentRef;
    }
}

class CheckoutService{

    private final PaymentProcessor paymentProcessor;

    CheckoutService(PaymentProcessor paymentProcessor){
        this.paymentProcessor=paymentProcessor;
    }

    public void checkout(double amount,String currency){
        System.out.println("Checkout: Processing order for $" + amount + " " + currency);
        paymentProcessor.processPayment(amount, currency);
        if (paymentProcessor.isPaymentSuccessful()) {
            System.out.println("Checkout: Order successful! Txn: "
                + paymentProcessor.getTransactionId());
        } else {
            System.out.println("Checkout: Order failed.");
        }
    }
}



public class ECommerceApp {

    public static void main(String[] args) {

        PaymentProcessor processor=new InHousePaymentProcessor();
        CheckoutService checkoutService=new CheckoutService(processor);

        checkoutService.checkout(199.99, "USD");
           
   
        System.out.println("\n--- Using Legacy Gateway via Adapter ---");
        PaymentProcessor paymentProcessor2=new LegacyGatewayAdapter(new LegacyGateway());
        CheckoutService checkoutService2=new  CheckoutService(paymentProcessor2);

        checkoutService2.checkout(300, "INR");

        
    }
    
}
