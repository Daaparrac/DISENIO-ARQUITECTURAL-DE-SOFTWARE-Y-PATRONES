import javax.swing.JButton;
public class ExitButton extends JButton implements FTPGUI.CommandInterface {
	Mediator mdtr;
	public void processEvent() {
		System.exit(1);
	}
	public ExitButton(String name, Mediator inp_mdtr) {
		  super(name);
		  mdtr = inp_mdtr;
		  mdtr.registerExitButton(this);
		}
} 
