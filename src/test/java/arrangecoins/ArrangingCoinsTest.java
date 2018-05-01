package arrangecoins;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArrangingCoinsTest {

    private ArrangingCoins underTest;

    @BeforeMethod
    public void setUp() {
        underTest = new ArrangingCoins();
    }

    @DataProvider
    public static Object[][] expectedRows() {
        return new Object[][] {
                { 0, 0 },
                { 1, 1 },
                { 2, 1 },
                { 3, 2 },
                { 4, 2 },
                { 5, 2 },
                { 6, 3 },
                { 7, 3 },
                { 8, 3 },
                { 9, 3 },
                { 10, 4 }
        };
    }

    @DataProvider
    public static Object[][] invalidInput() {
        return new Object[][] {
                { null },
                { -1 }
        };
    }


    @Test(dataProvider = "expectedRows")
    public void shouldReturnExpectedRows(int coins, int expectedRows) {
        int actualRows = underTest.arrangeCoins(coins);
        assertEquals(actualRows, expectedRows);
    }

    @Test(dataProvider = "invalidInput", expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenInputIsNull(Integer coins) {
        underTest.arrangeCoins(coins);
    }

    @Test
    public void shouldReturnExpectedResult() {
        int actualRows = underTest.arrangeCoins(20);
        assertEquals(actualRows, 5);
    }

    @Test(timeOut = 50)
    public void shouldNotBeSlow() {
        underTest.arrangeCoins(Integer.MAX_VALUE);
        Assert.assertTrue(true);
    }

}