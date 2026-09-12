public class USTaxCalculator implements TaxCalculator {

    @Override
    public double calculateTax(double amount) {
        return amount * 0.10;
    }
    
    @Override
    public String getRegion() {
        return "US";
    }
}
