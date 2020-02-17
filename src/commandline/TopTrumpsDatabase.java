package commandline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import com.mysql.jdbc.PreparedStatement;

//This class will establish the connection between the Database and the game, it will update the stats in the database.
public class TopTrumpsDatabase {

	//database columns, declared as variables 
	private int draws;
	private int game_winner;
	private int user_round_wins;
	private int ai1_round_wins;
	private int ai2_round_wins;
	private int ai3_round_wins;
	private int ai4_round_wins;
	private int round_total;
	//for getNumberOfGames method
	private int numberOfGames;
	
	//defining the attributes for the connection: user and password

	    private String username = "m_19_2444965h";
	    private String password ="2444965h";
	    private String dbName = "m_19_2444965h";


	    //testing the database
	    public static void main(String args[]) {
	    		TopTrumpsDatabase test = new TopTrumpsDatabase();
	    		
	    }

	//setup the database connection, reference: https://www.postgresqltutorial.com/postgresql-jdbc/connecting-to-postgresql-database/
		public Connection connect() {
			 Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://yacata.dcs.gla.ac.uk:5432/"+dbName, username, password);
			System.out.println("Connection was successful!");
		}

		catch (SQLException e) {
			System.err.println("Connection Failed!");
			e.printStackTrace();
			
		}
		return connection;
	}
			
		
	//insert the values in the database, a bit updated, reference is: https://www.postgresqltutorial.com/postgresql-jdbc/insert/
	public void insertDatabase(int draws, String game_winner, int round_total, int user_round_wins, int ai1_round_wins, int ai2_round_wins, int ai3_round_wins, int ai4_round_wins) {
//			String SQL = "BEGIN;" + "INSERT INTO GAME_STATS(GAME_ID, DRAWS,GAME_WINNER,ROUND_TOTAL,USER_ROUND_WINS,AI1_ROUND_WINS,AI2_ROUND_WINS,AI3_ROUND_WINS,AI4_ROUND_WINS)" + "VALUES (?,?,?,?,?,?,?,?,?)" + "COMMIT;";
		String SQL = "INSERT INTO GAME_STATS(GAME_ID, DRAWS,GAME_WINNER,ROUND_TOTAL,USER_ROUND_WINS,AI1_ROUND_WINS,AI2_ROUND_WINS,AI3_ROUND_WINS,AI4_ROUND_WINS)" + "VALUES (?,?,?,?,?,?,?,?,?)";
		int id = 0;
		
        try (Connection connect = connect();
            java.sql.PreparedStatement pstmt = connect.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS)) {
        	Random rand = new Random();
        	// currently workaround for Game_ID Autoincrement needs to be implemented
        	pstmt.setInt(1, rand.nextInt(10000));
            pstmt.setInt(2, draws);
            pstmt.setString(3, game_winner);
            pstmt.setInt(4, round_total);
            pstmt.setInt(5, user_round_wins);
            pstmt.setInt(6, ai1_round_wins);
            pstmt.setInt(7, ai2_round_wins);
            pstmt.setInt(8, ai3_round_wins);
            pstmt.setInt(9, ai4_round_wins);

            //executes updates
            int affectedRows = pstmt.executeUpdate();
	          
//	            //For debugging purposes> Will check the affected rows
//	            if(affectedRows > 0) {
//	                //will get the id back 
//	            	try(ResultSet rs = pstmt.getGeneratedKeys()) {
//	                    if(rs.next()) {
//	                        id = rs.getInt(1);
//	                    }
//	                } catch (SQLException ex) {
//	                    System.out.println(ex.getMessage());
//	                }
//	            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex);
        }
