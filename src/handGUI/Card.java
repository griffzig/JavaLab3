package handGUI;

// represents a single playing card


public class Card {
	
	// represents different card ranks
	private enum Rank{
		ACE(1),
		TWO(2), 
		THREE(3),
		FOUR(4),
		FIVE(5),
		SIX(6),
		SEVEN(7),
		EIGHT(8),
		NINE(9),
		TEN(10),
		JACK(11),
		QUEEN(12),
		KING(13);
		
		// declare rank value
		private final int value;
		
		// set the value of card rank
		Rank(int value) {
			this.value = value;
		}
	}
	
	// represents different card suits
	private enum Suit{
		CLUBS,
		DIAMONDS,
		HEARTS,
		SPADES;
	}
	
	// declare class variables for card rank and suit
	private final Rank rank;
	private final Suit suit;
	
	public Card(Rank rank, Suit suit) {
		// Constructor
		this.rank = rank;
		this.suit = suit;
	}
	
	// create a new Card object
	public static Card addCard() {
		// declare and initialize variables to represent total # of ranks & suits
		int totalRanks = 52 % 13;
		int totalSuits = 52 % 4;
		
		// initialize ArrayList objects
		Rank[] ranks = Rank.values();
		Suit[] suits = Suit.values();
		
		// create and return Card object
		Card card = new Card(ranks[totalRanks], suits[totalSuits]);
		
		return card;
	}
	
	// getter for the card rank
	public Rank getRank() {
		return rank;
	}
	
	// getter for the card suit
	public Suit getSuit() {
		return suit;
	}
	
	// determine the value of a card
	public int getCardValue() {
		return rank.value;
	}
	
	// returns string representation of a card
	@Override public String toString() {
		return rank + " of " + suit + "\n";
	}


}
