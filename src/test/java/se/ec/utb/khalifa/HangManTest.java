package se.ec.utb.khalifa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HangManTest {
    HangMan hangMan;

    @Before
    public void setup() {
       hangMan = new HangMan("testakanske");
    }
        /* måste kolla en bokstav som  i ordet.
        måste kolla en bokstav som  int finns i ordet.
        måste kolla om gissningen är samma som ordet
        måste kolla om gissningen är  inte samma som ordet
        måste kolla om samma bokstav gissas två gångar

        */

    // test av strärgrepresentation
    @Test
    public void given_nothing_returns_underscores() {
        String expected = "___________";
        String actual = hangMan.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_ifWordContainsLetter() {
        String letter = "T";
        Assert.assertTrue(hangMan.checkGuess(letter));
        String expected = "t__t_______";
        Assert.assertEquals(expected, hangMan.toString());
        int expectedGuessCount = 0;
        Assert.assertEquals(expectedGuessCount, hangMan.getGuessCount());
    }

    @Test
    public void letter_Not_contained()
    {
        String letter = "Ö";
        Assert.assertFalse(hangMan.checkGuess(letter));
        String expected = "___________";
        Assert.assertEquals(expected,hangMan.toString());
        int expectedGuessCount = 1;
        Assert.assertEquals(expectedGuessCount, hangMan.getGuessCount());

    }

    @Test
    public void test_correct_word() {
        String word = "testakanske";
        Assert.assertTrue(hangMan.checkGuess(word));
        Assert.assertEquals(0, hangMan.getGuessCount());
        Assert.assertEquals(word, hangMan.toString());
        Assert.assertTrue(hangMan.winner());

    }

    @Test
    public void test_ifWordContains_doubleguess_letter() {
        String letter = "T";
        String expected = "t__t_______";
        Assert.assertTrue(hangMan.checkGuess(letter));

        //hangMan.guess(letter);
        hangMan.guess(letter);
        // int expectedGuessCount = 0;
        Assert.assertEquals(expected, hangMan.toString());
        Assert.assertNotEquals("t", hangMan.getUsedLetters());
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_empty_string_thhrow_illegalarguments()
    {
        hangMan.checkGuess("");
    }
}
