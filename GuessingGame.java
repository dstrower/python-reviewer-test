import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        int computerNumber = (int) (Math.random()*100 + 1);
        System.out.println("A random number has been generated...");
        int numberOfTries = 0;
        boolean finishedGuessing = false;
        Scanner scanner = new Scanner(System.in);
        while(!finishedGuessing) {
            numberOfTries++;
            finishedGuessing = getGuess(scanner,computerNumber,numberOfTries);
        }
    }

    private static boolean getGuess( Scanner scanner,int computerNumber, int numberOfTries) {
        boolean done = false;
        int userAnswer = 0;
        while(!done) {

            System.out.println("Enter a guess between 1 and 100");
            userAnswer = scanner.nextInt();


            if (userAnswer <= 0 || userAnswer > 100) {
                System.out.println("Invalid response");
            } else {
                done = true;
            }
        }
        if (userAnswer == computerNumber ){
            System.out.println("Correct! You win! See you next time!");
            return true;
        }
        else if (userAnswer > computerNumber) {
            System.out.println("Your guess is too high");
        }
        else if (userAnswer < computerNumber) {
            System.out.println("Your guess is too low, guess again.");
        }
        if(numberOfTries < 3) {
            return false;
        } else {
            System.out.println("Sorry for your luck, restart the program to play again!");
            return true;
        }
    }
}