//	        return id;

	    }
		
	//query to return the number of games played overall  
	public int getNumberOfGames() throws SQLException {
		Statement stmt = null;
		String queryOne = "select COUNT(GAME_ID)" + "from public.game_stats"; 
		try {
			stmt = connect().createStatement();
			ResultSet rs = stmt.executeQuery(queryOne);
			while(rs.next()) {
				int numberOfGames = rs.getInt("NUMBER_OF_GAMES");
				System.out.println(numberOfGames+ "\t");
			}
		} catch (SQLException e) {
			System.out.println("Failed to show number of games");	
		}finally {
			if (stmt != null) { stmt.close();
		        }
		  }
		return numberOfGames;
	 }

	//reference for the following getters: https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html
	//query to return how many times the AI1 has won 
	public int getAI1Wins() throws SQLException {
		
		Statement stmt = null;
		String queryOne = "select COUNT(GAME_ID) from public.game_stats where GAME_WINNER = 'AI Player 1'";

		try {
			stmt = connect().createStatement();
			ResultSet rs = stmt.executeQuery(queryOne);
			
			while(rs.next()) {
				int ai1_round_wins = rs.getInt("count");
				System.out.println("AI1 Wins:" + ai1_round_wins + "\t");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Failed to show number of computer wins.");
	
		}finally {
		
			if (stmt != null) { stmt.close();
		        }
		  }
		return ai1_round_wins;
	}
		
//query to return how many times the AI2 has won 
	public int getAI2Wins() throws SQLException {
		
		Statement stmt = null;
		
		String queryTwo = "select COUNT(GAME_ID) from public.game_stats where GAME_WINNER = 'AI Player 2'";
		try {
			
			stmt = connect().createStatement();
			ResultSet rs = stmt.executeQuery(queryTwo);
			
			while(rs.next()) {
				
				int ai2_round_wins = rs.getInt("count");
				System.out.println("AI2 Wins:" + ai2_round_wins + "\t");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Failed to show number of computer wins.");
		
		}finally {
			
			if (stmt != null) { stmt.close();
		        }
		  }
		return ai2_round_wins;
		}
			
//query to return how many times the AI3 has won 
	public int getAI3Wins() throws SQLException {
		
		Statement stmt = null;
		String queryThree = "select COUNT(GAME_ID) from public.game_stats where GAME_WINNER = 'AI Player 3'";
		
		try {
			stmt = connect().createStatement();
			ResultSet rs = stmt.executeQuery(queryThree);
			
			while(rs.next()) {
				int ai3_round_wins = rs.getInt("count");
				System.out.println("AI3 Wins:" + ai3_round_wins + "\t");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Failed to show number of computer wins.");
		
		}finally {
			
			if (stmt != null) { stmt.close();
		        }
		  }
		return ai3_round_wins;
	}
				
	//query to return how many times the AI4 has won 
	public int getAI4Wins() throws SQLException {
		
		Statement stmt = null;
		String queryFour = "select COUNT(GAME_ID) from public.game_stats where GAME_WINNER = 'AI Player 4'";

		try {
			stmt = connect().createStatement();
			ResultSet rs = stmt.executeQuery(queryFour);
			
			while(rs.next()) {
				
				int ai4_round_wins = rs.getInt("count");
				System.out.println("AI4 Wins:" + ai4_round_wins + "\t");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Failed to show number of computer wins.");
		}finally {
			if (stmt != null) { stmt.close();
		        }
		  }
		return ai4_round_wins;
	}

	//query to return how many times the human has won  
	public int getHumanWins() throws SQLException {
		
		Statement stmt = null;
		String queryFive = "select COUNT(user_round_wins) from public.game_stats where GAME_WINNER = 'User'";

		try {
			stmt = connect().createStatement();
			ResultSet rs = stmt.executeQuery(queryFive);
			
			while(rs.next()) {
				int user_round_wins = rs.getInt("count");
				System.out.println("User Wins:" + user_round_wins + "\t");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Failed to show number of human wins.");
		}finally {
			
			if (stmt != null) { stmt.close();
		        }
		  }
		return user_round_wins;
	}

	//query to return the average number of draws 
	public double getNumberOfDraws() throws SQLException {
		
		Statement stmt = null;
		String querySix = "select AVG(DRAWS) from public.GAME_STATS";

		try {
			stmt = connect().createStatement();
			ResultSet rs = stmt.executeQuery(querySix);
			
			while(rs.next()) {
				double draws = rs.getDouble("avg");
				System.out.println("Average draws:"+draws + "\t");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Failed to show number of average draws.");
		
		}finally {
			
			if (stmt != null) { stmt.close();
			}
		}
		return draws;
	}

	//query to return the largest number of rounds played in a single game
	public int getNumberOfRoundsPlayedInGame() throws SQLException {
		
		Statement stmt = null;
		String querySeven = "select MAX(ROUND_TOTAL) from public.GAME_STATS";
		try {
			
			stmt = connect().createStatement();
			ResultSet rs = stmt.executeQuery(querySeven);
			
			while(rs.next()) {

				int round_total = rs.getInt("max");
				System.out.println("Max number of Total rounds:"+ round_total + "\t");
			}

		} catch (SQLException e) {
			System.out.println("Failed to show max number of total rounds.");
		
		}finally {
			if (stmt !=null ) { stmt.close();
			}
	    }
		return round_total;	
	 }		
	
//closing the database connection
	public void closeConenction() {
		try {
			connect().close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}