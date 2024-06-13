package src.vehicles;

public class Motorcycle extends Vehicle{

    public Motorcycle(String brand, String model, double value) {
        super(brand, model, value);
    }

    @Override
    public String getType() {
        return "Motorcycle";
    }
}
