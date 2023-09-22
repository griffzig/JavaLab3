package dicebagGUI;

import java.util.ArrayList;
import java.util.List;

// holds dice

public class DiceBag {
	
	// declare a private list to store the dice
	private List<Die> dice;
	
	// Constructor
	public DiceBag () {
		// Instantiate an empty diceBag list
		dice = new ArrayList<>();
	}
	
	// add dice of specified sides to the bag
	public void addDie(int sides) {
		
		dice.add(new Die(sides));
	}
	
	// public ArrayList<Die> getDice(){
	// 		return dice;
	// }
	
	// roll 
	public String getRoll(int sides) {
		
		StringBuilder stringResults = new StringBuilder("Rolling " + sides + "-sided dice:\n");
		
		int sum = 0; // variable to store sum of the rolls
		
		// for each loop 
		for (Die die : dice) {
			if (die.getSides() == sides) {
				int roll = die.roll();
				sum += roll; // add the rolls to get the sum
				
				// add results of the roll to the string
				stringResults.append("Die with ").append(die.getSides()).append(" sides: ").append(roll).append("\n");
			}
		}
		
		// add sum of the rolls to the string
		stringResults.append("Sum of the Rolls: ").append(sum);
		
		return stringResults.toString();
	}
		
	public String rollFours() {
		
		return getRoll(4);
	}
	
	public String rollSixes() {
		
		return getRoll(6);
	}
	
	public String rollEights() {
		
		return getRoll(8);
	}

	public String armageddon() {
		// roll all dice in the bag
		// return string, or maybe not return anything
		StringBuilder stringResults = new StringBuilder("Rolling ALL the dice:\n");
		
		int sum = 0;
		for (Die die : dice) {
			int roll = die.roll();
			sum += roll;
			stringResults.append("Die with ").append(die.getSides()).append(" sides: ").append(roll).append("\n");
			
		}
		
		stringResults.append("Sum of the Rolls: ").append(sum);
		
		return stringResults.toString();
	}
	
}