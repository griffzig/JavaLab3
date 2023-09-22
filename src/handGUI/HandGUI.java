package handGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HandGUI {
	
	// create lists to store the deck and dealt cards
	ArrayList<Card> deck;
	ArrayList<Card> playerCards;
	
	// create the JFrame and JLabel containers
	private JFrame frame;
	private JLabel cardLabel;
	
	
	public static void main(String[] args) {
		deck = new ArrayList<>();
	}

}
