public class NormalPayment implements PaymentStrategy {
    @Override
    public double calculateDiscount(double basePrice) {
        return basePrice;
    }
    @Override
    public String getDescription() {
        return "NormalPayment Strategy";
    }

}
