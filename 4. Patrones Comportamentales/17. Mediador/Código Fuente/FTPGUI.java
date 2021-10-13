import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import com.sun.java.swing.plaf.windows.*;
import java.util.*;

public class FTPGUI extends JFrame {
  public static final String newline = "\n";
  public static final String UPLOAD = "Upload";
  public static final String DOWNLOAD = "Download";
  public static final String DELETE = "Delete";
  public static final String EXIT = "Exit";

  private JPanel pnlFTPUI;
  private LocalList localList;
  private RemoteList remoteList;
  private DefaultListModel defLocalList, defRemoteList;
  private Mediator mdtr = new Mediator();

  public FTPGUI() throws Exception {
    super("Design Patterns By Example - New Mediator Pattern");

    // Create controls
    defLocalList = new DefaultListModel();
    defRemoteList = new DefaultListModel();
    localList = new LocalList(defLocalList, mdtr);
    remoteList = new RemoteList(defRemoteList, mdtr);
    pnlFTPUI = new JPanel();

    localList.setSelectionMode(
      ListSelectionModel.SINGLE_SELECTION);
    localList.setSelectedIndex(-1);
    JScrollPane spLocalList = new JScrollPane(localList);

    remoteList.setSelectionMode(
      ListSelectionModel.SINGLE_SELECTION);
    remoteList.setSelectedIndex(-1);
    JScrollPane spRemoteList = new JScrollPane(remoteList);

    //Create Labels
    JLabel lblLocalList = new JLabel("Local List:");
    JLabel lblRemoteList = new JLabel("Remote List:");
    JLabel lblSpacer = new JLabel("         ");

    //Create buttons
    UploadButton btnUpload =
      new UploadButton(FTPGUI.UPLOAD, mdtr);
    btnUpload.setMnemonic(KeyEvent.VK_U);
    DownloadButton btnDownload =
      new DownloadButton(FTPGUI.DOWNLOAD, mdtr);
    btnDownload.setMnemonic(KeyEvent.VK_N);
    DeleteButton btnDelete =
      new DeleteButton(FTPGUI.DELETE, mdtr);
    btnDelete.setMnemonic(KeyEvent.VK_D);
    ExitButton btnExit = new ExitButton(FTPGUI.EXIT, mdtr);
    btnExit.setMnemonic(KeyEvent.VK_X);

    buttonHandler vf = new buttonHandler();
    listHandler lh = new listHandler();

    btnUpload.addActionListener(vf);
    btnDownload.addActionListener(vf);
    btnDelete.addActionListener(vf);
    btnExit.addActionListener(vf);
    localList.addListSelectionListener(lh);
    remoteList.addListSelectionListener(lh);

    JPanel lstPanel = new JPanel();

    GridBagLayout gridbag2 = new GridBagLayout();
    lstPanel.setLayout(gridbag2);
    GridBagConstraints gbc2 = new GridBagConstraints();
    lstPanel.add(lblLocalList);
    lstPanel.add(lblRemoteList);
    lstPanel.add(spLocalList);
    lstPanel.add(spRemoteList);
    lstPanel.add(lblSpacer);

    gbc2.gridx = 0;
    gbc2.gridy = 0;
    gridbag2.setConstraints(lblLocalList, gbc2);
    gbc2.gridx = 1;
    gbc2.gridy = 0;
    gridbag2.setConstraints(lblSpacer, gbc2);

    gbc2.gridx = 5;
    gbc2.gridy = 0;
    gridbag2.setConstraints(lblRemoteList, gbc2);
    gbc2.gridx = 0;
    gbc2.gridy = 1;
    gridbag2.setConstraints(spLocalList, gbc2);
    gbc2.gridx = 5;
    gbc2.gridy = 1;
    gridbag2.setConstraints(spRemoteList, gbc2);

    //-----------------------------------
    //For layout purposes, put the buttons in a separate panel
    JPanel buttonPanel = new JPanel();

    //----------------------------------------------
    GridBagLayout gridbag = new GridBagLayout();
    buttonPanel.setLayout(gridbag);
    GridBagConstraints gbc = new GridBagConstraints();
    buttonPanel.add(lstPanel);
    buttonPanel.add(btnUpload);
    buttonPanel.add(btnDownload);
    buttonPanel.add(btnDelete);
    buttonPanel.add(btnExit);

    gbc.insets.top = 5;
    gbc.insets.bottom = 5;
    gbc.insets.left = 5;
    gbc.insets.right = 5;

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 0;
    gridbag.setConstraints(btnUpload, gbc);
    gbc.gridx = 2;
    gbc.gridy = 0;
    gridbag.setConstraints(btnDownload, gbc);
    gbc.gridx = 3;
    gbc.gridy = 0;
    gridbag.setConstraints(btnDelete, gbc);
    gbc.gridx = 4;
    gbc.gridy = 0;
    gridbag.setConstraints(btnExit, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    gridbag.setConstraints(lstPanel, gbc);

    gbc.anchor = GridBagConstraints.EAST;
    gbc.insets.left = 2;
    gbc.insets.right = 2;
    gbc.insets.top = 40;

    //****************************************************
    //Add the buttons and the log to the frame
    Container contentPane = getContentPane();
    contentPane.add(lstPanel, BorderLayout.CENTER);
    contentPane.add(buttonPanel, BorderLayout.SOUTH);

    btnUpload.setEnabled(false);
    btnDelete.setEnabled(false);
    btnDownload.setEnabled(false);

    initialize();
    try {
/*      UIManager.setLookAndFeel(new WindowsLookAndFeel()); */
      SwingUtilities.updateComponentTreeUI(FTPGUI.this);
    } catch (Exception ex) {
      System.out.println(ex);
    }

  }
  private void initialize() {
    // fill some test data here into the listbox.
    defLocalList.addElement("first.html");
    defLocalList.addElement("second.html");
    defLocalList.addElement("third.html");
    defLocalList.addElement("fourth.html");
    defLocalList.addElement("fifth.html");
    defLocalList.addElement("Design Patterns.html");

    defRemoteList.addElement("sixth.html");
    defRemoteList.addElement("seventh.html");
    defRemoteList.addElement("eighth.html");
    defRemoteList.addElement("ninth.html");
    defRemoteList.addElement("Design Patterns By Ex.html");

  }

  public static void main(String[] args) throws Exception {

    JFrame frame = new FTPGUI();
    frame.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            System.exit(0);
          }
        }
                           );

    //frame.pack();
    frame.setSize(450, 300);
    frame.setVisible(true);
  }
  
  
class listHandler implements ListSelectionListener {
    public void valueChanged(ListSelectionEvent e) {
      CommandInterface CommandObj =
        (CommandInterface) e.getSource();
      CommandObj.processEvent();
    }

  }

  class buttonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      CommandInterface CommandObj =
        (CommandInterface) e.getSource();
      CommandObj.processEvent();
    }

    public buttonHandler() {
    }
  }

interface CommandInterface {
    public void processEvent();
  }
}// end of class

