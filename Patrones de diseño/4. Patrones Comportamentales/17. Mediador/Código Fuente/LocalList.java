import javax.swing.DefaultListModel;
import javax.swing.JList;

public class LocalList extends JList implements FTPGUI.CommandInterface {
Mediator mdtr;
public void processEvent() {
  mdtr.LocalListSelect();
}
public LocalList(DefaultListModel defObj,
                 Mediator inp_mdtr) {
  super(defObj);
  mdtr = inp_mdtr;
  mdtr.registerLocalList(this);
}
} 
