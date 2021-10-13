import java.util.*;

public abstract class CreditCard {

  protected String franchise;
  protected String cardNum;
  protected int expMM, expYY;

  public CreditCard(String fran, String num, int expMonth, int expYear) {
    franchise=fran;
	cardNum = num;
    expMM = expMonth;
    expYY = expYear;
  }
  public boolean isExpDtValid() {
	System.out.println("Validating expedition date for " + franchise + "Card...");
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    int mm = cal.get(Calendar.MONTH) + 1;
    int yy = cal.get(Calendar.YEAR);

    boolean result =
      (yy > expYY) || ((yy == expYY) && (mm > expMM));

    return (!result);
  }

  private boolean hasValidChars() {
	  System.out.println("Validating characters for " + franchise + "Card...");
    String validChars = "0123456789";
    boolean result = true;

    for (int i = 0; i < cardNum.length(); i++) {
      if (validChars.indexOf(cardNum.substring(i, i + 1)) <
          0) {
        result = false;
        break;
      }
    }
    return result;
  }

  private boolean isValidCheckSum() {
	  System.out.println("Validating checksum for " + franchise + "Card...");
	  boolean result = true;

    int sum = 0;
    int multiplier = 1;
    int strLen = cardNum.length();

    for (int i = 0; i < strLen; i++) {
      String digit = cardNum.substring(strLen - i - 1,
                     strLen - i);
      int currProduct =
        new Integer(digit).intValue() * multiplier;
      if (currProduct >= 10)
        sum += (currProduct % 10) + 1;
      else
        sum += currProduct;
      if (multiplier == 1)
        multiplier++;
      else
        multiplier--;
    }
    if ((sum % 10) != 0)
      result = false;

    return result;
  }


  /* methods to be overridden by sub-classes. */
  public abstract boolean isNumOfDigitsValid();
  public abstract boolean isValidPrefix();
  public abstract boolean isAccountInGoodStand();

  /* Final method - subclasses cannot overridd */
  public final boolean isValid() {
    if (!isExpDtValid()) {
      System.out.println(" Invalid Exp Dt. for " + franchise + " Card. ");
      return false;
    }
    if (!isNumOfDigitsValid()) {
      System.out.println(" Invalid Number of Digits " + franchise + " Card. ");
      return false;
    }
    if (!isValidPrefix()) {
      System.out.println(" Invalid Prefix " + franchise + " Card. ");
      return false;
    }
    if (!hasValidChars()) {
      System.out.println(" Invalid Characters " + franchise + " Card. ");
      return false;
    }
    if (!isValidCheckSum()) {
      System.out.println(" Invalid Check Sum " + franchise + " Card. ");
      return false;
    }
    if (!isAccountInGoodStand()) {
      System.out.println(
        " Account is Inactive/Revoked/Over the Limit " + franchise + " Card. ");
      return false;
    }
    return true;
  }
}
