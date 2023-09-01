# Vehicle Rental Calculator in Java

This Java project is a vehicle rental calculator that allows users to rent vehicles, including cars, motorbikes, and trailers, from pickup locations. It demonstrates object-oriented programming concepts, database connectivity, user input validation, and calculation of rental prices.

## Project Overview

This project is worth 300 points and includes the following components:

1. **Database Creation and Connectivity (50 points):** The project involves creating a database (`dbVehicleRental`) with a table (`TLocations`) to store car rental pickup locations. The table includes columns for location name, address, city, state, and zip. The SQL script for database creation is included in the `Database` folder of the project.

2. **OOP Programming with Classes and Subclasses (50 points):** The project follows object-oriented programming principles with parent and child classes (`CVehicle`, `CCar`, `CMotorbike`, `CTrailer`) for different vehicle types.

3. **User Input Validation (50 points):** User input is validated, including phone numbers, email addresses, and the number of vehicles to rent.

4. **Program Logic for Calculating Rental Output (50 points):** The program calculates rental details, including the total rental price, for each vehicle type based on user input.

5. **Proper JavaDoc Comments (20 points):** JavaDoc comments are provided above all class and method signatures to document the code.

6. **JavaDoc Creation (30 points):** A JavaDoc is generated for the project to provide documentation for the code.

7. **Screen Captures of Test Results (50 points):** Test results for all three vehicle types are captured and included in the project.

## Project Requirements

### Inputs

The application allows the user to input the following required information for each vehicle rental:

1. Customer Name
2. Phone Number (validated using regular expressions)
3. Email Address (validated using regular expressions)
4. Number of Rental Days
5. Number of Vehicles to Rent
6. Selection of Vehicle Types to Rent

### Outputs

For each vehicle rental transaction, the program displays the following details:

- Customer Name
- Phone Number
- Email Address
- Type of Vehicle Rented
- Information about the Vehicle (e.g., driving characteristics, MPG)
- Total Rental Price for the Vehicle (with 2 decimal places)
- Total Rental Amount for all rented vehicles (with 2 decimal places)

## Usage

1. Ensure you have Java installed on your system.
2. Clone or download this project to your local machine.
3. Set up the database by running the SQL script provided in the `Database` folder.
4. Compile and run the Java program `CVehicleFinal.java`.

