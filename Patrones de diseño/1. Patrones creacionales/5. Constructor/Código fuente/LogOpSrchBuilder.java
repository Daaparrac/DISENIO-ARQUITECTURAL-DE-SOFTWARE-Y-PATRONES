import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.sun.java.swing.plaf.windows.*;
import java.util.*;

class LogOpSrchBuilder extends UIBuilder {
  private JTextField txtUserName = new JTextField(15);
  private JTextField txtNIT = new JTextField(10);
  private JTextField txtAddress = new JTextField(15);
  private JTextField txtPhone = new JTextField(10);
  private JTextField txtRegional = new JTextField(10);

  public void addUIControls() {
    searchUI = new JPanel();
    JLabel lblUserName = new JLabel("Name :");
    JLabel lblNIT = new JLabel("Regional scope :");
    JLabel lblAddress = new JLabel("Address :");
    JLabel lblPhone = new JLabel("Phone number 1 :");
    JLabel lblRegional = new JLabel("Regional scope :");

    GridBagLayout gridbag = new GridBagLayout();
    searchUI.setLayout(gridbag);
    GridBagConstraints gbc = new GridBagConstraints();
    searchUI.add(lblUserName);
    searchUI.add(txtUserName);
    searchUI.add(lblNIT);
    searchUI.add(txtNIT);
    searchUI.add(lblAddress);
    searchUI.add(txtAddress);
    searchUI.add(lblPhone);
    searchUI.add(txtPhone);
    searchUI.add(lblRegional);
    searchUI.add(txtRegional);

    gbc.anchor = GridBagConstraints.WEST;

    gbc.insets.top = 5;
    gbc.insets.bottom = 5;
    gbc.insets.left = 5;
    gbc.insets.right = 5;

    gbc.gridx = 0;
    gbc.gridy = 0;
    gridbag.setConstraints(lblUserName, gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    gridbag.setConstraints(lblNIT, gbc);
    gbc.gridx = 0;
    gbc.gridy = 2;
    gridbag.setConstraints(lblAddress, gbc);
    gbc.gridx = 0;
    gbc.gridy = 3;
    gridbag.setConstraints(lblPhone, gbc);
    gbc.gridx = 0;
    gbc.gridy = 4;
    gridbag.setConstraints(lblRegional, gbc);

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 0;
    gridbag.setConstraints(txtUserName, gbc);
    gbc.gridx = 1;
    gbc.gridy = 1;
    gridbag.setConstraints(txtNIT, gbc);
    gbc.gridx = 1;
    gbc.gridy = 2;
    gridbag.setConstraints(txtAddress, gbc);
    gbc.gridx = 1;
    gbc.gridy = 3;
    gridbag.setConstraints(txtPhone, gbc);
    gbc.gridx = 1;
    gbc.gridy = 4;
    gridbag.setConstraints(txtRegional, gbc);
  }

  public void initialize() {
    txtUserName.setText("Enter UserName Here");
    txtNIT.setText("XXX.XXX.XXX - Y");
    txtAddress.setText("Enter Address Here");
    txtPhone.setText("(+57)3001234567");
    txtRegional.setText("Colombia");
  }

  public String getSQL() {
    return ("Select * from LogisticsOperator where Username='" +
    txtUserName.getText() + "'" + " and NIT='" +
            txtNIT.getText() + "'" + " and Address='" +
            txtAddress.getText() + "' and Phone='" +
            txtPhone.getText() + "' and RegionalScope='" +
            txtRegional.getText() + "'");

  }

}
