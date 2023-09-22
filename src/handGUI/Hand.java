package handGUI;

import java.util.List;
import java.util.ArrayList;

// represents collection of cards

public class Hand {

	private List<Card> handCards; // list of cards in current hand
	
	// Constructor
	public Hand() {
		
		handCards = new ArrayList<>();
	}
	
	// add a card to the hand
	public void addCard(Card card) {
		
		handCards.add(card);
	}
	
	// add an arrayList of cards to the hand
	public void addCards(List<Card> newCards) {
		
		handCards.addAll(newCards);
	}
	
	// return String repr. of hand
	public String displayHand() {
		
		StringBuilder stringHand = new StringBuilder();
		
		for (Card card : handCards) {
			stringHand.append(card.toString()).append(", ");
		}
		
		int length = stringHand.length();
		
		if (length > 2) {
			// removes ", "
			stringHand.delete(length - 2, length);
		}
		
		return stringHand.toString();
	}
}

