package testing;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import commandline.Cards;
import commandline.Player;

/**
 * @author Miruna
 * @author Linh
 */
public class PlayerTest {
		
	public static Player playerTest;
	public static ArrayList<Cards> hand = new ArrayList<Cards>();
	public static int winCounter = 1;
	public static Cards element1, element2, element3, element4;

		
		@Before
		public  void setUp() throws Exception {
			 playerTest = new Player("testUser",hand);
			 	element1 = new Cards("Name 1", 1, 2, 3, 4, 5);
				element2 = new Cards("Name 2", 6, 7, 8, 9, 10);
				element3 = new Cards("Name 3", 1, 3, 5, 7, 9);
				element4 = new Cards("Name 4", 2, 4, 6, 8, 10);
				hand.add(element1);
				hand.add(element2);
				hand.add(element3);
				hand.add(element4);
				playerTest.setWinCounter(winCounter);
				
		}

		/**
		 * @throws java.lang.Exception
		 */
		@After
		public  void tearDown() throws Exception {
			playerTest = null;
		}
		


//////// Test increment win counter
		@Test
		public void incrementCounter() {
			assertEquals(1, playerTest.getWinCounter());
			playerTest.incrementCounter();
			assertEquals(2, playerTest.getWinCounter());
		}
		
//////// Test adding card to hand 
		@Test
		public void addCard() {	
			assertEquals(new Cards("Name 4", 2, 4, 6, 8, 10).getDescription(), hand.get(3).getDescription());
			playerTest.addCard(new Cards("Name 5", 5, 5, 5, 5, 5));
			assertEquals(new Cards("Name 4", 2, 4, 6, 8, 10).getDescription(), hand.get(3).getDescription());
			assertEquals(new Cards("Name 5", 5, 5, 5, 5, 5).getDescription(), hand.get(4).getDescription());
		}

//////// Test getter for top card 
		@Test	
		public void getTopCard() {
			assertEquals(new Cards("Name 1", 1, 2, 3, 4, 5).getDescription(), playerTest.getTopCard().getDescription());
		}		
}