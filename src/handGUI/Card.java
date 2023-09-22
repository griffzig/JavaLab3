package handGUI;

// represents a single playing card


public class Card {
	
	// declare class variables for card rank and suit
	private final Rank rank;
	private final Suit suit;
	
	public Card(Rank rank, Suit suit) {
		// Constructor
		this.rank = rank;
		this.suit = suit;
	}

	// getter for the card rank
	public Rank getRank() {
		return rank;
	}
	
	// getter for the card suit
	public Suit getSuit() {
		return suit;
	}
	
	// returns string representation of a card
	@Override public String toString() {
		return rank + " of " + suit + "\n";
	}


}
