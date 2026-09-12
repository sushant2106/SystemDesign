class OvernightShipping implements ShippingStrategy {
    @Override
    public double calculateCost(double weight) {
        return weight * 5.0;
    }
}

