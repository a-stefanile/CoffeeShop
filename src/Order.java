public class Order {
    private Beverage beverage;
    private PaymentStrategy paymentStrategy;

    public Order(Beverage beverage, PaymentStrategy paymentStrategy) {
        this.beverage = beverage;
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public double getFinalPrice(){
        return paymentStrategy.calculateDiscount(beverage.calculatePrice());
    }

    public void orderDetails(){
        System.out.println("Order Details:");
        System.out.println("Beverage: " + beverage.getName() + " price: "+ beverage.calculatePrice());
        System.out.println("PaymentStrategy: " + paymentStrategy.getDescription());
        System.out.println("Final price: " + getFinalPrice());
    }
}
