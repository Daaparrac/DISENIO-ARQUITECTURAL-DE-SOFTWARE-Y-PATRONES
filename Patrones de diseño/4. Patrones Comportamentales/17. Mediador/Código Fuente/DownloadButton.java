import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class DownloadButton extends JButton implements FTPGUI.CommandInterface {
Mediator mdtr;
public void processEvent() {
  RemoteList remoteList1= mdtr.getRemoteList();
  int index = remoteList1.getSelectedIndex();
  String selectedItem =
    remoteList1.getSelectedValue().toString();
  ((DefaultListModel) remoteList1.getModel()).remove(
    index);
  LocalList localList1 = mdtr.getLocalList();
  ((DefaultListModel) localList1.getModel()).addElement(
    selectedItem);
  mdtr.DownloadItem();
}
public DownloadButton(String name, Mediator inp_mdtr) {
  super(name);
  mdtr = inp_mdtr;
  mdtr.registerDownloadButton(this);
}
}
