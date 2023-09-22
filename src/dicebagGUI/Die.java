package dicebagGUI;

import java.util.Random;
import javax.swing.*;
import java.awt.*;

// captures the essence of a single die

public class Die {

	public int sides;
	private int face;
	 // store the current face
	
	Die (int sides) {
		// Constructor
		face = roll();
		this.sides = sides;
	}
	
	public int roll() {
		// instantiate Random object
		Random rand = new Random();
		
		// return the results of the roll
		return rand.nextInt(sides) + 1;
	}	
	
	public int getSides() {
		return sides;
	}
	
	// get Face method 
	// int Face method
	// get DiePick (returns icon or label for the die face/image)
	
	public Icon getDiePic() {
		return new ImageIcon(face + ".png");
	}
}