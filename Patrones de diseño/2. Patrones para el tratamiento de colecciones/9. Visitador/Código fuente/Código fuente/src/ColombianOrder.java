
public class ColombianOrder implements Order {

	 private double orderAmount;
	 private double additionalSH;

	  public ColombianOrder() {
	  }
	  
	  public ColombianOrder(double inp_orderAmount,
	      double inp_additionalSH) {
	    orderAmount = inp_orderAmount;
	    additionalSH = inp_additionalSH;
	  }
	  
	  public double getOrderAmount() {
	    return orderAmount;
	  }
	  
	  public double getAdditionalSH() {
	    return additionalSH;
	  }
	
	@Override
	public void accept(OrderVisitor v) {
		v.visit(this);
	}
	
}
