package guessANumber;

import java.util.Scanner;

/****
 * 
 * <b>Title:</b> GuessingGame.java<br>
 * <b>Project:</b> guessANumber<br>
 * <b>Description:</b>This class holds all the variables and methods to run the
 * Guessing Game<br>
 * <b>Copyright:</b> Copyright (c) 2023<br>
 * <b>Company:</b> Silicon Mountain Technologies<br>
 * 
 * @author George Clam
 * @version 1.0
 * @since Jan 11 2023
 * @updates:
 ****/

public class GuessingGame {

	private String name;
	private String language;
	private int count;
	private int guess;
	private int targetNumber;

	Scanner scanner = new Scanner(System.in);
	StatCalculator stats = new StatCalculator();

	/**
	 * This is the main methods and executes the program using class methods
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GuessingGame game = new GuessingGame();
		game.setLanguage();
		if (!game.speaksSpanish()) {
			game.setName();
			game.runGame();
		} else {
			game.setNameSpanish();
			game.runGameSpanish();
		}
	}

	/**
	 * This method executes each method related to the flow of the game in order for
	 * English-speaking players
	 */
	public void runGame() {
		setCount(0);
		setTargetNumber();
		System.out.println("Cheater: " + getTargetNumber()); // Test Code
		setupGame();
		playerGuessPrompt();
	}

	/**
	 * This method executes each method related to the flow of the game in order for
	 * Spanish-speaking players
	 */
	public void runGameSpanish() {
		setCount(0);
		setTargetNumber();
		System.out.println("Cheater: " + getTargetNumber()); // Test Code
		setupGameSpanish();
		playerGuessPromptSpanish();
	}

	/**
	 * Sets up the game by requesting information from the player. All prompts for
	 * this method are written in English
	 */
	public void setupGame() {
		System.out.println();
		System.out.println("Welcome, " + getName() + "!");
		System.out.println(
				"The object of the game is to guess the correct integer between 1 and 1,000 in as few guesses as possible.");
	}

	/**
	 * Sets up the game by requesting information from the player. All prompts for
	 * this method are written in Spanish
	 */
	public void setupGameSpanish() {
		System.out.println();
		System.out.println("¡Bienvenido, " + getName() + "!");
		System.out.println(
				"El objetivo del juego es adivinar el número entero correcto entre 1 y 1000 en el menor número posible de intentos.");
	}

	/**
	 * Runs the game with prompts written in English
	 */
	public void playerGuessPrompt() {
		System.out.println("Guess a number between 1 and 1,000: ");
		guess = scanner.nextInt();
		checkGuess();
	}

	/**
	 * Runs the game with prompts written in Spanish
	 */
	public void playerGuessPromptSpanish() {
		System.out.println("Adivina un número entre 1 y 1000: ");
		guess = scanner.nextInt();
		checkGuessSpanish();
	}

	/**
	 * Checks the player's guess with prompts written in English
	 */
	public void checkGuess() {
		count++;
		String result;
		String countPrompt;

		if (guess > targetNumber) {
			result = "Your guess is too high!";
			System.out.print(result + " ");
			playerGuessPrompt();
			return; // Return serves to exit the method.
		}
		if (guess < targetNumber) {
			result = "Your guess is too low!";
			System.out.print(result + " ");
			playerGuessPrompt();
			return;
		}
		System.out.println(); // If you've cleared both conditionals, the guess must equal the target number
		result = "That is the correct number, " + getName() + "! You win!";
		countPrompt = "Number of guesses: ";
		System.out.println(result);
		System.out.println(countPrompt + getCount());
		stats.scores.add(count);
		endGame();
	}

	/**
	 * Checks the player's guess with prompts written in Spanish
	 */
	public void checkGuessSpanish() {
		String result;
		String countPrompt;
		count++;

		if (guess > targetNumber) {
			result = "¡Tu conjetura es demasiado alta!";
			System.out.print(result + " ");
			playerGuessPromptSpanish();
		}
		if (guess < targetNumber) {
			result = "¡Tu conjetura es demasiado baja!";
			System.out.print(result + " ");
			playerGuessPromptSpanish();
		}
		result = "¡Eso es correcto!"; // If you've cleared both conditionals, the guess must equal the target number
		countPrompt = "Número de conjeturas: ";
		System.out.println(result);
		System.out.println(countPrompt + getCount());
		endGameSpanish();
	}

	/**
	 * This method displays the player's stats at the end of a round and provides
	 * the option of playing again for English-speaking players
	 */
	public void endGame() {
		stats.scores.add(count);
		String playAgain;
		System.out.println("Rounds played: " + stats.getTotalGames());
		System.out.println("Your average score: " + stats.averageScore(stats.scores));
		System.out.println("Your low score: " + stats.lowScore(stats.scores));
		System.out.println("Your high score: " + stats.highScore(stats.scores));
		System.out.println();
		System.out.println("Do you want to play again? ( y / n )");
		playAgain = scanner.next();

		if (playAgain.toLowerCase().trim().equals("y")) {
			runGame();
		} else {
			System.out.println("Thanks for playing!");
		}
	}

	/**
	 * This method displays the player's stats at the end of a round and provides
	 * the option of playing again for Spanish-speaking players
	 */

	public void endGameSpanish() {
		stats.scores.add(count);
		String playAgain;
		System.out.println("Rondas jugadas: " + stats.getTotalGames());
		System.out.println("Tu puntuación media: " + stats.averageScore(stats.scores));
		System.out.println("Su puntaje bajo: " + stats.lowScore(stats.scores));
		System.out.println("Tu puntuación más alta: " + stats.highScore(stats.scores));
		System.out.println();
		System.out.println("¿Quieres jugar de nuevo? ( si / no )");
		playAgain = scanner.next();

		if (playAgain.toLowerCase().trim().equals("si")) {
			runGameSpanish();
		} else {
			System.out.println("¡Gracias por jugar!");
		}
	}

	/**
	 * A method to determine whether the user has indicated whether they are
	 * Spanish-speaker or an English-speaker * Spanish speaker
	 * 
	 * @return
	 */
	public boolean speaksSpanish() {
		return language.equals("spanish") || language.equals("espanol");
	}

	/**
	 * This method prompts the user to provide their language preference, which will
	 * determine which methods run for the remainder of the game
	 */
	public void setLanguage() {
		System.out.println("Please choose a language (English / Espanol): ");
		language = scanner.next().toLowerCase().trim();
	}

	/**
	 * @return the number of guesses made by the player
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Sets value for count variable
	 * 
	 * @param number of guesses
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * Gets the value for the guess variable
	 * 
	 * @return the guess that the player makes
	 */
	public int getGuess() {
		return guess;
	}

	/**
	 * Gets the value of the name variable
	 * 
	 * @return the name of the Player
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name variable for English-speaking players There is no
	 * parameter because the name is obtained by user input
	 */
	public void setName() {
		System.out.println("Please enter your name: ");
		name = scanner.next();
	}

	/**
	 * Sets the value of the name variable for Spanish-speaking players There is no
	 * parameter because the name is obtained by user input
	 */
	public void setNameSpanish() {
		System.out.println("introduzca su nombre: ");
		name = scanner.next();
	}

	/**
	 * Gets the value of the targetNumber variable
	 * 
	 * @return the targetNumber that the Player is intended to guess
	 */
	public int getTargetNumber() {
		return targetNumber;
	}

	/**
	 * Sets the value for the targetNumber variable There is no parameters because
	 * the value is set with a function
	 */
	public void setTargetNumber() {
		targetNumber = (int) (Math.random() * 1000) + 1;
	}
}