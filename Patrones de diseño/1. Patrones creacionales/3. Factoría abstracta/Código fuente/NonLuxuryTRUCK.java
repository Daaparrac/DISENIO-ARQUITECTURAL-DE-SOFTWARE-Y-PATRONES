public class NonLuxuryTRUCK implements NonLuxury{
    private String name;
    public NonLuxuryTRUCK(String tName) {
      name = tName;
    }
    public String getNLName() {
      return name;
    }
    public String getNLFeatures() {
      return "Non-Luxury TRUCK Features ";
    };
  
  } // End of class
