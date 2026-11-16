public class NormalPayment implements PaymentStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice;
    }
    @Override
    public String getDescription() {
        return "NormalPayment Strategy";
    }

}
