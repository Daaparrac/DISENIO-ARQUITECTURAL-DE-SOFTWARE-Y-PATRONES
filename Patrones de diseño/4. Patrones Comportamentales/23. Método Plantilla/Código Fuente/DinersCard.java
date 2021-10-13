import java.util.*;

public class DinersCard extends CreditCard {

  public DinersCard(String f,String num, int expMonth, int expYear) {
    super(f,num, expMonth, expYear);
  }

  public boolean isNumOfDigitsValid() {
  	System.out.println("Validating number of digits for Diners Card...");
    if (cardNum.length() == 14) {
      return true;
    } else {
      return false;
    }
  }
  public boolean isValidPrefix() {
 	System.out.println("Validating prefix for Diners Card...");
    String prefix = cardNum.substring(0, 1);
    String nextChar = cardNum.substring(1, 2);
    String validChars = "068";

    //51-55
    if ((prefix.equals("3")) &&
        (validChars.indexOf(nextChar) >= 0)) {
      return true;
    } else {
      return false;
    }
  }
  public boolean isAccountInGoodStand() {
    System.out.println("Validating good stand for Diners Card...");
	  /*
     	Make necessary DINERS CARD API calls to
     	perform other checks.
     */
    return true;
  }

}
