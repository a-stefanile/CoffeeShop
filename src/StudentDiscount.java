public class StudentDiscount implements PaymentStrategy {
    @Override
    public double calculateDiscount(double basePrice){
        return basePrice*0.85;
    }
    @Override
    public String getDescription() {
        return "Student discount Strategy is 15% off";
    }
}
