package commandline;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

// This class will create the initial deck of 40 cards that will be dealt to the players
public class CardDeck {

// 	initial deck, private
	private ArrayList<Cards> deck;

	public CardDeck(ArrayList<Cards> deck) {
		this.deck = deck;
	}

//	reads from given file and initialises the deck accordingly
	public void initializeDeck() {
		File file = new File("StarCitizenDeck.txt");

		BufferedReader bufferedReader = null;

		try {
			java.io.FileReader fileReader = new java.io.FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String line;
			// reads the value of the cards
			bufferedReader.readLine();
			
			while ((line = bufferedReader.readLine()) != null) {
				String[] splited = line.split(" ");
				deck.add(new Cards(splited[0], Integer.parseInt(splited[1]), Integer.parseInt(splited[2]),
						Integer.parseInt(splited[3]), Integer.parseInt(splited[4]), Integer.parseInt(splited[5])));

			}
//			for(Cards card : deck) System.out.println(card.toString()); //Code for debugging purposes> prints out all the cards
//			System.out.println(deck.size()); //Code for debugging purposes> prints out deck
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

// 	setter for the deck	
	public void setDeck(ArrayList<Cards> deck) {
		this.deck = deck;
	}

//	Deals cards to players
	public void dealCards(int cardsPerPlayer, Player player) {
		for (int i = 0; i < cardsPerPlayer; i++) {
			player.addCard(deck.get(i));
		}
		// Remove cards from deck after the card has been dealt to player
		int temp = cardsPerPlayer;
		for (int i = 0; temp > 0; temp--) {
			deck.remove(i);
		}
	}

//	Getter for deck
	public ArrayList<Cards> getDeck() {
		return deck;
	}

}
