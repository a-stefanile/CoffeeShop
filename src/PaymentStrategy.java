public interface PaymentStrategy {
    double calculatePrice(double basePrice);
    String getDescription();
}

