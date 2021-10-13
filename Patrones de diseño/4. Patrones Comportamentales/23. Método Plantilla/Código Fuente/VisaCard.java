import java.util.*;

public class VisaCard extends CreditCard {

  public VisaCard(String f,String num, int expMonth, int expYear) {
    super(f,num, expMonth, expYear);
  }

  public boolean isNumOfDigitsValid() {
	System.out.println("Validating number of digits for Visa Card...");
    if ((cardNum.length() == 13) ||
        (cardNum.length() == 16)) {
      return true;
    } else {
      return false;
    }
  }
  public boolean isValidPrefix() {
	System.out.println("Validating prefix for Visa Card...");
    String prefix = cardNum.substring(0, 1);

    if (prefix.equals("4")) {
      return true;
    } else {
      return false;
    }
  }
  public boolean isAccountInGoodStand() {
	System.out.println("Validating good stand for Visa Card...");
    /*
     	Make necessary VISA API calls to
     	perform other checks.
     */
    return true;
  }

}
