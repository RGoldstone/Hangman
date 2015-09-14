import java.util.*;

public class Words {


    String wordsEasy[] = {"door", "phone", "bottle", "coffee", "paper", "shirt", "pants", "wheel",
        "square", "pizza", "Open this to get into a room", "Makes calls", "It holds liquid",
        "The best part of waking up", "You write on this", "You wear this", "You wear this",
        "Part of a vehicle", "Not round", "You eat this"};

    String wordsMedium[] = {"program", "sweatshirt", "razor", "tattoo", "pencil",
        "jacket", "mouse", "tiger", "monkey", "bear", "What a computer runs", "Long-sleeved apparel",
        "Thin and sharp", "Permanent ink drawing", "Wood and graphite", "Wear this when cold", "Jerry",
        "Striped hunter", "Nature's clown", "Hangs out with lions and tigers"};

    String wordsHard[] = {"wheelchair", "automobile", "firecracker", "cellular",
        "hemodynamics", "cardiomyopathy", "hypertrohy", "cardiology", "antidisestablishmentarianism",
        "echocardiography", "Round legs for those who can't walk", "A mode of transportation", "Fourth of July",
        "Type of phone we use", "The flow of blood", "Chronic disease of the heart muscle",
        "Abnormal enlargement of an organ or muscle", "The study of the heart", "World's 2nd longest word",
        "Ultrasound used to investigate the heart"};

    String random = "";
    String guess = "";
    String clue = "";
    String word = "";
    String guesses = "";
    String guessWord[];
    boolean done;
    Scanner in = new Scanner(System.in);

    // Random number generator for words in string array, and their respective clue
    
    public Words(String difficulty) {

        if (difficulty == "Easy") {
            int num = (int) (Math.random() * 10);
            random = wordsEasy[num];
            clue = wordsEasy[num + 10];
        } else if (difficulty == "Medium") {
            int num = (int) (Math.random() * 10);
            random = wordsMedium[num];
            clue = wordsMedium[num + 10];
        } else {
            int num = (int) (Math.random() * 10);
            random = wordsHard[num];
            clue = wordsHard[num + 10];
        }

        String word1 = random;

        //System.out.println(random);
        //System.out.println(clue);

        
        // create the array to be the as long as the number of letters in word
        guessWord = new String[word1.length()]; 

        // fill the array with hyphens
        for (int i = 0; i < word1.length(); i++) {
            guessWord[i] = "_";
        }
    }

    //create a guess string to show guessed letters
    
    public Boolean makeGuess() {
    	for (int i = 0; i < guessWord.length; i++) {
    		System.out.print(guessWord[i]);
    	}
    	System.out.println("");
    	System.out.println(clue);
        System.out.println("\nGuess a letter!");
        String guess = in.nextLine();

        guesses = guesses + guess;

        done = true;
        
        
        
        for (int i = 0; i < guessWord.length; i++) {
            if(guess.equalsIgnoreCase(random.substring(i, i+1))) {
                guessWord[i] = guess;
            }
            if(guessWord[i].equalsIgnoreCase("_")) {
                done = false;
            }
            System.out.print(guessWord[i]);
        }
        System.out.println("");

        System.out.println("Guesses: " + guesses);

        return random.contains(guess);
    }
    
    public boolean isDone() {
        return done;
    }
}
