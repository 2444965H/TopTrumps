package commandline;

import java.util.Scanner;


public class EndOfGameStats {
	
	//Is put under CLI
	public static void beginningOfGameChoice() {
		System.out.println("Do you want to display statistics from previous games(1) or start a new game(2)? Choose by entering the number");
		Scanner keyboardInputScanner = new Scanner(System.in);
		String keyboardchoice = keyboardInputScanner.nextLine();
		if (keyboardchoice.equalsIgnoreCase("1")) {
			// displayGameStatistics(); // method that gets statistics from db needs to be added
		}else if (keyboardchoice.equalsIgnoreCase("2")) {
			//depending on the implementation of gameplay either newGame() method has to be called or just proceed without doing anything and the next step will be the start of the gameplay
		}else {
			//In case of neither "1" or "2" do we want to start a new game or ask again(more complicated and including a loop)
		}
		
	}

	public static boolean isGameFinished(Player p1, Player p2, Player p3, Player p4) {
		if (p1.getHand().size()>0 && p2.getHand().size()==0 && p3.getHand().size()==0 && p4.getHand().size()==0) {
			return true;
		}else if (p1.getHand().size()==0 && p2.getHand().size()>0 && p3.getHand().size()==0 && p4.getHand().size()==0) {
			return true;
		}else if (p1.getHand().size()==0 && p2.getHand().size()==0 && p3.getHand().size()>0 && p4.getHand().size()==0) {
			return true;
		}else if (p1.getHand().size()==0 && p2.getHand().size()==0 && p3.getHand().size()==0 && p4.getHand().size()>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void printEndOfGameStats(Player p1, Player p2, Player p3, Player p4) {
		System.out.println("");
		System.out.println("The overall winner was " + checkForWinner(p1,p2,p3,p4));
		System.out.println("Scores:");
		System.out.println(p1.getPlayerID() + ":" + p1.getWinCounter());
		System.out.println(p2.getPlayerID() + ":" + p2.getWinCounter());
		System.out.println(p3.getPlayerID() + ":" + p3.getWinCounter());
		System.out.println(p4.getPlayerID() + ":" + p4.getWinCounter());
	}
	public static String checkForWinner(Player p1, Player p2, Player p3, Player p4) {
		//
		if (p1.getHand().size()>0 && p2.getHand().size()==0 && p3.getHand().size()==0 && p4.getHand().size()==0) {
			//Write into Testlog, if active
			if (TopTrumpsCLIApplication.writingTestLogs) {
				TopTrumpsCLIApplication.testlog2.fine( "The winner of the game" + p1.getPlayerID());
				}
			//End Testlog, if active
			return p1.getPlayerID();
		}else if (p1.getHand().size()==0 && p2.getHand().size()>0 && p3.getHand().size()==0 && p4.getHand().size()==0) {
			//Write into Testlog, if active
			if (TopTrumpsCLIApplication.writingTestLogs) {
				TopTrumpsCLIApplication.testlog2.fine( "The winner of the game" + p2.getPlayerID());
				}
			//End Testlog, if active
			return p2.getPlayerID();
		}else if (p1.getHand().size()==0 && p2.getHand().size()==0 && p3.getHand().size()>0 && p4.getHand().size()==0) {
			//Write into Testlog, if active
			if (TopTrumpsCLIApplication.writingTestLogs) {
				TopTrumpsCLIApplication.testlog2.fine( "The winner of the game" + p3.getPlayerID());
				}
			//End Testlog, if active
			return p3.getPlayerID();
		}else if (p1.getHand().size()==0 && p2.getHand().size()==0 && p3.getHand().size()==0 && p4.getHand().size()>0) {
			//Write into Testlog, if active
			if (TopTrumpsCLIApplication.writingTestLogs) {
				TopTrumpsCLIApplication.testlog2.fine( "The winner of the game" + p4.getPlayerID());
				}
			//End Testlog, if active
			return p4.getPlayerID();
		}else {
			return "Not valid result";
		}
	}
}
