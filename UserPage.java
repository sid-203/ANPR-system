package ANPR_system;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserPage implements ActionListener {
	JFrame frame = new JFrame();
	JLabel UserLabel = new JLabel("Welcome to User mode!");
	JButton dailyVRN = new JButton("Display");
	JButton back = new JButton("Back");
	
	UserPage() {
		
		UserLabel.setBounds(0, 0, 500, 150);
		UserLabel.setFont(new Font(null,Font.PLAIN,25));
		
		dailyVRN.setBounds(0, 150, 80, 25);
		dailyVRN.addActionListener(this);
		
		back.setBounds(100, 400, 165, 25);
		back.addActionListener(this);
		
		frame.add(UserLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,500);
		frame.add(dailyVRN);
		frame.add(back);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
if (e.getSource()== dailyVRN) {
			
	String path = "C:\\Users\\HP\\eclipse-workspace\\WRIT1\\src\\DailyVRN.csv";
	String line = "";
			
			try {
				BufferedReader br = new BufferedReader(new FileReader(path));
				
				while((line = br.readLine()) != null) {
					System.out.println(line);
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

if (e.getSource()==back) {
	
	IDandPasswords idandpasswords = new IDandPasswords();
	
	LoginPage loginPage = new LoginPage(idandpasswords.getlogininfo());
	frame.setVisible(false);
	
}	
	}
}
