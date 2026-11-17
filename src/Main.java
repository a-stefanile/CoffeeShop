import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Order> orders = new ArrayList<>();
        boolean isOpen = true;

        do{
            System.out.println("New order");

            System.out.println("Choose your beverage (Espresso, Cappuccino, Americano)");
            String beverageName = scanner.nextLine();

            System.out.println("Choose your beverage size(Small,Medium,Large):");
            Size size = Size.valueOf(scanner.nextLine().toUpperCase());

            System.out.println("Choose your beverage temperature (Hot,Cold):");
            Temperature temperature = Temperature.valueOf(scanner.nextLine().toUpperCase());

            System.out.println("Choose the discount for the client (Normal, Student, Employee)");
            String discount = scanner.nextLine().toLowerCase();

            PaymentStrategy paymentStrategy;
            switch (discount) {
                case "student":
                    paymentStrategy = new StudentDiscount();
                    break;
                case "employee":
                    paymentStrategy = new EmployeeDiscount();
                    break;
                default:
                    paymentStrategy = new NormalPayment();
                    break;
            }

            Beverage beverage = BeverageFactory.createBeverage(beverageName,size,temperature);

            Order order = new Order(beverage,paymentStrategy);
            orders.add(order);

            System.out.println("Order created");
            order.orderDetails();

            System.out.println("Do you want to add another order? (s/n): ");
            String choice = scanner.nextLine();
            if (choice.equals("n")){
                isOpen = false;
            }


        }while (isOpen);

        orders.forEach(Order::orderDetails);

    }
}