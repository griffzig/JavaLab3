package handGUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// represents a full deck of 52 playing cards

public class Deck {

	public List<Card> cards; // total cards
	public List<Card> dealtCards; // cards drawn by dealer
	
	// Constructor
	public Deck() {
		
		addDeck();
	}
	
	// initialize the deck
	private void addDeck() {
		
		cards = new ArrayList<>();
		dealtCards = new ArrayList<>();
		
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new Card(rank, suit));
			}
		}
	}
	
	// draw a random card from the deck
	public Card draw() {
		
		if (cards.isEmpty()) {
			return null; // if deck is empty, cannot draw
		
		} else {	
			Random rand = new Random();
			int i = rand.nextInt(cards.size());
			Card drawCard = cards.remove(i);
			dealtCards.add(drawCard);
			
			return drawCard;
		}
	}
	
	// deals a certain number of random cards
	public List<Card> deal(int totalCards) {
		
		List<Card> dealt = new ArrayList<>();
		
		for (int i = 0; i < totalCards; i++) {
			Card card = draw();
			
			if (card != null) {
				dealt.add(card);
			
			} else {
				break; 
			}
		}
		
		return dealt;
	}
	
	// return deck to original state
	public void renewDeck() {
		
		cards.addAll(dealtCards);
		dealtCards.clear();
	}
}

