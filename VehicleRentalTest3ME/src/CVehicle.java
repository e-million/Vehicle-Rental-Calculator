/**
 * Represents a generic vehicle.
 * This class provides basic information about a vehicle, such as its wheel
 * count, miles per gallon (MPG), price, and vehicle name. It also includes
 * methods to retrieve details about driving the vehicle.
 *
 * @author Million Eyassu
 * @version 1.0
 * @since 2023-08-15 (date when the class was created or last modified)
 */

public class CVehicle {
   private int intWheelsCount;
   private int intMPG;
   private String strVehicleName;
   private double dblPrice;

   /**
    * Constructor to create a new vehicle.
    *
    * @param intWheelsCount The number of wheels the vehicle has.
    * @param intMPG         The miles per gallon (MPG) of the vehicle.
    * @param dblPrice       The price of the vehicle.
    * @param strVehicleName The name of the vehicle.
    */
   public CVehicle(
       int intWheelsCount, int intMPG, double dblPrice, String strVehicleName) {
      this.intWheelsCount = intWheelsCount;
      this.intMPG = intMPG;
      this.strVehicleName = strVehicleName;
      this.dblPrice = dblPrice;
   }

   /**
    * Get the description of how to drive the vehicle.
    *
    * @return A description of how to drive the vehicle.
    */
   public String getHowToDrive() {
      return "Drive carefully and follow traffic rules.";
   }

   /**
    * Get the miles per gallon (MPG) of the vehicle.
    *
    * @return The miles per gallon of the vehicle.
    */
   public int getMPG() {
      return intMPG;
   }

   /**
    * Get the number of wheels on the vehicle.
    *
    * @return The number of wheels on the vehicle.
    */
   public int getWheelsCount() {
      return intWheelsCount;
   }

   /**
    * Get the name of the vehicle.
    *
    * @return The name of the vehicle.
    */
   public String getVehicleName() {
      return strVehicleName;
   }

   /**
    * Get the price of the vehicle.
    *
    * @return The price of the vehicle.
    */
   public double getPrice() {
      return dblPrice;
   }
}
