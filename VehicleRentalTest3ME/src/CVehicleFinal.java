import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Main program that executes and displays all customer information.
 * This program interacts with a database, loads data, gathers customer
 * information, rental details for vehicles, and displays customer information
 * along with rented vehicles. It provides various utility methods for database
 * connection, data retrieval, and validation.
 *
 * @author Million Eyassu
 * @version 1.0
 * @since 2023-08-14 (date when the class was created or last modified)
 */

public class CVehicleFinal {
   // define the Connection
   public static Connection m_conAdministrator;

   public static Scanner scanner =
       new Scanner(System.in); // Declare scanner as a class member

   /**
    * method name: OpenDatabaseConnectionMSAccess
    * The opens the database connection
    * This requires the following drivers: Use UCanAccess, an open-source JDBC
    * driver. Include the following jar files in your code: ucanaccess-2.0.7.jar
    * jackcess-2.0.4.jar
    * commons-lang-2.6.jar
    * commons-logging-1.1.3.jar
    * hsqldb.jar
    * To include those files select "Project / Properties / Java Build Path"
    * from the menu.  Click on the "Libraries" tab.  Click "Add External
    * JARs". Browse to the above jar files, which should be in a directory in
    * your project (e.g. JDBC-to-MSAccess).  Select all five files and click
    * "Open".  Click "OK".
    *
    * Be sure to add the drivers to your program by selecting Project >>
    * Properties >> Java Build Path
    */
   public static boolean OpenDatabaseConnectionMSAccess() {
      boolean blnResult = false;

      try {
         String strConnectionString = "";

         // Update the path to match your actual folder structure
         strConnectionString = "jdbc:ucanaccess://"
             + System.getProperty("user.dir") + "\\src\\dbVehicleRental.accdb";

         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

         // Open a connection to the database
         m_conAdministrator = DriverManager.getConnection(strConnectionString);

         // Success
         blnResult = true;
         System.out.println(
             "OpenDatabaseConnectionMSAccess: Connection Established - awesome work!   \n ");
      } catch (Exception e) {
         System.out.println("Try again - error in OpenDB \n ");
         System.out.println("Error is " + e);
      }
      return blnResult;
   }

   /**
    * Closes the connection to the database.
    *
    * @return True if the connection is successfully closed, false otherwise.
    */
   public static boolean CloseDatabaseConnection() {
      boolean blnResult = false;

      try {
         // Is there a connection object?
         if (m_conAdministrator != null) {
            // Yes, close the connection if not closed already
            if (m_conAdministrator.isClosed() == false) {
               m_conAdministrator.close();

               // Prevent JVM from crashing
               m_conAdministrator = null;
            }
         }
         // Success
         blnResult = true;
      } catch (Exception excError) {
         // Display Error Message
         System.out.println(excError);
      }

      return blnResult;
   }

   /**
    * Retrieves and displays records from a specified database table, presenting
    * them in a formatted manner.
    *
    * @param strTable The name of the database table to retrieve records from.
    * @return {@code true} if records were successfully loaded and displayed,
    *     {@code false} otherwise.
    */
   public static boolean LoadListFromDatabase(String strTable) {
      boolean blnResult = false;

      try {
         String strSelect = "";
         Statement sqlCommand = null;
         ResultSet rstTSource = null;

         // Build the SQL string to select all columns and order by ID
         strSelect = "SELECT * FROM " + strTable + " ORDER BY intLocationID";

         // Retrieve all the records
         sqlCommand = m_conAdministrator.createStatement();
         rstTSource = sqlCommand.executeQuery(strSelect);

         // Print header
         System.out.println(
             "Here are the pickup locations - we will call you with a location confirmation");
         System.out.println(
             "ID    Name        Address           City       Zip");

         // Loop through all the records
         while (rstTSource.next()) {
            int intLocationID = rstTSource.getInt("intLocationID");
            String strName = rstTSource.getString("strName");
            String strAddress = rstTSource.getString("strAddress");
            String strCity = rstTSource.getString("strCity");
            String strZip = rstTSource.getString("strZip");

            // Print the record with aligned columns
            System.out.printf("%-6d%-12s%-18s%-12s%s%n", intLocationID, strName,
                strAddress, strCity, strZip);
         }

         // Clean up
         rstTSource.close();
         sqlCommand.close();
         System.out.println(
             "\n LoadListFromDatabase: RecordSet Closed and Command Closed");

         // Success
         blnResult = true;
      } catch (Exception e) {
         System.out.println("Error loading table");
         System.out.println("Error is " + e);
      }

      return blnResult;
   }

