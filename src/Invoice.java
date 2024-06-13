package src;

import src.vehicles.Car;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Invoice {
    private Rental rental;
    private LocalDate actualReturnDate;
    private int actualRentalDays;
    private double rentalCost;
    private double insuranceCostPerDay;

    public Invoice(Rental rental, LocalDate actualReturnDate) {
        this.rental = rental;
        this.actualReturnDate = actualReturnDate;
        this.actualRentalDays = (int) ChronoUnit.DAYS.between(rental.getReservationStartDate(),actualReturnDate);

//        this.rentalCost = calculateRentalCost();
//        this.insuranceCostPerDay = (rental.getInsuranceRate() * rental.getVehicle().getValue());
    }

    private void calculateTotalRentalAndInsuranceCost(){
        double rentalCost = this.actualRentalDays * this.rental.getDailyRentalCost();
        double insuranceCost = this.insuranceCostPerDay * this.actualRentalDays;

        if(this.actualRentalDays < this.rental.getRentalPeriod()){
            double initialRentalCost = this.rental.getRentalPeriod() * this.rental.getDailyRentalCost();
            double initialInsuranceCost = this.rental.getRentalPeriod() * this.insuranceCostPerDay;

            int unUsedRentalDays = this.rental.getRentalPeriod() - this.actualRentalDays;
            rentalCost += unUsedRentalDays * (this.rental.getDailyRentalCost()/2);

            System.out.printf("Early return discount for rent: $%.2f%n",(initialRentalCost - rentalCost));
            System.out.printf("Early return discount for insurance: $%.2f%n%n",(initialInsuranceCost - insuranceCost));
        }

        System.out.printf("Total rent: $%.2f%n",rentalCost);
        System.out.printf("Total insurance: $%.2f%n",insuranceCost);

        double totalCost = rentalCost + insuranceCost;
        System.out.printf("Total: $%.2f%n",totalCost);
    }

    private void calculateDailyInsuranceCost(){
        double insuranceRate = 0;
        double insurancePerDay = 0;
        switch (rental.getVehicle().getType()) {
            case "Car" -> {
                insuranceRate = 0.0001;

                Car car = (Car) rental.getVehicle();
                insurancePerDay = insuranceRate * rental.getVehicle().getValue();

                if (car.getSafetyRating() >= 4) {
                    System.out.printf("Initial insurance per day: $%.2f%n",insurancePerDay);
                    System.out.printf("Insurance discounted per day: $%.2f%n",insurancePerDay * 0.1);
                    insurancePerDay *= 0.9;
                }
            }
            case "Motorcycle" -> {
                insuranceRate = 0.0002;
                insurancePerDay = insuranceRate * rental.getVehicle().getValue();
                if (rental.getCustomerAge() < 25) {
                    System.out.printf("Initial insurance per day: $%.2f%n",insurancePerDay);
                    System.out.printf("Insurance addition per day: $%.2f%n",insurancePerDay * 0.2);
                    insurancePerDay *= 1.2;
                }
            }
            case "CargoVan" -> {
                insuranceRate = 0.0003;
                insurancePerDay = insuranceRate * rental.getVehicle().getValue();

                if (rental.getCustomerDrivingExperience() > 5) {
                    System.out.printf("Initial insurance per day: $%.2f%n",insurancePerDay);
                    System.out.printf("Insurance discounted per day: $%.2f%n",insurancePerDay * 0.15);
                    insurancePerDay *= 0.85;
                }
            }
        }

        System.out.printf("Insurance per day: $%.2f%n",insurancePerDay);
        this.insuranceCostPerDay = insurancePerDay;
    }

    public void generateInvoice(){
        System.out.println("X".repeat(10));
        System.out.println("Date: " + LocalDate.now());
        System.out.println("Customer Name: " + this.rental.getCustomName());
        System.out.println("Rented Vehicle: " + this.rental.getRentedVehicleName());
        System.out.println();

        System.out.println("Reservation start date: " + this.rental.getReservationStartDate());
        System.out.println("Reservation end date: " + this.rental.getReservationEndDate());
        System.out.printf("Reservation rental days: %d days %n%n",this.rental.getRentalPeriod());

        System.out.println("Actual Return date: " + this.actualReturnDate);
        System.out.println("Actual rental days: " + this.actualRentalDays);
        System.out.println();

        System.out.printf("Rental cost per day: $%.2f%n",this.rental.getDailyRentalCost());
        calculateDailyInsuranceCost();
        System.out.println();

        calculateTotalRentalAndInsuranceCost();
        System.out.println("X".repeat(10));
    }
}
