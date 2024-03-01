package ANPR_system;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddVRN implements ActionListener{
	
	JFrame frame = new JFrame();
	JLabel 	addLabel = new JLabel("Add VRN");
	JLabel newVRNField = new JLabel("Enter VRN");
	JLabel newMake = new JLabel("new Make");
	JLabel newModel = new JLabel("new Model");
	JLabel newYear = new JLabel("new Year");
	JLabel newPNC = new JLabel("new PNC");
	JTextField newMakeField = new JTextField();
	JTextField newModelField = new JTextField();
	JTextField newYearField = new JTextField();
	JTextField newPNCField = new JTextField();
	JTextField VRNField = new JTextField();
	JButton addButton = new JButton("Add");
	JButton back = new JButton("Back");
	private Scanner x;
	
	AddVRN() {
		
		addLabel.setBounds(100, 0, 500, 25);
		addLabel.setFont(new Font(null, Font.PLAIN,20));

		newVRNField.setBounds(10, 100, 80, 25);
		VRNField.setBounds(100, 100, 165, 25);
		
		newMake.setBounds(10, 130, 80, 25);
		newMakeField.setBounds(100, 130, 165, 25);
		
		newModel.setBounds(10, 160, 80, 25);
		newModelField.setBounds(100, 160, 165, 25);
		
		newYear.setBounds(10, 190, 80, 25);
		newYearField.setBounds(100, 190, 165, 25);
		
		newPNC.setBounds(10, 220, 80, 25);
		newPNCField.setBounds(100, 220, 165, 25);
		
		addButton.setBounds(100, 250, 80, 25);
		addButton.addActionListener(this);
		
		back.setBounds(100, 400, 165, 25);
		back.addActionListener(this);
		
		
		frame.add(addLabel);
		frame.setSize(400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(addButton);
		frame.add(newVRNField);
		frame.add(VRNField);
		frame.add(back);
		frame.add(newMake);
		frame.add(newMakeField);
		frame.add(newModel);
		frame.add(newModelField);
		frame.add(newYear);
		frame.add(newYearField);
		frame.add(newPNC);
		frame.add(newPNCField);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==addButton) {
			
			String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\VehicleForUPDtxt.txt";
			String newVRN = VRNField.getText();
			String newMake = newMakeField.getText();
			String newModel = newModelField.getText();
			String newYear = newYearField.getText();
			String newPNC = newPNCField.getText();
	
	
			try {
				addRecord(filepath,newVRN,newMake,newModel,newYear,newPNC);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		
		if (e.getSource()==back) {
			
			AdminPage adminPage = new AdminPage();
			
		}	
		
	}

	private void addRecord(String filepath, String newVRN, String newmake, String newmodel, String newyear, String newPNC) throws FileNotFoundException 
	{
		String tempFile = "C:/Users/HP/OneDrive/Desktop/temp.txt";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		String VRN = ""; String make = ""; String model = ""; String year = ""; String PNC = "";
		
		try {
			FileWriter fw = new FileWriter(tempFile,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext()) {
				VRN = x.next();
				make = x.next();
				model = x.next();
				year = x.next();
				PNC = x.next();
				
					pw.println(VRN + "," + make + "," + model + "," + year + "," + PNC + "\r");
			}
			
			pw.println(newVRN + "," + newmake + "," + newmodel + "," + newyear + "," + newPNC + "\r");
			
			x.close();
			pw.flush();
			pw.close();
			File zabi = new File("C:\\Users\\HP\\OneDrive\\Desktop\\VehicleForUPD.csv");
			zabi.delete();
			File dump = new File("C:\\Users\\HP\\OneDrive\\Desktop\\VehicleForUPD.csv");
			newFile.renameTo(dump);
			
			
		} catch (IOException el) {

			System.out.println("Error");
		}
	}
		
	}

