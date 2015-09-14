import java.util.*;

public class Hangman {
	
    int wrong = 0;

    public Hangman() {
    }

    public Boolean isDead() {
        return wrong > 6;
    }

    public void badGuess() {
        wrong++;
    }

    public void draw() {
        char a = ' ';
        char b = ' ';
        char c = ' ';
        char d = ' ';
        char e = ' ';
        char f = ' ';
        char g = ' ';

        for (int i = 1; i <= wrong; i++) {
            switch (i) {
                case 1:
                    g = 'O';
                    break;
                case 2:
                    b = '|';
                    break;
                case 3:
                    a = '/';
                    break;
                case 4:
                    c = '\\';
                    break;
                case 5:
                    d = '|';
                    break;
                case 6:
                    e = '/';
                    break;
                case 7:
                    f = '\\';
                    break;
            }
        }
        System.out.println(" |-----");
        System.out.println(" |    |");
        System.out.printf(" |    %s\n", g);
        System.out.printf(" |   %s%s%s \n", a, b, c);
        System.out.printf(" |    %s\n", d);
        System.out.printf(" |   %s %s \n", e, f);
        System.out.println(" | ");
        System.out.println("------------");
    }
}
