package src.vehicles;

public class CargoVan extends Vehicle{

    public CargoVan(String brand, String model, double value) {
        super(brand, model, value);
    }

    @Override
    public String getType() {
        return "CargoVan";
    }
}
