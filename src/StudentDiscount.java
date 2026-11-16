public class StudentDiscount implements PaymentStrategy {
    @Override
    public double calculatePrice(double basePrice){
        return basePrice*0.85;
    }
    @Override
    public String getDescription() {
        return "Student discount Strategy is 15% off";
    }
}
