package reverseVowels;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ReverseVowelsTest {

    private ReverseVowels underTest = new ReverseVowels();

    @Test
    public void shouldReverseHello() {
        //GIVEN

        //WHEN
        String output = underTest.reverseVowels("hello");

        //THEN
        assertEquals(output, "holle");
    }

    @Test
    public void shouldReverseCapitalHello() {
        //GIVEN

        //WHEN
        String output = underTest.reverseVowels("HELLO");

        //THEN
        assertEquals(output, "HOLLE");
    }

    @Test
    public void shouldReverseCapitalLetters() {
        //GIVEN

        //WHEN
        String output = underTest.reverseVowels("letmecode");

        //THEN
        assertEquals(output, "letmocede");
    }
}