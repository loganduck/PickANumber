import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

/**
 * Pick a number between 1 -> 21.
 * You have 3 guesses to get it right!
 * 
 * @author LoganDuck
 * @version 9/10/17
 */
public class PickANumber {
	static Random rand = new Random();
	static int number = rand.nextInt(21) + 1;
	static Scanner scan = new Scanner(System.in);
	
	public static void main (String[] args) {
		int counter = 1;
		System.out.print("Pick a number between 1 and 21: ");
		// Makes sure the user enters int's only.
		try {
		int value = scan.nextInt();
		while (value != number) {
			// Only values between 1 and 21 can be used.
			while (value > 21) {
				System.out.println("Value too large. Please enter a new value: ");
				value = scan.nextInt();
			}
			// Only values between 1 and 21 can be used.
			while (value <= 0) {
				System.out.println("Value too small. Please enter a new value: ");
				value = scan.nextInt();
			}
			if (value > number && value <= 21 && value > 0) {
				System.out.print("Lower! Please guess again: ");
				value = scan.nextInt();
				counter = counter + 1;
			}
			if (value < number && value <= 21 && value > 0) {
				System.out.print("Higher! Please guess again: ");	
				value = scan.nextInt();
				counter = counter + 1;
			}
			// Only 3 chances to guess the right number.
			if (counter == 3) {
				break;
			}
		}
		
		if (value == number) {
			System.out.println("YOU WIN!");
		}
		if (value != number) {
			System.out.println("You lose. " + PickANumber.number + " was the magic number. Run and play again!");
		}
		
		} catch (InputMismatchException e) {
			System.out.println("Only numbers accepted. Please run again!");
		}
	}	
}
