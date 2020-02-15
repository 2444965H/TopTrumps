package commandline;

import java.util.ArrayList;

public class Player {

	private String playerID;
	private int winCounter;
	private int numberOfPlayers;
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

	public ArrayList<Cards> getHand() {
		return hand;
	}

	public int getWinCounter() {
		return winCounter;
	}

	public void incrementCounter() {
		winCounter++;
	}

	public void addCard(Cards card) {
		hand.add(card);
	}

	public Cards getTopCard() {
		return hand.get(0);
	}
	
	public void setWinCounter(int winCounter) {
		this.winCounter = winCounter;
	}

}