   /**
    * Validates a given phone number based on a regular expression pattern.
    *
    * @param phoneNumber The phone number to be validated. It can be in the
    *     format "1234567890" or "123-456-7890".
    * @return {@code true} if the phone number is valid, {@code false}
    *     otherwise.
    */
   public static boolean IsValidPhoneNumber(String phoneNumber) {
      String regex = "^(\\d{10}|\\d{3}-\\d{3}-\\d{4})$";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(phoneNumber);
      return matcher.matches();
   }

   /**
    * Validates a given email address based on a regular expression pattern.
    *
    * @param email The email address to be validated.
    * @return {@code true} if the email address is valid, {@code false}
    *     otherwise.
    */
   public static boolean IsValidEmailAddress(String email) {
      String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(email);
      return matcher.matches();
   }

   /**
    * Displays customer information, vehicle details, rental prices, and the
    * total rental amount for each customer.
    *
    * @param customers An ArrayList of CCustomer objects containing customer
    *     information and vehicle details.
    */
   public static void displayCustomerInformation(
       ArrayList<CCustomer> customers) {
      for (int intIndex = 0; intIndex < customers.size(); intIndex++) {
         String strLine = "-------------------------------------------------";
         System.out.println(
             strLine + "\nCustomer #" + (intIndex + 1) + "\n" + strLine);

         CCustomer customer = customers.get(intIndex);
         System.out.println("Name: " + customer.getCustomerName());
         System.out.println("Phone Number: " + customer.getPhoneNumber());
         System.out.println("Email Address: " + customer.getEmailAddress());

         CVehicle[] arrVehicles = customer.getArrVehicles();
         double dblTotalRentalCost = 0.0; // Initialize the total cost

         for (int intVehicleIndex = 0; intVehicleIndex < arrVehicles.length;
              intVehicleIndex++) {
            CVehicle vehicle = arrVehicles[intVehicleIndex];
            System.out.println("\nVehicle " + (intVehicleIndex + 1) + ": "
                + vehicle.getVehicleName());
            System.out.println("Type: " + vehicle.getVehicleName());
            System.out.println("Price: $" + vehicle.getPrice() + " per day");

            int intRentalDays = customer.getRentalDays();
            double dblTotalRentalPrice = intRentalDays * vehicle.getPrice();
            System.out.println("Rental Days: " + intRentalDays);
            System.out.println("Total Rental Price: $"
                + String.format("%.2f", dblTotalRentalPrice));

            dblTotalRentalCost +=
                dblTotalRentalPrice; // Accumulate the total cost
         }

         System.out.println("\nTotal Rental Cost for All Vehicles: $"
             + String.format("%.2f", dblTotalRentalCost));
         System.out.println("\n"); // Line break between customers
      }

      System.out.println("\n\n"); // Two line breaks after all customers
   }

