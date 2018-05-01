package ransomNote;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RansomNoteTest {

    private RansomNote underTest;

    @BeforeMethod
    public void setUp() throws Exception {
        underTest = new RansomNote();
    }

    @DataProvider
    public static Object[][] canConstruct() {
        return new Object[][] {
                { "aa", "aab" },
                { "ransom", "rsnaom" },
                { "cookies", "cokieos&eoee+hnsuitoh!" }
        };
    }

    @DataProvider
    public static Object[][] canNotConstruct() {
        return new Object[][] {
                { "a", "b" },
                { "aa", "ab" },
                { "cookies", "cokiesc" }
        };
    }

    @DataProvider
    public static Object[][] canConstructWithSpaces() {
        return new Object[][] {
                { "this is a sample ransom note", "tanshoioailrssemnpsamte" },
                { "give us the cookies & nobody gets hurt!", "gokdrregsoweviuttcysb&eoee+hnsuitoh!" },
        };
    }

    @DataProvider
    public static Object[][] canNotConstructWithSpaces() {
        return new Object[][] {
                { "this is a sample ransom note", "tanshoioilrssemnpsamt" },
                { "give us the cookies & nobody gets hurt!", "gokdrregsoweviuttcysbeoee+hnsuitoh!5" },
        };
    }

    @DataProvider
    public static Object[][] invalidInput() {
        return new Object[][] {
                { null, "magazine" },
                { "ransom", null },
                { null, null }
        };
    }


    @Test(dataProvider = "canConstruct")
    public void shouldBeAbleToConstructWords(String ransom, String magazine) {
        boolean canConstruct = underTest.canConstruct(ransom, magazine);
        assertTrue(canConstruct);
    }

    @Test(dataProvider = "canNotConstruct")
    public void shouldNotBeAbleToConstructWords(String ransom, String magazine) {
        boolean canConstruct = underTest.canConstruct(ransom, magazine);
        assertFalse(canConstruct);
    }

    @Test(dataProvider = "canConstructWithSpaces")
    public void shouldBeAbleToConstructSentences(String ransom, String magazine) {
        boolean canConstruct = underTest.canConstruct(ransom, magazine);
        assertTrue(canConstruct);
    }

    @Test(dataProvider = "canNotConstructWithSpaces")
    public void shouldNotBeAbleToConstructSentences(String ransom, String magazine) {
        boolean canConstruct = underTest.canConstruct(ransom, magazine);
        assertFalse(canConstruct);
    }

    @Test(dataProvider = "invalidInput", expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenInputIsNull(String ransom, String magazine) {
        underTest.canConstruct(ransom, magazine);
    }

    @Test
    public void shouldBeAbleToConstruct() {
        boolean canConstruct = underTest.canConstruct("", "magazine");
        assertTrue(canConstruct);
    }

    @Test
    public void shouldNotBeAbleToConstruct() {
        boolean canConstruct = underTest.canConstruct("ransom", "        ");
        assertFalse(canConstruct);
    }

}