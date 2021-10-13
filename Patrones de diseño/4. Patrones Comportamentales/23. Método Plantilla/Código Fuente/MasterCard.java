import java.util.*;

public class MasterCard extends CreditCard {

  public MasterCard(String f,String num, int expMonth, int expYear) {
    super(f,num, expMonth, expYear);
  }

  public boolean isNumOfDigitsValid() {
	System.out.println("Validating number of digits for Master Card...");
    if (cardNum.length() == 16) {
      return true;
    } else {
      return false;
    }
  }
  public boolean isValidPrefix() {
	System.out.println("Validating prefix for Master Card...");
    String prefix = cardNum.substring(0, 1);
    String nextChar = cardNum.substring(1, 2);
    String validChars = "12345";

    //51-55
    if ((prefix.equals("5")) &&
        (validChars.indexOf(nextChar) >= 0)) {
      return true;
    } else {
      return false;
    }
  }
  public boolean isAccountInGoodStand() {
	System.out.println("Validating good stand for Master Card...");
		/*
     	Make necessary MASTER CARD API calls to
     	perform other checks.
     */
    return true;
  }

}
