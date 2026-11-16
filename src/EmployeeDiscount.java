public class EmployeeDiscount implements PaymentStrategy{
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * 0.65;
    }
    @Override
    public String getDescription() {
        return "Employee discount Strategy is 35% off";
    }
}
