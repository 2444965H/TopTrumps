package testing;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import commandline.CardDeck;
import commandline.Cards;
import commandline.Player;

/**
 * @author Miruna
 * @author Linh
 *
 */
public class CardDeckTest {
	
	public static CardDeck cardDeckTest;
	public static ArrayList<Cards> deck;
	public static ArrayList<Cards> testHand = new ArrayList<Cards>();;
	public static Player testPlayer;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		deck = new ArrayList<Cards>();
		Cards card1 = new Cards("Name 1", 1, 2, 3, 4, 5);
		Cards card2 = new Cards("Name 2", 6, 7, 8, 9, 10);
		Cards card3 = new Cards("Name 3", 1, 3, 5, 7, 9);
		Cards card4 = new Cards("Name 4", 2, 4, 6, 8, 10);
		Cards card5 = new Cards("Name 5", 0, 2, 7, 4, 9);
		deck.add(card1);
		deck.add(card2);
		deck.add(card3);
		deck.add(card4);
		deck.add(card5);
		cardDeckTest = new CardDeck(deck);
		testPlayer = new Player("testUser",testHand);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		cardDeckTest = null;
	}

///////// Simple JUnit is not intended for any test that is taking resources
	//FileReader and BufferedReader are not tested - can be tested by looking at the testlog
	@Test
	@Ignore
	public void initializeDeck() {
		
	}



	////////// Testing dealing the cards - incomplete, don't know how to write the for loops
	@Test
	public void dealCards() {
		int cardsPerPlayer = 3;
		assertEquals(5, cardDeckTest.getDeck().size());	
		cardDeckTest.dealCards(3, testPlayer);
		assertEquals(3, testPlayer.getHand().size());	
		assertEquals(2, cardDeckTest.getDeck().size());	
	}



}