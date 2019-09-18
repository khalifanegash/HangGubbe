package se.ec.utb.khalifa;

import java.util.Random;
import java.util.Scanner;

public class Main
{
    private static String[] wordList = {"lite","random","ord","kanske","eventuellt",};
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String word = wordList[random.nextInt(wordList.length)];
        HangMan hangMan = new HangMan(word);
        System.out.println(" Welcome to HangMan");
        do {
            System.out.println(" Guess a letter or Word");
            String input = scanner.nextLine();
            hangMan.checkGuess(input);
            System.out.println(String.format("You have guessed %d",hangMan.getGuessCount()));
            System.out.println(" the secret is: " + hangMan);
        }  while (!hangMan.winner() && hangMan.getGuessCount() < hangMan.MAXGUESS) ;


    }
}
