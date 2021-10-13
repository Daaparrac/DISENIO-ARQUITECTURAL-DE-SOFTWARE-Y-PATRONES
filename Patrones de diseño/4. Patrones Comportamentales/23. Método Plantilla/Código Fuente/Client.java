import java.util.*;

public class Client {

  public static void main(String[] args) {
    CreditCard cc = new VisaCard("Visa","4234123412341232",11, 2020);
    if (cc.isValid())
    System.out.println("Valid Credit Card Information for Visa Card");
	System.out.println("*******************************************************");
    CreditCard cc1= new MasterCard("Master","5423412341234123",11, 2020); 
    if (cc1.isValid())
        System.out.println("Valid Credit Card Information for Master Card");
	System.out.println("*******************************************************");
    CreditCard cc2= new DinersCard("Diners","54234123412341",11, 2020); 
    if (cc2.isValid())
        System.out.println("Valid Credit Card Information for DinersCard Card");
	System.out.println("*******************************************************");
  }
}
