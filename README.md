# Vehicle Rental System

This is a simple vehicle rental system implemented in Java. It allows customers to rent different types of vehicles, and it calculates the rental costs based on the rental period and the type of vehicle. The system also handles customer-specific requirements and generates invoices based on the rental details.

## Project Structure

### The project is organized into the following main components:

* **Vehicle:** A base class representing a general vehicle.

    * **Car:** A subclass of Vehicle representing a car. It includes an additional attribute for the safety rating.

    * **Motorcycle:** A subclass of Vehicle representing a motorcycle.
  
    * **CargoVan:** A subclass of Vehicle representing a cargo van.
  
* **Customer:** A class representing a customer with attributes for name, age, and driving experience.
  
* **Rental:** A class representing a rental, including details such as the vehicle, rental period, customer information, and reservation dates.
  
* **Invoice:** A class used to generate and print rental invoices, including calculating the actual rental days and applying any necessary discounts or additional charges.

This vehicle rental system provides a simple yet flexible way to manage vehicle rentals, handle customer-specific requirements, and generate invoices with appropriate calculations.
