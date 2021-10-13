import javax.swing.DefaultListModel;
import javax.swing.JButton;
public class UploadButton extends JButton implements FTPGUI.CommandInterface {
Mediator mdtr;
public void processEvent() {
  LocalList localList1= mdtr.getLocalList();
  int index = localList1.getSelectedIndex();
  String selectedItem =
    localList1.getSelectedValue().toString();
  ((DefaultListModel) localList1.getModel()).remove(
    index);
  RemoteList remoteList1= mdtr.getRemoteList();
  ((DefaultListModel) remoteList1.getModel()).addElement(
    selectedItem);
  mdtr.UploadItem();
}
public UploadButton(String name, Mediator inp_mdtr) {
  super(name);
  mdtr = inp_mdtr;
  mdtr.registerUploadButton(this);
}
}
