package commandline;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* This class will shuffle the card deck. This class will also check for a draw by comparing the 5 cards attributes, and will further place the
*  cards that were satisfying the draw condition within the common pile. 
*/
public class CardDeck {

	// deck size is always 40
	private int DECK_SIZE = 40;
	// initial deck, empty
	private ArrayList<Cards> deck;

	public CardDeck(ArrayList<Cards> deck) {
		this.deck = deck;
	}

	public void initializeDeck() {
		File file = new File("StarCitizenDeck.txt");

		BufferedReader bufferedReader = null;

		try {
			java.io.FileReader fileReader = new java.io.FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			String line;
			// this prints out the value of the cards
			bufferedReader.readLine();
			// THING IS PRINTED OUT
			while ((line = bufferedReader.readLine()) != null) {
				String[] splited = line.split(" ");
				deck.add(new Cards(splited[0], Integer.parseInt(splited[1]), Integer.parseInt(splited[2]), Integer.parseInt(splited[3]),  Integer.parseInt(splited[4]), Integer.parseInt(splited[5])));
				
				
			}
//			for(Cards card : deck) System.out.println(card.toString()); //prints out all the cards
//			System.out.println(deck.size()); //prints out deck
		} catch (FileNotFoundException exception) {
			System.out.println("File not found: " + file.toString());
		} catch (IOException exception) {
			System.out.println("Unable to read file: " + file.toString());
		} finally {

			try {
				bufferedReader.close();
			} catch (IOException e) {
				System.out.println("Unable to close file: " + file.toString());
			} catch (NullPointerException exception) {
			}
		}
	}

////////////////////////////////////////////
	
	public void setDeck(ArrayList<Cards> deck) {
		this.deck = deck;
	}


	public void dealCards(int cardsPerPlayer, Player player) {
		for (int i = 0; i < cardsPerPlayer; i++) {
			player.addCard(deck.get(i));
		} 
		//now remove cards from deck after the card has been dealt to player
		int temp = cardsPerPlayer;
		for (int i = 0; temp > 0; temp--) {
			deck.remove(i);
		}
	}

	// Cards that were checked in previous method are now placed in common pile
	public void addCommonPile() {
	}

	public ArrayList<Cards> getDeck() {
		return deck;
	}

}
