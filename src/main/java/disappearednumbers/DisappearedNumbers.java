package com.evosoft.disappearednumbers;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given an array of integers where 1 <= a[i] <= n (n = size of array),
 * some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 * 
 * Note:
 * In case of invalid arguments you should throw java.lang.IllegalArgumentException
 */

public class DisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> allNums = IntStream.range(1, nums.length).boxed().collect(toList());
        List<Integer> distinctNums = stream(nums).distinct().sorted().boxed().collect(toList());
        for (int i : nums) {
            if (i < 0 || i > nums.length) {
                throw new IllegalArgumentException();
            }
        }
        return allNums.stream().filter(i -> !distinctNums.contains(i)).collect(toList());
    }
}
