import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {
        // Generate a random number between 1 and 100
        int targetNumber = (int) (Math.random() * 100) + 1;
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        int threshold = 10;
        int attempts = 0;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I have chosen a number between 1 and 100. Can you guess it?");
        System.out.println("Type your guesses below (or type -1 to quit):");

        while (isRunning) {
            System.out.print("Enter your guess: ");
            int userGuess = sc.nextInt();
            attempts++;

            // Check if the user wants to quit
            if (userGuess == -1) {
                System.out.println("You have exited the game. Thanks for playing!");
                break;
            }

            // Calculate the difference between the guess and the target number
            int difference = Math.abs(targetNumber - userGuess);

            if (difference == 0) {
                System.out.println("Exact match! You guessed the number in " + attempts + " attempts.");
                isRunning = false; // End the game
            } else if (difference <= threshold) {
                System.out.println("You're close! Try again.");
                if (userGuess < targetNumber) {
                    System.out.println("Hint: The number is higher than " + userGuess);
                } else {
                    System.out.println("Hint: The number is lower than " + userGuess);
                }
            } else {
                System.out.println("You're far away. Keep trying!");
                if (userGuess < targetNumber) {
                    System.out.println("Hint: The number is higher than " + userGuess);
                } else {
                    System.out.println("Hint: The number is lower than " + userGuess);
                }
            }
        }

        sc.close();
    }
}

