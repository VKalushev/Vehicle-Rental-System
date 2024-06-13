package src.vehicles;

public class Car extends Vehicle {
    public int safetyRating;

    public Car(String brand, String model, double value, int safetyRating) {
        super(brand, model, value);

        if (safetyRating < 1 || safetyRating > 5) {
            throw new IllegalArgumentException("Safety rating must be between 1 and 5.");
        }

        this.safetyRating = safetyRating;
    }

    public int getSafetyRating() {
        return safetyRating;
    }

    public void setSafetyRating(int safetyRating) {
        this.safetyRating = safetyRating;
    }

    @Override
    public String getType() {
        return "Car";
    }
}
