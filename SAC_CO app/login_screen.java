import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.UIDefaults.ActiveValue;

public class login_screen implements ActionListener {
  JLabel introJLabel;
  JLabel messagelablel;
  JFrame frame;
  JLabel user;
  JTextField username;
  JLabel password;
  JTextField passwordField;
  JButton login;
  JButton sign_in;
  String accountname;
  HashMap<String, String> loginInfo = new HashMap<String, String>();
  String Acccount_pass;

  public login_screen(HashMap<String, String> loginuser) {

    loginInfo = loginuser;

    frame = new JFrame();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridBagLayout());
    GridBagConstraints pos = new GridBagConstraints();
    pos.fill = GridBagConstraints.BOTH;

    introJLabel = new JLabel("SACCO");
    introJLabel.setFont(new Font("Garamond", 0, 55));
    pos.gridx = 0;
    pos.gridy = 0;
    pos.insets = new Insets(0, 0, 30, 0);
    pos.anchor = GridBagConstraints.NORTH;
    frame.add(introJLabel, pos);

    user = new JLabel("username");
    user.setFont(new Font("Ariel", 0, 15));
    pos.gridx = 0;
    pos.gridy = 1;
    frame.add(user, pos);

    username = new JTextField();
    username.setColumns(15);
    pos.gridx = 1;
    pos.gridy = 1;
    frame.add(username, pos);

    password = new JLabel("password");
    password.setFont(new Font("Ariel", 0, 15));
    pos.gridx = 0;
    pos.gridy = 2;
    pos.insets = new Insets(25, 0, 0, 0);
    frame.add(password, pos);

    passwordField = new JTextField();
    passwordField.setColumns(15);
    pos.gridx = 1;
    pos.gridy = 2;
    pos.insets = new Insets(25, 0, 0, 0);
    frame.add(passwordField, pos);

    JLabel no_account = new JLabel("not signed in:");
    no_account.setFont(new Font("Garamond", 0, 20));
    pos.gridx = 0;
    pos.gridy = 4;
    pos.insets = new Insets(55, 0, 0, 0);
    frame.add(no_account, pos);

    login = new JButton("Log_in");
    login.setSize(200, 40);
    pos.gridwidth = 200;
    pos.gridx = 0;
    pos.gridy = 3;
    login.addActionListener(this);
    frame.add(login, pos);

    sign_in = new JButton("Sign_in");
    sign_in.setSize(10, 20);
    pos.gridx = 1;
    pos.gridy = 4;
    pos.insets = new Insets(55, 0, 0, 0);
    sign_in.addActionListener(this);
    frame.add(sign_in, pos);

     messagelablel = new JLabel("");
    no_account.setFont(new Font("Garamond", 0, 20));
    pos.gridx = 0;
    pos.gridy = 6;
    pos.insets = new Insets(55, 0, 0, 0);
    frame.add(messagelablel, pos);




    frame.setSize(500, 500);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if (source == login) {
      accountname = username.getText();
      Acccount_pass = passwordField.getText();
//change this to a try catch statment for opening am SQL database
      if (loginInfo.containsKey(accountname)) {
        if (loginInfo.get(accountname).equals(Acccount_pass)) {
        
        
          messagelablel.setText("welcome");
          frame.dispose();
          welcomepage welcomepage=new welcomepage();
        
         

        } 
        {
        messagelablel.setText("wrong password");
        passwordField.setText("");
       }
      }
      else
      {
        messagelablel.setText("username not found");
        username.setText("");
        passwordField.setText("");
        

      }
     
     

    }

  }

  

}