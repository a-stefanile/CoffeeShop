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
            String beverageName = "";
            boolean validBeverage = false;
            while(!validBeverage) {
                System.out.println("Choose your beverage (Espresso, Cappuccino, Americano)");
                beverageName = scanner.nextLine().toLowerCase();
                if(beverageName.equals("espresso") || beverageName.equals("cappuccino")|| beverageName.equals("americano")) {
                    validBeverage = true;
                }
                else {
                    System.out.println("Invalid beverage, choose a valide one");
                }
            }
            
            System.out.println("Choose your beverage size(Small,Medium,Large):");

            Size size = null;
            boolean validSize = false;

            while (!validSize) {

                System.out.println("Choose your beverage size (Small, Medium, Large):");

                String inputSize = scanner.nextLine().trim().toUpperCase();

                try {
                    size = Size.valueOf(inputSize);
                    validSize = true;

                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid size, choose a valid one.");
                }
            }

            System.out.println("Choose your beverage temperature (Hot,Cold):");

            Temperature temperature = null;
            boolean validTemperature = false;

            while (!validTemperature) {
                System.out.println("Choose your beverage temperature (Hot, Cold):");
                String inputTemperature = scanner.nextLine().trim().toUpperCase(Locale.ROOT);

                try {
                    temperature = Temperature.valueOf(inputTemperature);
                    validTemperature = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid temperature, choose a valid one.");
                }
            }

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