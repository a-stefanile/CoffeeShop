public class EmployeeDiscount implements PaymentStrategy{
    @Override
    public double calculateDiscount(double basePrice) {
        return basePrice * 0.65;
    }
    @Override
    public String getDescription() {
        return "Employee discount Strategy is 35% off";
    }
}
