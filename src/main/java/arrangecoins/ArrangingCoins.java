package arrangecoins;

import static java.lang.Integer.MAX_VALUE;

/**
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 *
 *
 * Example 1
 *
 *   n = 5
 *   The coins can form the following rows:
 *   o
 *   o o
 *   o o
 *
 *   Because the 3rd row is incomplete, we return 2.
 *
 *
 * Example 2
 *
 *   n = 8
 *   The coins can form the following rows:
 *   o
 *   o o
 *   o o o
 *   o o
 *
 *   Because the 4th row is incomplete, we return 3.
 *
 * Note:
 * In case of invalid arguments you should throw java.lang.IllegalArgumentException
 */

public class ArrangingCoins {

    public int arrangeCoins(Integer n) {
        if (n == null || n > MAX_VALUE || n < 0) {
            throw new IllegalArgumentException();
        } else if (n > 0) {
            int counter = 0;
            while (counter < n) {
                ++counter;
                n = n - counter;
            }
            return counter;
        } else
        return 0;
    }
}


