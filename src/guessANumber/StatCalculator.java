package guessANumber;

import java.util.ArrayList;
import java.util.List;

/****
 * 
 * <b>Title:</b> Player.java<br>
 * <b>Project:</b> guessANumber<br>
 * <b>Description:</b>This class handles the calculation of Player statistics
 * for the Guessing Game<br>
 * <b>Copyright:</b> Copyright (c) 2023<br>
 * <b>Company:</b> Silicon Mountain Technologies<br>
 * 
 * @author George Clam
 * @version 1.0
 * @since Jan 11 2023
 * @updates:
 ****/

public class StatCalculator {

	List<Integer> scores = new ArrayList<>();
	private int totalGames = scores.size();

	/**
	 * @param n Takes a List as an argument, built for the scores ArrayList in the
	 *          class
	 * @return number of guess per game (mean score)
	 */
	public double averageScore(List<Integer> num) {
		double sum = 0;
		for (int score : num) {
			sum = sum + score;
		}
		return (sum / num.size());
	}

	/**
	 * Method that determines the player's highest number of guesses of their games
	 * 
	 * @param n Takes a list as an argument, built for the scores ArrayList in the
	 *          class
	 */
	public int highScore(List<Integer> num) {
		int current = 0;
		for (int score : num) {
			if (score > current) {
				current = score;
			}
		}
		return current;
	}

	/**
	 * Method calculates the fewest number of guesses required to complete the game
	 * 
	 * @param n Takes a list as an argument, built for the scores ArrayList in the
	 *          class
	 */
	public int lowScore(List<Integer> num) {
		int current = 100000;
		for (int score : num) {
			if (score < current) {
				current = score;
			}
		}
		return current;
	}

	/**
	 * @return the totalGames
	 */
	public int getTotalGames() {
		return totalGames;
	}
}