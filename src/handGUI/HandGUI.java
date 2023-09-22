package handGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;
import java.util.Map;

public class HandGUI extends JFrame {
	
	// declare Map to link cards with their image files
	private Map<Card, String> cardImageMap;
	
	// declare objects/components
	private Deck deck;
	private JLabel deckLabel;
	private JButton dealButton;
	private JButton resetButton;
	private JPanel cardPanel;
	
	// constructor
	public HandGUI() {
		
		// initialize objects and components
		deck = new Deck();
		deckLabel = new JLabel("Deck: " + deck.cards.size() + "cards");
		addCardImageMap();
		
		setTitle("Hand GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// add components to the window
		add(deckLabel, BorderLayout.SOUTH);
		add(dealButton, BorderLayout.NORTH);
		add(resetButton, BorderLayout.EAST);
		add(cardPanel, BorderLayout.CENTER);
		
		dealButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Card drawCard = deck.draw();
				if (drawCard != null) {
					deckLabel.setText("Deck: " + deck.cards.size() + " cards");
					showCard(drawCard);
				}
				
			}
		});
		
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				resetDeck();
			}
		});
		
		pack(); // automatically size frame based on content
		setLocationRelativeTo(null); // center JFrame on screen
	}
	
	// add a card image map that links cards with associated image files
	private void addCardImageMap() {
		
		cardImageMap = new HashMap<>();
		
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				// card object
				Card card = new Card(rank, suit);
				
				// generate string repr. of image file name
				String fileName = suit.name().toLowerCase() + "_of_" + suit.name().toLowerCase() + "2.png";
			
				// map the card object
				String imagePath = "C:/Users/OneDrive - AutoZone Parts, Inc/Desktop/Fall 2023/Java/JavaLab3/javaLab3/src/CardsPNG";
				cardImageMap.put(card, imagePath + fileName);
			}
		}
	}
	
	// display a card
	private void showCard(Card card) {
		
		String imagePath = cardImageMap.get(card);
		
		if (imagePath != null) {
			
			// add image and label
			ImageIcon image = new ImageIcon(getClass().getResource(imagePath));
			JLabel cardLabel = new JLabel(image);
			cardPanel.add(cardLabel);
			revalidate(); // resize screen based on components	
		}
	}
	
	// reset the deck
	private void resetDeck() {
		
		deck.renewDeck();
		deckLabel.setText("Deck: " + deck.cards.size() + " cards");
		cardPanel.removeAll();
		revalidate();
	}
	
	// main
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				HandGUI hand = new HandGUI();
				hand.setVisible(true);
			}
		});
	}

}
