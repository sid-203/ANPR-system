package ANPR_system;

import java.awt.Font; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class EditDailyVRN implements ActionListener{
	
	
	JFrame frame = new JFrame();
	JLabel editLabel = new JLabel("Edit VRN records");
	JLabel editVRN = new JLabel("Enter VRN");
	JLabel newVRN = new JLabel("new VRN");
	JLabel newPNC = new JLabel("new PNC");
	JTextField editField = new JTextField();
	JTextField newVRNField = new JTextField();
	JTextField newPNCField = new JTextField();
	JButton editButton = new JButton("edit");
	JButton back = new JButton("Back");
	private Scanner x;
	
	EditDailyVRN() {
		
		editLabel.setBounds(100, 0, 500, 25);
		editLabel.setFont(new Font(null, Font.PLAIN,20));
		
		editVRN.setBounds(10, 70, 80, 25);
		editField.setBounds(100, 70, 165, 25);
		
		newVRN.setBounds(10, 100, 80, 25);
		newVRNField.setBounds(100, 100, 165, 25);

		newPNC.setBounds(10, 220, 80, 25);
		newPNCField.setBounds(100, 220, 165, 25);
		
		editButton.setBounds(100, 250, 80, 25);
		editButton.addActionListener(this);
		
		back.setBounds(100, 400, 165, 25);
		back.addActionListener(this);
		
		
		frame.add(editLabel);
		frame.setSize(400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(editButton);
		frame.add(editField);
		frame.add(editVRN);
		frame.add(newVRN);
		frame.add(newVRNField);
		frame.add(newPNC);
		frame.add(newPNCField);
		frame.add(back);
		frame.setLayout(null);
		frame.setVisible(true);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		
    if (e.getSource()==editButton) {
		
    	String filepath = "C:\\Users\\HP\\OneDrive\\Desktop\\DailyVRNtxt.txt";
		String editTerm = editField.getText();
		String newVRN = newVRNField.getText();
		String newPNC = newPNCField.getText();
		
		try {
			editRecord(filepath,editTerm,newVRN,newPNC);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
    	
		}
    
    if (e.getSource()==back) {
    	
    	AdminPage adminPage = new AdminPage();
    	frame.setVisible(false);
    	
    }
    
   }

	private void editRecord(String filepath, String editTerm, String newVRN, String newPNC) throws FileNotFoundException {
		
		String tempFile = "C:/Users/HP/OneDrive/Desktop/temp2.txt";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		String VRN = ""; String PNC = "";
		
		try {
			FileWriter fw = new FileWriter(tempFile,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext()) {
				VRN = x.next();
				PNC = x.next();
				
				if (VRN.equals(editTerm)) {
					
					pw.println(newVRN +","+ newPNC +"\n");
					
				}
				else {
					
					pw.println(VRN + "," + PNC + "\n");
					
				}
			}
			x.close();
			pw.flush();
			pw.close();
			File zabi = new File("C:\\Users\\HP\\OneDrive\\Desktop\\DailyVRN.csv");
			zabi.delete();
			File dump = new File("C:\\Users\\HP\\OneDrive\\Desktop\\DailyVRN.csv");
			newFile.renameTo(dump);
			
			
		} catch (IOException el) {

			System.out.println("Error");
		}
		
	}

}
