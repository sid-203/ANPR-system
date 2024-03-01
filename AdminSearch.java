package ANPR_system;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AdminSearch implements ActionListener {
	
	JFrame frame = new JFrame();
	JLabel searchLabel = new JLabel("VRN search");
	JLabel searchVRNField = new JLabel("Enter VRN");
	JTextField searchField = new JTextField();
	JButton searchButton = new JButton("search");
	JButton back = new JButton("Back");
	private Scanner x;
	
	
	AdminSearch() {
		
		searchLabel.setBounds(100, 0, 500, 25);
		searchLabel.setFont(new Font(null, Font.PLAIN,20));
		
		searchVRNField.setBounds(10, 70, 80, 25);
		searchField.setBounds(100, 70, 165, 25);
		
		searchButton.setBounds(100, 100, 80, 25);
		searchButton.addActionListener(this);
		
		back.setBounds(100, 400, 165, 25);
		back.addActionListener(this);
		
		frame.add(searchLabel);
		frame.setSize(400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(searchButton);
		frame.add(searchField);
		frame.add(searchVRNField);
		frame.add(back);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==searchButton) {
			
			String path = "C:\\Users\\HP\\eclipse-workspace\\WRIT1\\src\\VehicleForUPD.csv";
			String searchTerm = searchField.getText();
			
			ReadRecord(searchTerm, path);
			
		}
		
       if (e.getSource()==back) {
			
			AdminPage adminPage = new AdminPage();
			frame.setVisible(false);
			
		}
		
	}


	private void ReadRecord(String searchTerm, String path) {
		boolean found = false;
		String VRN = "";
		String Make = "";
		String Model = "";
		String year = "";
		String PNC = "";
		try {
			x = new Scanner(new File(path));
			x.useDelimiter("[,\n]");
			while(x.hasNext() && !found) {
				VRN = x.next();
				Make = x.next();
				Model = x.next();
				year = x.next();
				PNC = x.next();
				if(VRN.equals(searchTerm)) {
					found = true;
				}
			}
			if(found) {
				
				JOptionPane.showMessageDialog(null,"VRN: "+ VRN + " Make: "+ Make + " Model: " + Model + " Year: " + year +  " PNC: " + PNC);
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Record not found");
			}
			
		}
		catch (FileNotFoundException e1) {

			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error");
		}
		
		
	}


}
