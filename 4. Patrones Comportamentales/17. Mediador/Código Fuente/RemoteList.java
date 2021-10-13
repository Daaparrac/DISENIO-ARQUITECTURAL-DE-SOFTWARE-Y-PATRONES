import javax.swing.DefaultListModel;
import javax.swing.JList;

public class RemoteList extends JList implements FTPGUI.CommandInterface {
Mediator mdtr;
public void processEvent() {
  mdtr.RemoteListSelect();
}
public RemoteList(DefaultListModel defObj,
                  Mediator inp_mdtr) {
  super(defObj);
  mdtr = inp_mdtr;
  mdtr.registerRemoteList(this);
}
}
