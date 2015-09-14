import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String difficulty = "";

        String guess = "";
        String clue = "";

        Boolean choice = false;
        do {
            System.out.println("Welcome to Hangman.\n");
            System.out.println("Please choose difficulty level: (E)asy||(M)edium||(H)ard");
            difficulty = input.nextLine();

            difficulty = difficulty.toLowerCase();
            switch (difficulty) {
                case "e":
                    difficulty = "Easy";
                    break;
                case "m":
                    difficulty = "Medium";
                    break;
                case "h":
                    difficulty = "Hard";
                    break;
            }

            Hangman h1 = new Hangman();

            h1.draw();
            Words w1 = new Words(difficulty);

            while (!w1.isDone() && !h1.isDead()) {
                if (!w1.makeGuess()) {
                    h1.badGuess();
                }
                h1.draw();
            }

            if (h1.isDead()) {
                System.out.println("Sorry you lost!");
            } else {
                System.out.println("You Won!");
            }

            Boolean goodAnswer = true;
            do {
                String answer = "";

                System.out.println("=========================================");
                System.out.println("Would you like to play again? (Y)es||(N)o");
                System.out.println("=========================================");
                answer = input.nextLine();

                if (answer.equalsIgnoreCase("Y")) {
                    choice = true;
                    goodAnswer = true;
                } else if (answer.equalsIgnoreCase("N")) {
                    choice = false;
                    goodAnswer = true;
                    System.exit(0);
                } else {
                    goodAnswer = false;
                    System.out.println("Your answer \"" + answer + "\" should be Y or N.");
                }
            } while (!goodAnswer);
        } while (choice);
    }
}
