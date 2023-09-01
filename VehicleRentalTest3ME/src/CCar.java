/**
 * Represents a car, which is a type of vehicle.
 * Cars are motor vehicles with four wheels designed for the transportation of
 * passengers. This class extends the {@link CVehicle} class to provide specific
 * behavior and attributes for cars.
 *
 * @author Million Eyassu
 * @version 1.0
 * @since 2023-08-15 (date when the class was created or last modified)
 */
public class CCar extends CVehicle {
   /**
    * Constructor to create a new car.
    * Initializes a car with four wheels, a specific MPG, a fixed price, and the
    * name "Car".
    */
   public CCar() {
      super(4, 15, 299.99, "Car");
   }

   /**
    * Get instructions on how to drive a car.
    *
    * @return Instructions on how to drive a car using the steering wheel for
    *     control.
    */
   @Override
   public String getHowToDrive() {
      return "Use the steering wheel to drive the car.";
   }
}
