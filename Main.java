import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            playGame(scanner);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        } while (playAgain);

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    public static void playGame(Scanner scanner) {
        int maxAttempts = 5; // Limit the number of attempts
        int attempts = 0;
        int randomNumber = (int) (Math.random() * 100); // Generate a random number between 0 and 99

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("Guess a number between 0 and 99.");

        do {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number!");
                break;
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've run out of attempts.");
                break;
            }
        } while (true);

        int score = calculateScore(maxAttempts, attempts);
        System.out.println("Your score for this round: " + score);
    }

    public static int calculateScore(int maxAttempts, int attempts) {
        // Example scoring: More points for fewer attempts
        int baseScore = 1000; // Base score for guessing within the attempts limit
        int penalty = 100; // Penalty for each attempt over the limit

        if (attempts <= maxAttempts) {
            return baseScore - (attempts - 1) * penalty;
        } else {
            return 0; // If attempts exceed the limit, score is 0
        }
    }
}

