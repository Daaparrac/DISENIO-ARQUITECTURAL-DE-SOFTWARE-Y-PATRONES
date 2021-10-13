import javax.swing.DefaultListModel;
import javax.swing.JButton;
public class DeleteButton extends JButton implements FTPGUI.CommandInterface {
Mediator mdtr;
public void processEvent() {
  LocalList localList1= mdtr.getLocalList();
  int index = localList1.getSelectedIndex();
  if (index >= 0) {
    ((DefaultListModel) localList1.getModel()).remove(
      index);
  }
  RemoteList remoteList1= mdtr.getRemoteList();
  index = remoteList1.getSelectedIndex();
  if (index >= 0) {
    ((DefaultListModel) remoteList1.getModel()).remove(
      index);
  }
  mdtr.DeleteItem();
}
public DeleteButton(String name, Mediator inp_mdtr) {
  super(name);
  mdtr = inp_mdtr;
  mdtr.registerDeleteButton(this);
}
}

