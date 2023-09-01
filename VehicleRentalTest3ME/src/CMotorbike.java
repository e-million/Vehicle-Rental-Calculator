/**
 * Represents a motorbike, which is a type of vehicle.
 * Motorbikes are vehicles with two wheels and are typically designed for one or
 * two riders. This class extends the {@link CVehicle} class to provide specific
 * behavior and attributes for motorbikes.
 *
 * @author Million Eyassu
 * @version 1.0
 * @since 2023-08-15 (date when the class was created or last modified)
 */
public class CMotorbike extends CVehicle {
   /**
    *
    * Constructor to create a new motorbike.
    * Initializes a motorbike with two wheels, a specific MPG, a fixed price,
    * and the name "Motorbike".
    */
   public CMotorbike() {
      super(2, 10, 99.99, "Motorbike");
   }

   /**
    * Get instructions on how to drive a motorbike.
    *
    * @return Instructions on how to drive a motorbike using the handlebars for
    *     control.
    */
   @Override
   public String getHowToDrive() {
      return "Use the handlebars to control the motorbike.";
   }
}
