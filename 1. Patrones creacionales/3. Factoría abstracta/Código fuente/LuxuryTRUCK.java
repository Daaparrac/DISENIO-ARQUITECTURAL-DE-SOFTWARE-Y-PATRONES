public class LuxuryTRUCK implements Luxury{
    private String name;
  public LuxuryTRUCK(String tName) {
    name = tName;
  }
  public String getLuxuryName() {
    return name;
  }
  public String getLuxuryFeatures() {
    return "Luxury Truck Features ";
  };

} // End of class
