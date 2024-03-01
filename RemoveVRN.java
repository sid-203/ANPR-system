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

public class RemoveVRN implements ActionListener{
	

	JFrame frame = new JFrame();
	JLabel deleteLabel = new JLabel("VRN delete");
	JLabel searchVRNField = new JLabel("Enter VRN");
	JTextField searchField = new JTextField();
	JButton deleteButton = new JButton("Delete");
	JButton back = new JButton("Back");
	private Scanner x;
	
	
	
	RemoveVRN() {
		
		deleteLabel.setBounds(100, 0, 500, 25);
		deleteLabel.setFont(new Font(null, Font.PLAIN,20));
		
		searchVRNField.setBounds(10, 70, 80, 25);
		searchField.setBounds(100, 70, 165, 25);
		
		deleteButton.setBounds(100, 100, 80, 25);
		deleteButton.addActionListener(this);
		
		back.setBounds(100, 400, 165, 25);
		back.addActionListener(this);
		
		frame.add(deleteLabel);
		frame.setSize(400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(deleteButton);
		frame.add(searchField);
		frame.add(searchVRNField);
		frame.add(back);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==deleteButton) {
			
			String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\VehicleForUPDtxt.txt";
			String editTerm = searchField.getText();
			String newVRN = "";
			String newMake = "";
			String newModel = "";
			String newYear = "";
			String newPNC = "";
			
			
				try {
					deleteRecord(filepath,editTerm,newVRN,newMake,newModel,newYear,newPNC);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			
		}
		
		if (e.getSource()==back) {
			
			AdminPage adminPage = new AdminPage();
			frame.setVisible(false);
			
		}
		
	}

	private void deleteRecord(String filepath, String editTerm, String newVRN, String newmake, String newmodel, String newyear, String newPNC) throws FileNotFoundException 
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
				if (VRN.equals(editTerm)) {
					pw.println(newVRN + "," + newmake + "," + newmodel + "," + newyear + "," + newPNC + "\r");
				}
				else {
					pw.println(VRN + "," + make + "," + model + "," + year + "," + PNC + "\r");
				}
			}
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
