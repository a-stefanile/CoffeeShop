public class BeverageFactory {

    public static Beverage createBeverage(
            String type,
            Size size,
            Temperature temperature) {

        switch (type.toLowerCase()) {

            case "espresso":
                return new Espresso(size, temperature);

            case "cappuccino":
                return new Cappuccino(size, temperature);

            case "americano":
                return new Americano(size, temperature);

            default:
                throw new IllegalArgumentException(
                        "Beverage not available");
        }
    }
}