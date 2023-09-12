package Griffin_Ziegler_JavaLab3;

// Test driver for JavaLab3

import javax.swing.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame("My first GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(300,300);
       JButton button1 = new JButton("Press");
       frame.getContentPane().add(button1);
       frame.setVisible(true);
     
   
       
		
	}

}
