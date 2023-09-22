package dicebagGUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage; 

// adapts DiceBag into a GUI

public class DiceRoller extends JFrame {
	
	// class variables & components
	private DiceBag diceBag;

	private JLabel diceBagImage, diceImages; // labels for the images
	private JTextArea diceInfo, rollResults; // labels for displaying info
	private JCheckBox selectDFour, selectDSix, selectDEight; // checkbox labels for selecting # of faces
	// private JLabel diceCounter;
	
	// Constructor
	public DiceRoller() {
		
		// instantiate new DiceBag
		diceBag = new DiceBag();
		
		setTitle("DiceRoller");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// instantiate main container and set to BorderLayout
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		// instantiate container to display dice info
		JPanel infoPanel = new JPanel();
		diceInfo = new JTextArea(10, 20); // instantiate diceInfo, add to info panel
		infoPanel.add(new JScrollPane(diceInfo));
		// diceCounter = new JLabel("Dice in bag: " + diceBag.getDice().size());
		
		panel.add(infoPanel, BorderLayout.WEST); // add the info panel to main container
		
		// add a container for buttons, roll results, and images
		JPanel actionPanel = new JPanel();
		actionPanel.setLayout(new BorderLayout());
		
		// add checkbox components for selecting # of faces
		JPanel selectType = new JPanel();
		selectDFour = new JCheckBox("d4");
		selectDSix = new JCheckBox("d6");
		selectDEight = new JCheckBox("d8");
		
		// add options to the checkbox
		selectType.add(selectDFour);
		selectType.add(selectDSix);
		selectType.add(selectDEight);
		actionPanel.add(selectType, BorderLayout.SOUTH);
		
		// create label for displaying dice bag image
		try {
			BufferedImage image = ImageIO.read(new File("test.png"));
			diceBagImage = new JLabel(new ImageIcon(image));
			actionPanel.add(diceBagImage, BorderLayout.WEST);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// add a button for rolling the selected dice
		JButton rollButton = new JButton("Roll Dice");
		actionPanel.add(rollButton, BorderLayout.CENTER);
		
		// add a text display for roll result
		rollResults = new JTextArea(10, 20);
		actionPanel.add(new JScrollPane(rollResults), BorderLayout.NORTH);
		
		// add the actionPanel to the main container
		panel.add(actionPanel, BorderLayout.CENTER);
		
		// add an action listener for the roll button
		rollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollSelectedDice();
			}
		});
		
		setContentPane(panel);
	}
	
	// determine the type of dice based on user selection
	private void rollSelectedDice() {
		
		// instantiate a new list for the selected dice objects
		List<Integer> selectDice = new ArrayList<>();
		
		if (selectDFour.isSelected()) {
			selectDice.add(4);
		} else if (selectDSix.isSelected()) {
			selectDice.add(6);
		} else if (selectDEight.isSelected()) {
			selectDice.add(8);
		}
		
		// instantiate stringbuilder to display roll results and sum
		StringBuilder stringResults = new StringBuilder("Rolling the dice:\n");
		
		int sumTotal = 0;
		for (Integer sides : selectDice) {
			String roll = diceBag.getRoll(sides);
			stringResults.append(roll).append("\n");
			
			int sum = extractSum(roll);
			sumTotal += sum;
		}
		
		stringResults.append("Sum of the Rolls: ").append(sumTotal);
		rollResults.setText(stringResults.toString());
	}

	// extract sum from roll string
	private int extractSum(String roll) {
		
		int startIndex = roll.lastIndexOf("Sum of the Rolls: ");
		if (startIndex != -1) {
			try {
				return Integer.parseInt(roll.substring(startIndex + 18).trim());
			} catch (NumberFormatException e) {
				return 0;
			}
		} else {
			return 0;	
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new DiceRoller().setVisible(true);
			}
		});
	}
}
