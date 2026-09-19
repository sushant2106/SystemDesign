interface PaymentGateway{
    void processPayment(double amount);
}

interface Invoice{
    void generateInvoice();
}


//Invoice 

class GSTInvoice implements  Invoice{
    public  void generateInvoice(){
        System.out.println("Generating GST invoice for India ..");
    }
}

class USInvoice implements  Invoice{
    public  void generateInvoice(){
        System.out.println("Generating GST invoice for US ..");
    }
}

//INDIA
class RazorpayGateway implements  PaymentGateway{

    @Override 
    public  void processPayment(double amount){
        System.out.println("Process INT payment via Razorpay: " + amount);
    }
}

class PayUGateway implements  PaymentGateway{

    public void  processPayment(double amount){
        System.out.println("Processing INR via PayU: " +amount);
    }
}

//US

class Paypal implements  PaymentGateway{


    @Override 
    public  void processPayment(double amount){
        System.out.println("Process us payment via Paypal: " + amount);
    }
}


class Stripe implements  PaymentGateway{


    public void  processPayment(double amount){
        System.out.println("Processing US via Stripe: " +amount);
    }
}






interface RegionFactory{

    PaymentGateway createPaymentGateway(String gatewayType);
    Invoice creatInvoice();
}

class IndianFactory implements  RegionFactory{

    public  PaymentGateway  createPaymentGateway(String gatewayType){

        switch (gatewayType.toLowerCase()) {
            case "razorpay":
                
                return new  RazorpayGateway();
            
            case "payu":
                return  new PayUGateway();
        
            default:
                throw new IllegalArgumentException("Unsupported payment gateway in India" + gatewayType );
        }
    }

    public  Invoice creatInvoice(){
        return  new GSTInvoice();
    }
}

class USFactory implements  RegionFactory{


    public  PaymentGateway  createPaymentGateway(String gatewayType){


        switch (gatewayType.toLowerCase()) {
            case "paypal":
                
                return new  Paypal();
            
            case "stripe":
                return  new Stripe();
        
            default:
                throw new IllegalArgumentException("Unsupported payment gateway in US " + gatewayType);
        }
    }


    public  Invoice creatInvoice(){
        return  new USInvoice();
    }
}










class CheckoutService{

    private  PaymentGateway paymentGateway;
    private Invoice invoice;
    private String  gatewayType;

    public  CheckoutService(RegionFactory factory,String  gatewayType){
        this.gatewayType=gatewayType;
        this.paymentGateway=factory.createPaymentGateway(gatewayType);
        this.invoice=factory.creatInvoice();
    }

    public  void completeOrder(double amount){
        paymentGateway.processPayment(amount);
        invoice.generateInvoice();
    }

    public  void showgatewayName(){
        System.out.println(this.gatewayType);
    }


}


public class Main {

    public static void main(String[] args) {

        CheckoutService checkoutService=new CheckoutService(new IndianFactory(),"razorpay");

        checkoutService.completeOrder(200);
        
    }
}