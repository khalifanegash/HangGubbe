package se.ec.utb.khalifa;

import java.util.Arrays;

public class HangMan
{
    private int numberOfGuesses;
    private StringBuilder usedLetter;
    private String secretWord;
    private char[] hiddenWord;
    public final int MAXGUESS = 8;


    public HangMan(String secretWord)
    {
        this.secretWord = secretWord;
        this.hiddenWord = new char[secretWord.length()];
        this.usedLetter = new StringBuilder();
        numberOfGuesses = 0;
        Arrays.fill(hiddenWord, '_');
    }


    @Override
    public String toString()
    {
        return String.copyValueOf(hiddenWord);
    }

    public boolean guess(String Word)
    {
        if (Word.equalsIgnoreCase(secretWord))
        {
            hiddenWord = secretWord.toCharArray();
            return true;
        }
        numberOfGuesses++;
        return false;
    }

    public boolean guess(char letter) {
        if (secretWord.contains(letter + ""))
        {

            for (int i = 0; i < secretWord.length(); i++)
            {
                if (letter == secretWord.charAt(i))
                {
                    hiddenWord[i] = letter;
                    usedLetter.append(letter);
                }

            }
            return true;
        }

    numberOfGuesses++;
    usedLetter.append(letter);
    return false;
}

public boolean checkGuess(String userInput)
{
    userInput =userInput.toLowerCase();
    // om det är ett ord return result guess (String)
    if (userInput.length() > 1) {
        return guess(userInput.toLowerCase());
    }
    // om längd = 1
    // kolla om den finns i stringbulder
    if (userInput.length() == 0) {
        throw new IllegalArgumentException("Nope");
    }
    // om det inte finns i strungbulder return resultat guess(char)
    if (!usedLetter.toString().contains(userInput)) {
        return guess(userInput.charAt(0));
    }
        return false;

}
public boolean winner()
{
        boolean win = String.valueOf(hiddenWord).equals(secretWord);
        return win;
}
public   int getGuessCount()
{
    return this.numberOfGuesses;

}
public StringBuilder getUsedLetters(){
        return usedLetter;
}

}

