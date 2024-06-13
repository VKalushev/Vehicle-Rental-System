package src;

import src.vehicles.Car;
import src.vehicles.Vehicle;

import java.time.LocalDate;

public class Rental {
    private Vehicle vehicle;
    private int rentalPeriod;
    private double dailyRentalCost;
    private Customer customer;
    private LocalDate reservationStartDate;
    private LocalDate reservationEndDate;

    public Rental(Vehicle vehicle, int rentalPeriod, Customer customer, LocalDate reservationStartDate) {
        this.vehicle = vehicle;
        this.rentalPeriod = rentalPeriod;
        this.customer = customer;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationStartDate.plusDays(rentalPeriod);

        if(rentalPeriod > 7){
            switch (vehicle.getType()) {
                case "Car" -> this.dailyRentalCost = 15;
                case "Motorcycle" -> this.dailyRentalCost = 10;
                case "CargoVan" -> this.dailyRentalCost = 40;
            }
        } else {
            switch (vehicle.getType()) {
                case "Car" -> this.dailyRentalCost = 20;
                case "Motorcycle" -> this.dailyRentalCost = 15;
                case "CargoVan" -> this.dailyRentalCost = 50;
            }
        }


    }

    public String getCustomName() {
        return this.customer.getName();
    }

    public int getRentalPeriod() {
        return rentalPeriod;
    }

    public double getDailyRentalCost() {
        return dailyRentalCost;
    }

    public LocalDate getReservationStartDate() {
        return reservationStartDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDate getReservationEndDate() {
        return reservationEndDate;
    }

    public String getRentedVehicleName() {
        return this.vehicle.getBrand() + " " + this.vehicle.getModel();
    }

    public int getCustomerAge() {
        return this.customer.getAge();
    }

    public int getCustomerDrivingExperience() {
        return this.customer.getDrivingExperience();
    }
}
