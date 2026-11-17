public abstract class Beverage {

    private String name;
    private double basePrice;
    private Size size;
    private Temperature temperature;

    public Beverage(String name, double basePrice,
                    Size size,
                    Temperature temperature) {

        this.name = name;
        this.basePrice = basePrice;
        this.size = size;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public Size getSize() {
        return size;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public double calculatePrice() {

        double price = basePrice;

        switch (size) {

            case SMALL:
                price += 0.00;
                break;

            case MEDIUM:
                price += 0.30;
                break;

            case LARGE:
                price += 0.60;
                break;

            default:
                throw new IllegalArgumentException(
                        "Dimensione non valida");
        }

        switch (temperature) {

            case HOT:
                price += 0.00;
                break;

            case COLD:
                price += 0.30;
                break;

            default:
                throw new IllegalArgumentException(
                        "Temperatura non valida");

        }

                return price;
        }
    }