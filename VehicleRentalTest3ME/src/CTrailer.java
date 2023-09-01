/**
 * Represents a trailer, which is a type of vehicle.
 * Trailers are vehicles that are designed to be pulled by other vehicles and do
 * not have wheels or a specific MPG. This class extends the {@link CVehicle}
 * class to provide specific behavior and attributes for trailers.
 *
 * @author Million Eyassu
 * @version 1.0
 * @since 2023-08-15 (date when the class was created or last modified)
 */
public class CTrailer extends CVehicle {
   /**
    * Constructor to create a new trailer.
    * Initializes a trailer with zero wheels, zero MPG, a fixed price, and the
    * name "Trailer". Since trailers are not self-propelled, the MPG is set to
    * 0.
    */
   public CTrailer() {
      super(0, 0, 149.99, "Trailer"); // Set MPG to 0 for trailers
   }

   /**
    * Get instructions on how to drive a trailer.
    *
    * @return Instructions on how to drive a trailer using another vehicle to
    *     pull it.
    */
   @Override
   public String getHowToDrive() {
      return "Use another vehicle to pull the trailer.";
   }

   /**
    * Get the miles per gallon (MPG) of the trailer.
    * Since trailers are not self-propelled, the MPG is set to 0.
    *
    * @return The miles per gallon of the trailer (always 0 for trailers).
    */
   @Override
   public int getMPG() {
      return 0; // MPG is 0 for trailers
   }
}
