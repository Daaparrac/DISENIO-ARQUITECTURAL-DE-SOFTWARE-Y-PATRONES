public class TRUCKVehicleFactory extends VehicleFactory {

    public LuxuryTRUCK getLuxury() {
        return new LuxuryTRUCK("Luxury-TRUCK");
      }
      public NonLuxuryTRUCK getNonLuxury() {
        return new NonLuxuryTRUCK("Non-Luxury-TRUCK");
      }
} // End of class

