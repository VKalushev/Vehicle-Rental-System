package src;

import src.vehicles.Car;
import src.vehicles.CargoVan;
import src.vehicles.Motorcycle;
import src.vehicles.Vehicle;

import java.time.LocalDate;

public class VehicleRentalSystem {
    public static void main(String[] args) {

//        Vehicle vehicle = new Car("Mitsubishi","Mirage",15000,3);
//        Vehicle vehicle = new Motorcycle("Triumph","Tiger Sport 660",10000);
        Vehicle vehicle = new CargoVan("Citroen","Jumper",20000);

        Customer customer = new Customer("John Doe");

        if(vehicle.getType().equals("Motorcycle")){
            customer.setAge(20);
        } else if(vehicle.getType().equals("CargoVan")){
            customer.setDrivingExperience(8);
        }

        LocalDate reservationStartData = LocalDate.of(2024, 6, 3);

        Rental rental = new Rental(vehicle,4,customer,reservationStartData);

        LocalDate actualReturnDate = LocalDate.of(2024,6,13);
        Invoice invoice = new Invoice(rental,actualReturnDate);
        invoice.generateInvoice();

    }
}
