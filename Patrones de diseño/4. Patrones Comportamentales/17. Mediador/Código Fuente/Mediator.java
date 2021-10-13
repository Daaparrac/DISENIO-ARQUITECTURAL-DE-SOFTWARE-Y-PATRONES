import javax.swing.DefaultListModel;

public class Mediator {
	private UploadButton btnUpload;
    private DownloadButton btnDownload;
    private DeleteButton btnDelete;
    private LocalList localList;
    private RemoteList remoteList;
    private ExitButton btnExit;

    public void registerUploadButton(UploadButton inp_ib) {
      btnUpload = inp_ib;
    }
    public void registerDownloadButton(
      DownloadButton inp_dnb) {
      btnDownload = inp_dnb;
    }
    public void registerDeleteButton(DeleteButton inp_db) {
      btnDelete = inp_db;
    }
    public void registerLocalList(LocalList inp_arl) {
      localList = inp_arl;
    }
    public void registerRemoteList(RemoteList inp_drl) {
      remoteList = inp_drl;
    }
    public void registerExitButton(ExitButton inp_eb) {
    	btnExit=inp_eb;
    }
    public LocalList getLocalList() {
    	return localList;
    }
    public RemoteList getRemoteList() {
    	return remoteList;
    }
    
    public void UploadItem() {
      btnUpload.setEnabled(false);
      btnDelete.setEnabled(false);
      btnDownload.setEnabled(false);
    }
    public void DownloadItem() {
      btnUpload.setEnabled(false);
      btnDelete.setEnabled(false);
      btnDownload.setEnabled(false);
    }
    public void DeleteItem() {
      btnUpload.setEnabled(false);
      btnDelete.setEnabled(false);
      btnDownload.setEnabled(false);

    }

    public void LocalListSelect() {
      remoteList.setSelectedIndex(-1);
      btnUpload.setEnabled(true);
      btnDelete.setEnabled(true);
      btnDownload.setEnabled(false);
    }
    public void RemoteListSelect() {
      localList.setSelectedIndex(-1);
      btnUpload.setEnabled(false);
      btnDelete.setEnabled(true);
      btnDownload.setEnabled(true);
    }
}
