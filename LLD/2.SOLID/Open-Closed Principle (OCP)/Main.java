public class Main {

    public static void main(String[] args) {
        
        ShippingCostCalculator shippingCostCalculator=new ShippingCostCalculator(new OvernightShipping());

        System.out.println(shippingCostCalculator.calculate(3.0));
    }
    
}
