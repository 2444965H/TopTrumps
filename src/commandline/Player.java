package commandline;

import java.util.ArrayList;

public class Player {

	private String playerID;
	private int winCounter;
	private ArrayList<Cards> hand;

	// constructor for the player and how many cards the player has
	public Player(String playerID, ArrayList<Cards> hand) {
		this.playerID = playerID;
		this.hand = hand;

	}

	// getter for name
	public String getPlayerID() {
		return playerID;
	}

	// string value of name
	public String toString() {
		return getPlayerID();
	}

	//getter for hand
	public ArrayList<Cards> getHand() {
		return hand;
	}

	// getter for win counter
	public int getWinCounter() {
		return winCounter;
	}

	//increment win counter
	public void incrementCounter() {
		winCounter++;
	}

	//adds card to the hand
	public void addCard(Cards card) {
		hand.add(card);
	}

	//getter for hand
	public Cards getTopCard() {
		return hand.get(0);
	}
	
	//setter for win counter
	public void setWinCounter(int winCounter) {
		this.winCounter = winCounter;
	}

}