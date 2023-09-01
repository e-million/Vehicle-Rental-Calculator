/**
 * Represents a customer who rents vehicles.
 * This class holds information about a customer's name, contact details,
 * rental information, and the vehicles they are renting.
 * Customers can rent up to three vehicles, and details about each vehicle are
 * stored in an array.
 *
 * @author Million Eyassu
 * @version 1.0
 * @since 2023-08-15 (date when the class was created or last modified)
 */

class CCustomer {
   private String strCustomerName;
   private String strPhoneNumber;
   private String strEmailAddress;
   private int intRentalDays;
   private CVehicle[] arrVehicles; // Array to hold vehicle objects
   private int intNumVehicles;

   /**
    * Constructor to create a new customer with rental information.
    *
    * @param strCustomerName  The name of the customer.
    * @param strPhoneNumber   The phone number of the customer.
    * @param strEmailAddress The email address of the customer.
    * @param intRentalDays    The number of days for the rental.
    * @param intNumVehicles   The number of vehicles the customer is renting.
    * @param arrVehicles      An array of vehicle objects the customer is
    *     renting.
    */
   public CCustomer(String strCustomerName, String strPhoneNumber,
       String strEmailAddress, int intRentalDays, int intNumVehicles,
       CVehicle[] arrVehicles) {
      this.strCustomerName = strCustomerName;
      this.strPhoneNumber = strPhoneNumber;
      this.strEmailAddress = strEmailAddress;
      this.intRentalDays = intRentalDays;
      this.intNumVehicles = intNumVehicles;

      // Make sure the number of vehicles is not more than 3
      int intMaxNumVehicles = Math.min(intNumVehicles, 3);
      this.arrVehicles = new CVehicle[intMaxNumVehicles];
      System.arraycopy(arrVehicles, 0, this.arrVehicles, 0, intMaxNumVehicles);
   }

   // Getters

   /**
    * Get the name of the customer.
    *
    * @return The name of the customer.
    */
   public String getCustomerName() {
      return strCustomerName;
   }

   /**
    * Get the phone number of the customer.
    *
    * @return The phone number of the customer.
    */
   public String getPhoneNumber() {
      return strPhoneNumber;
   }

   /**
    * Get the email address of the customer.
    *
    * @return The email address of the customer.
    */
   public String getEmailAddress() {
      return strEmailAddress;
   }

   /**
    * Get the number of rental days.
    *
    * @return The number of rental days.
    */
   public int getRentalDays() {
      return intRentalDays;
   }

   /**
    * Get the total number of vehicles the customer is renting.
    *
    * @return The total number of vehicles.
    */
   public int getNumVehicles() {
      return intNumVehicles;
   }

   /**
    * Get an array of vehicle types that the customer is renting.
    *
    * @return An array of vehicle types.
    */
   public String[] getVehicleTypes() {
      String[] arrVehicleTypes = new String[arrVehicles.length];
      for (int intIndex = 0; intIndex < arrVehicles.length; intIndex++) {
         arrVehicleTypes[intIndex] = arrVehicles[intIndex].getVehicleName();
      }
      return arrVehicleTypes;
   }

   /**
    * Get an array of rented vehicle objects that the customer is renting.
    *
    * @return An array of rented vehicle objects.
    */
   public CVehicle[] getArrVehicles() {
      return arrVehicles;
   }

   /**
    * Display information about the rented vehicles.
    */
   public void displayRentedVehicleInfo() {
      System.out.println("Rented Vehicle Information:");
      System.out.println();

      for (int intIndex = 0; intIndex < arrVehicles.length; intIndex++) {
         CVehicle vehicle = arrVehicles[intIndex];
         if (vehicle != null) {
            System.out.println("Vehicle: " + vehicle.getVehicleName());
            System.out.println("MPG: " + vehicle.getMPG());
            System.out.println("Price per Day: " + vehicle.getPrice());
            System.out.println("How to Drive: " + vehicle.getHowToDrive());
            System.out.println();
         }
      }
   }
}
