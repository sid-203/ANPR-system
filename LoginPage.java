package ANPR_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginPage implements ActionListener {

	
	   JFrame frame = new JFrame();	    
	   JLabel UserIDlabel = new JLabel("UserID");   
	   JTextField userField = new JTextField();
	   JLabel Passwordlabel = new JLabel("Password");
	   JPasswordField PasswordField = new JPasswordField();
	   JButton button = new JButton("Log in");
	   JButton ResetButton = new JButton("Reset");
	   JLabel messageLabel = new JLabel("");
	   
	   String[] options = {"Select","User","Admin"};
	   JComboBox comboBox = new JComboBox(options);

	 
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	LoginPage(HashMap<String,String> loginInfoOriginal) {
		logininfo = loginInfoOriginal;
		
		   frame.setSize(400, 500);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame.setLayout(null);

		  
		   UserIDlabel.setBounds(10, 20, 80, 25); 
		   userField.setBounds(100, 20, 165, 25);

		   Passwordlabel.setBounds(10, 50, 80, 25);		   
		   PasswordField.setBounds(100, 50, 165, 25);

		   button.setBounds(125, 150, 80, 25);
		   button.addActionListener(this);
		   
		   ResetButton.setBounds(200, 150, 80, 25);
		   ResetButton.addActionListener(this);
		   
		   comboBox.setBounds(10,80,80,25);
		   		   
		   messageLabel.setBounds(10, 200, 500, 55);
		   messageLabel.setFont(new Font(null,Font.ITALIC,20));
		  
		   frame.setVisible(true);
		   frame.add(ResetButton);
		   frame.add(PasswordField);
		   frame.add(comboBox);
		   frame.add(Passwordlabel);
		   frame.add(UserIDlabel);
		   frame.add(button);
		   frame.add(messageLabel);
		   frame.add(userField);
		   
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==ResetButton) {
			userField.setText("");
			PasswordField.setText("");
		}
		
		if(e.getSource()==button) {
			
			String userID = userField.getText();
			String password = String.valueOf(PasswordField.getPassword());
			String item = (String) comboBox.getSelectedItem();
			
			if(logininfo.containsKey(userID)) {
				if(logininfo.get(userID).equals(password)){
					if(item.equals("Admin")) {
						messageLabel.setForeground(Color.green);
						messageLabel.setText("Loged in as admin");
						AdminPage adminPage = new AdminPage();
						frame.setVisible(false);
				}
					else if(item.equals("User")) {
						messageLabel.setForeground(Color.green);
						messageLabel.setText("Loged in as user");
						UserPage userPage = new UserPage();
						frame.setVisible(false);
					}
					else {
						messageLabel.setForeground(Color.red);
						messageLabel.setText("Please select a mode");
					}
			}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong Password");
				}
		}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("UserID not found");
			}
		
	}

}
}
