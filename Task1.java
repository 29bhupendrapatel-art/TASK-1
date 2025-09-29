package CodeSoftProject;
import java.util.Random;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int secret_number = random.nextInt(100) + 1; // Generates a number from 1 to 100
            int attempts = 0;
            final int MAX_ATTEMPTS = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nI'm thinking of a number between 1 and 100.");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Attempt " + (attempts + 1) + "/" + MAX_ATTEMPTS + ": Enter your guess: ");

                if (sc.hasNextInt()) {
                    int user_guess = sc.nextInt();
                    attempts++;

                    if (user_guess < secret_number) {
                        System.out.println("Too low! 📉 Try a higher number.");
                    } else if (user_guess > secret_number) {
                        System.out.println("Too high! 📈 Try a lower number.");
                    } else {
                        System.out.println("🎉 Congratulations! You guessed the number " + secret_number + " correctly in " + attempts + " attempts!");
                        guessedCorrectly = true;
                        score += (MAX_ATTEMPTS - attempts + 1) * 10;
                        break;
                    }
                } else {
                    System.out.println("That's not a valid number. Please try again.");
                    sc.next(); // Clear the invalid input from the scanner
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nGame Over! You ran out of attempts. The secret number was " + secret_number + ".");
            }

            System.out.println("Your current score is: " + score);

            System.out.print("\nWould you like to play another round? (yes/no): ");
            String response = sc.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\nThanks for playing! Final score: " + score);
        sc.close();
    }
}

