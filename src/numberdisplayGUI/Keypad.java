package numberdisplayGUI;

// Displays a numeric entry pad

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Keypad extends JFrame {
	
	private JTextField display;
	
	public Keypad() {
		
		setTitle("Keypad");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		// set the display for showing the pressed digits
		display = new JTextField();
		panel.add(display, BorderLayout.NORTH);
		
		// make a panel for the keys
		JPanel keyPanel = new JPanel();
		keyPanel.setLayout(new GridLayout(4, 3));
		
		// create keys for digits (0-9)
		for (int i = 0; i < 10; i++) {
			JButton numKey = addNumKey(Integer.toString(i)); 
			keyPanel.add(numKey);
		}
		
		// add keys for decimal, Clear, & Evener
		keyPanel.add(addNumKey("0"));
		keyPanel.add(addDecimalKey());
		keyPanel.add(addClearKey());
		keyPanel.add(addEvenerKey());
		
		panel.add(keyPanel, BorderLayout.CENTER);
		
		setContentPane(panel);
	}
	
	// add pressed digit to the display
	private JButton addNumKey(String digit) {
		
		JButton key = new JButton(digit);
		
		key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String displayText = display.getText();
				display.setText(displayText + digit);
			}
		});
		
		return key;
	}
	
	// add the decimal point to the display
	private JButton addDecimalKey() {
		
		JButton key = new JButton(".");
		
		key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String displayText = display.getText();
				
				if (!displayText.contains(".")) {
					// if displaytext doesn't contain a decimal point, add one
					display.setText(displayText + ".");
				}
			}
		});
		
		return key;
	}
	
	// clear the display
	private JButton addClearKey() {
		
		JButton key = new JButton("Clear");
		
		key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				display.setText("");
			}
		});
		
		return key;
		
	}
	
	// round to the closest even integer
	private JButton addEvenerKey() {
		
		JButton key = new JButton("Evener");
		
		key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String displayText = display.getText();
				
				if(!displayText.isEmpty()) {
						// instantiate BigDecimal for floating pt precision 
						BigDecimal digit = new BigDecimal(displayText);
						
						BigDecimal roundDigit = digit.setScale(0, RoundingMode.HALF_EVEN);
						
						display.setText(roundDigit.toString());
				}
			}
		});
		
		return key;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				new Keypad().setVisible(true);
			}
		});
	}
}
