public interface PaymentStrategy {
    double calculateDiscount(double basePrice);
    String getDescription();
}

