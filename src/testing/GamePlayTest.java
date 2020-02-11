/**
 * 
 */
package testing;



import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import commandline.Cards;
import commandline.GamePlay;
import commandline.Player;
import commandline.TopTrumpsCLIApplication;

/**
 * @author Linh
 *
 */
public class GamePlayTest {
	public static GamePlay gpTest;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 gpTest = new GamePlay();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		gpTest = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		gpTest.resetGameState();
	}



	/**
	 * Test method for {@link commandline.GamePlay#playGame()}.
	 */
	@Test
	public final void testPlayGame() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link commandline.GamePlay#resetGameState()}.
	 */
	@Test
	public final void testResetGameState() {
		gpTest.resetGameState();
		assertEquals(gpTest.getRound(),1);
		assertEquals(gpTest.getChoice(),0);
		assertEquals(gpTest.isDraw(),false);
		assertEquals(gpTest.getDrawCounter(),0);
		assertEquals(gpTest.getRoundVictor(),null);	
		assertEquals(gpTest.getActivePlayer(),null);
		assertEquals(gpTest.getGameWinner(),null);
		assertEquals(gpTest.getWinCard(),null);
		assertEquals(gpTest.getUser(),null);
		assertEquals(gpTest.getPlayer1(),null);
		assertEquals(gpTest.getPlayer2(),null);
		assertEquals(gpTest.getPlayer3(),null);
		assertEquals(gpTest.getPlayer4(),null);
	}

	/**
	 * Test method for {@link commandline.GamePlay#logCheck()}.
	 */
	@Test
	public final void testLogCheck() {
		TopTrumpsCLIApplication.writingTestLogs = false;
		gpTest.logCheck();
		assertFalse(gpTest.isLogCheck());
		TopTrumpsCLIApplication.writingTestLogs = true;
		gpTest.logCheck();
		assertTrue(gpTest.isLogCheck());
	}

	/**
	 * Test method for {@link commandline.GamePlay#gameOrStats()}.
	 */
	@Test
	@Ignore
	public final void testGameOrStats() {
		//Currently Has to be tested manually because of User-Input required and current
		//setup does not allow simulated/mocked User-Input
	}

	/**
	 * Test method for {@link commandline.GamePlay#printStats()}.
	 */
	@Test
	@Ignore
	public final void testPrintStats() {
		//Currently Has to be tested manually because result required is changing and
		//depending on the current state of the database, would need modification for
		//simulated/mocked Database-Output
	}

	/**
	 * Test method for {@link commandline.GamePlay#insertDatabase()}.
	 */
	@Test
	@Ignore
	public final void testInsertDatabase() {
		//Currently Has to be tested manually because current setup does not allow to
		//use a dummy database for simulation/mocking
	}

	/**
	 * Test method for {@link commandline.GamePlay#askForAIPlayers()}.
	 */
	@Test
	@Ignore
	public final void testAskForAIPlayers() {
		//Currently Has to be tested manually because of User-Input required and current
		//setup does not allow simulated/mocked User-Input
	}

	/**
	 * Test method for {@link commandline.GamePlay#endGameArray()}.
	 */
	@Test
	public final void testEndGameArray() {
		ArrayList<Player> players = new ArrayList<Player>();
		Player user = new Player("You", new ArrayList<Cards>());
		Player user2 = new Player("You2", new ArrayList<Cards>());
		Player user3 = new Player("You3", new ArrayList<Cards>());
		Player user4 = new Player("You4", new ArrayList<Cards>());
		Player user5 = new Player("You5", new ArrayList<Cards>());
		players.add(user);
		players.add(user2);
		players.add(user3);
		players.add(user4);
		players.add(user5);
		gpTest.setPlayers(players);
		gpTest.endGameArray();
		assertArrayEquals(gpTest.getPlayers().toArray(), gpTest.getEndGameArray().toArray());
	}

	/**
	 * Test method for {@link commandline.GamePlay#createPlayers()}.
	 */
	@Test
	public final void testCreatePlayers() {
		/////
		gpTest.setPlayers(null);
		assertNull(gpTest.getPlayers());
		gpTest.setPlayers(new ArrayList<Player>());
		gpTest.createPlayers2(1);
		assertEquals(2, gpTest.getPlayers().size());
		assertEquals(gpTest.getUser(), gpTest.getPlayers().get(0));
		assertEquals(gpTest.getPlayer1(), gpTest.getPlayers().get(1));
		/////
		gpTest.setPlayers(null);
		assertNull(gpTest.getPlayers());
		gpTest.setPlayers(new ArrayList<Player>());
		gpTest.createPlayers2(2);
		assertEquals(3, gpTest.getPlayers().size());
		assertEquals(gpTest.getUser(), gpTest.getPlayers().get(0));
		assertEquals(gpTest.getPlayer1(), gpTest.getPlayers().get(1));
		assertEquals(gpTest.getPlayer2(), gpTest.getPlayers().get(2));
		/////
		gpTest.setPlayers(null);
		assertNull(gpTest.getPlayers());
		gpTest.setPlayers(new ArrayList<Player>());
		gpTest.createPlayers2(3);
		assertEquals(4, gpTest.getPlayers().size());
		assertEquals(gpTest.getUser(), gpTest.getPlayers().get(0));
		assertEquals(gpTest.getPlayer1(), gpTest.getPlayers().get(1));
		assertEquals(gpTest.getPlayer2(), gpTest.getPlayers().get(2));
		assertEquals(gpTest.getPlayer3(), gpTest.getPlayers().get(3));
		/////
		gpTest.setPlayers(null);
		assertNull(gpTest.getPlayers());
		gpTest.setPlayers(new ArrayList<Player>());
		gpTest.createPlayers2(4);
		assertEquals(5, gpTest.getPlayers().size());
		assertEquals(gpTest.getUser(), gpTest.getPlayers().get(0));
		assertEquals(gpTest.getPlayer1(), gpTest.getPlayers().get(1));
		assertEquals(gpTest.getPlayer2(), gpTest.getPlayers().get(2));
		assertEquals(gpTest.getPlayer3(), gpTest.getPlayers().get(3));
		assertEquals(gpTest.getPlayer4(), gpTest.getPlayers().get(4));
	}

	/**
	 * Test method for {@link commandline.GamePlay#dealCards()}.
	 */
	@Test
	public final void testDealCards() {
		gpTest.createPlayers2(3);
		assertEquals(0,gpTest.getUser().getHand().size());
		assertEquals(0,gpTest.getPlayer1().getHand().size());
		assertEquals(0,gpTest.getPlayer2().getHand().size());
		assertEquals(0,gpTest.getPlayer3().getHand().size());
		gpTest.dealCards();
		assertEquals(10,gpTest.getUser().getHand().size());
		assertEquals(10,gpTest.getPlayer1().getHand().size());
		assertEquals(10,gpTest.getPlayer2().getHand().size());
		assertEquals(10,gpTest.getPlayer3().getHand().size());
		assertEquals(40,gpTest.getUser().getHand().size()+gpTest.getPlayer1().getHand().size()+gpTest.getPlayer2().getHand().size()+gpTest.getPlayer3().getHand().size());
		////
		gpTest.resetGameState();
		gpTest.createPlayers2(1);
		assertEquals(0,gpTest.getUser().getHand().size());
		assertEquals(0,gpTest.getPlayer1().getHand().size());
		gpTest.dealCards();
		assertEquals(20,gpTest.getUser().getHand().size());
		assertEquals(20,gpTest.getPlayer1().getHand().size());
		assertEquals(40,gpTest.getUser().getHand().size() + gpTest.getPlayer1().getHand().size());
	}

	/**
	 * Test method for {@link commandline.GamePlay#checkPlayerDeck()}.
	 */
	@Test
	@Ignore
	public final void testCheckPlayerDeck() {
		//Currently has to be tested manually because current setup does not return any values and only prints it
		// directly to the console.
	}

	/**
	 * Test method for {@link commandline.GamePlay#activeUserInputHandler(commandline.Player, commandline.Player)}.
	 */
	@Test
	@Ignore
	public final void testActiveUserInputHandler() {
		//Currently Has to be tested manually because of User-Input required and current
		//setup does not allow simulated/mocked User-Input
	}

	/**
	 * Test method for {@link commandline.GamePlay#displayUserHand(commandline.Player, commandline.Player)}.
	 */
	@Test
	@Ignore
	public final void testDisplayUserHand() {
		//Currently has to be tested manually because current setup does not return any values and only prints it
		// directly to the console.
	}

	/**
	 * Test method for {@link commandline.GamePlay#randomSelectPlayer()}.
	 */
	@Test
	@Ignore
	public final void testRandomSelectPlayer() {
		//Random Function no deterministic Way to test it. The Random-Function itself is tested as part of its
		//Java Library and does not need to be tested.
	}

	/**
	 * Test method for {@link commandline.GamePlay#decideFirstTurn()}.
	 */
	@Test
	@Ignore
	public final void testDecideFirstTurn() {
		//Has not to be tested because it only saves the result of .randomSelectPlayer() in a variable which is
		//trivial
	}

	/**
	 * Test method for {@link commandline.GamePlay#findRoundWinner()}.
	 */
	@Test
	public final void testFindRoundWinner() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link commandline.GamePlay#printWinCard(commandline.Cards, int)}.
	 */
	@Test
	public final void testPrintWinCard() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link commandline.GamePlay#drawChecker()}.
	 */
	@Test
	public final void testDrawChecker() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link commandline.GamePlay#drawHandler()}.
	 */
	@Test
	public final void testDrawHandler() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link commandline.GamePlay#victoryHandler()}.
	 */
	@Test
	public final void testVictoryHandler() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link commandline.GamePlay#removeLosers()}.
	 */
	@Test
	public final void testRemoveLosers() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link commandline.GamePlay#nextRound()}.
	 */
	@Test
	public final void testNextRound() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link commandline.GamePlay#playRounds()}.
	 */
	@Test
	public final void testPlayRounds() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link commandline.GamePlay#gameEndHandler()}.
	 */
	@Test
	public final void testGameEndHandler() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link commandline.GamePlay#endOfGame()}.
	 */
	@Test
	public final void testEndOfGame() {
		fail("Not yet implemented"); // TODO
	}

}
