package ANPR_system;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AdminPage implements ActionListener {
	
	JFrame frame = new JFrame();
	JLabel AdminLabel = new JLabel("Welcome to Admin mode!");
	JLabel dailyVRNLabel = new JLabel("Today's VRNs");
	JLabel vehicleForUPDLabel = new JLabel("UPD vehicles");
	JButton DailyVRN = new JButton("Display");
	JButton editDaily = new JButton("Edit");
	JButton vehicleForUPD = new JButton("Display");
	JButton editUPD = new JButton("edit");
	JButton search = new JButton("search for a VRN");
	JButton back = new JButton("Back");
	JButton delete = new JButton("Delete");
	JButton add = new JButton("Add");
	
	
	AdminPage() {
		
		AdminLabel.setBounds(0, 0, 500, 100);
		AdminLabel.setFont(new Font(null,Font.PLAIN,25));
		
		DailyVRN.setBounds(0, 110, 80, 25);
		DailyVRN.addActionListener(this);
		
		dailyVRNLabel.setBounds(0, 30, 300, 100);
		dailyVRNLabel.setFont(new Font(null,Font.PLAIN,15));
		
		editDaily.setBounds(100, 110, 80, 25);
		editDaily.addActionListener(this);
		
		vehicleForUPD.setBounds(0, 200, 80, 25);
		vehicleForUPD.addActionListener(this);
		
		editUPD.setBounds(100, 200, 80, 25);
		editUPD.addActionListener(this);
		
		vehicleForUPDLabel.setBounds(0, 130, 300, 100);
		vehicleForUPDLabel.setFont(new Font(null,Font.PLAIN,15));
		
		search.setBounds(100, 300, 150, 25);
		search.addActionListener(this);
		
		back.setBounds(100, 400, 150, 25);
		back.addActionListener(this);
		
		delete.setBounds(200, 200, 80, 25);
		delete.addActionListener(this);
		
		add.setBounds(300, 200, 80, 25);
		add.addActionListener(this);
		
		frame.add(AdminLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,500);
		frame.add(dailyVRNLabel);
		frame.add(DailyVRN);
		frame.add(editDaily);
		frame.add(vehicleForUPD);
		frame.add(editUPD);
		frame.add(vehicleForUPDLabel);
		frame.add(delete);
		frame.add(back);
		frame.add(search);
		frame.add(add);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()== DailyVRN) {
			
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
		
		if (e.getSource()== vehicleForUPD) {
			
			String path = "C:\\Users\\HP\\OneDrive\\Desktop\\VehicleForUPDtxt.txt";
			String line = "";
			
			try {
				BufferedReader reader = new BufferedReader(new FileReader(path));
				
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}
			} catch (FileNotFoundException el) {
				el.printStackTrace();
			} catch (IOException el) {
				el.printStackTrace();
			}
		}
		
		if (e.getSource()==search) {
			
			AdminSearch adminSearch = new AdminSearch();
			frame.setVisible(false);
		}
		
		if (e.getSource()==editUPD) {
			
			EditVehicleForUPD editVehicle = new EditVehicleForUPD();
			frame.setVisible(false);
		}
		
		if (e.getSource()==editDaily) {
			
			EditDailyVRN editDailyVRN = new EditDailyVRN();
			frame.setVisible(false);
		}
		
		if (e.getSource()==back) {
			
			IDandPasswords idandpasswords = new IDandPasswords();
			
			LoginPage loginPage = new LoginPage(idandpasswords.getlogininfo());
			frame.setVisible(false);
			
		}
		
		if (e.getSource()==delete) {
			
			RemoveVRN removeVRN = new RemoveVRN();
			frame.setVisible(false);
			
		}
		
		if (e.getSource()==add) {
			
			AddVRN addVRN = new AddVRN();
			frame.setVisible(false);
			
		}
					
	}
		
	 }