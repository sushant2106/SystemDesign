public class ShippingCostCalculator {
    

    private final ShippingStrategy ShippingStrategy;

    
    ShippingCostCalculator(){
        this.ShippingStrategy=new StandardShipping();
    }
    public ShippingCostCalculator(ShippingStrategy shippingStrategy){
        this.ShippingStrategy=shippingStrategy;
    }

    public double calculate(double weight){
        return   ShippingStrategy.calculateCost(weight);
    }
}