   /**
    * The main entry point of the program that gathers customer information and
    * rental details for vehicles. It interacts with a database, loads data, and
    * creates customer objects based on user input. It then displays the
    * information of each customer and their rented vehicles.
    *
    * @param args The command-line arguments (not used in this program).
    */
   public static void main(String[] args) {
      // open the database
      try {
         if (OpenDatabaseConnectionMSAccess()) {
            // Load and print the TLocations table
            LoadListFromDatabase("TLocations");
            System.out.println('\n');

            CloseDatabaseConnection(); // close connection to database
         } else {
            System.out.println("Error connecting to the database");
         }
      } catch (Exception e) {
         System.out.println("An error occurred: " + e.getMessage());
      }

      Scanner scanner = new Scanner(System.in);
      ArrayList<CCustomer> arrCustomers =
          new ArrayList<>(); // Create a list to store customer objects
      String addAnother = "Y"; // Initialize variable to control loop

      while (addAnother.equalsIgnoreCase(
          "Y")) { // Loop to gather customer information
         String strCustomerName;
         String strPhoneNumber;
         String strEmailAddress;
         int intRentalDays;
         int intNumVehicles;
         int intVehicleChoice = 0;

      // Gather customer information
         do {
             System.out.print("Enter Customer Name (letters and spaces only): ");
             strCustomerName = scanner.nextLine();
             if (!strCustomerName.matches("^[a-zA-Z ]+$")) {
                 System.out.println("Invalid input. Please enter letters and spaces only.");
             }
         } while (!strCustomerName.matches("^[a-zA-Z ]+$"));


      // Gather phone number
         do {
             System.out.print("Enter Phone Number (format: 123-456-7890 or 1234567890): ");
             strPhoneNumber = scanner.nextLine();
             
             // Check if the entered phone number is valid
             if (!IsValidPhoneNumber(strPhoneNumber)) {
                 System.out.println("Invalid phone number format. Please enter a valid phone number.");
             }
         } while (!IsValidPhoneNumber(strPhoneNumber));
         
         // Gather email address
         do {
            System.out.print("Enter Email Address: ");
            strEmailAddress = scanner.nextLine();
            if (!IsValidEmailAddress(strEmailAddress)) {
               System.out.println(
                   "Invalid email format. Please enter a valid email address.");
            }
         } while (!IsValidEmailAddress(strEmailAddress));

         // Gather number of rental days
         do {
            System.out.print(
                "Enter Number of Rental Days (must be a positive number): ");
            while (!scanner.hasNextInt()) {
               System.out.println(
                   "Invalid input. Please enter a valid number.");
               scanner.next(); // Consume the invalid input
            }
            intRentalDays = scanner.nextInt();
         } while (intRentalDays <= 0);
         scanner.nextLine(); // Consume newline

         // Gather number of vehicles to rent
         do {
            System.out.print("Enter Number of Vehicles to Rent (1 to 3): ");
            while (!scanner.hasNextInt()) {
               System.out.println(
                   "Invalid input. Please enter a valid number.");
               scanner.next(); // Consume the invalid input
            }
            intNumVehicles = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (intNumVehicles < 1 || intNumVehicles > 3) {
               System.out.println(
                   "Invalid number of vehicles. Please enter a number between 1 and 3.");
            }
         } while (intNumVehicles < 1 || intNumVehicles > 3);

         // Create an array to store rented vehicles
         CVehicle[] customerVehicles = new CVehicle[intNumVehicles];

         // Gather information about each rented vehicle
         for (int intIndex = 0; intIndex < intNumVehicles; intIndex++) {
            System.out.println(
                "Vehicle " + (intIndex + 1) + " of " + intNumVehicles);

            // Gather vehicle type choice
            do {
               System.out.println("Select the type of Vehicle to Rent:");
               System.out.println("1. Car");
               System.out.println("2. Motorbike");
               System.out.println("3. Trailer");
               while (!scanner.hasNextInt()) {
                  System.out.println(
                      "Invalid input. Please enter a valid number.");
                  scanner.next(); // Consume the invalid input
               }
               intVehicleChoice = scanner.nextInt();
               scanner.nextLine(); // Consume newline

               if (intVehicleChoice < 1 || intVehicleChoice > 3) {
                  System.out.println(
                      "Invalid vehicle choice. Please enter a number between 1 and 3.");
               }
            } while (intVehicleChoice < 1 || intVehicleChoice > 3);

            // Create the appropriate vehicle object based on user choice
            switch (intVehicleChoice) {
               case 1:
                  customerVehicles[intIndex] = new CCar();
                  break;
               case 2:
                  customerVehicles[intIndex] = new CMotorbike();
                  break;
               case 3:
                  customerVehicles[intIndex] = new CTrailer();
                  break;
               default:
                  customerVehicles[intIndex] =
                      null; // Handle the default case if needed
            }
         }

      // Create a customer object with gathered information and rented vehicles
         CCustomer customer = new CCustomer(strCustomerName, strPhoneNumber,
                 strEmailAddress, intRentalDays, intNumVehicles, customerVehicles);

         // Add the customer object to the list
         arrCustomers.add(customer);

         // Ask if another customer should be added
         do {
             System.out.print("\n Do you want to add another customer? (Y/N): ");
             addAnother = scanner.nextLine().toUpperCase();
         } while (!addAnother.equals("Y") && !addAnother.equals("N"));
     } while (addAnother.equals("Y"));

      // Close the scanner
      scanner.close();

      // Display customer information for all customers
      System.out.println("\nCustomer Information:");
      displayCustomerInformation(arrCustomers);
   }
}
//
