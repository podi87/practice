package com.evosoft.ransomnote;

import static java.util.stream.Collectors.toList;

import java.util.List;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ;
 * otherwise, it will return false.
 * <p>
 * Each letter in the magazine string can only be used once in your ransom note.
 * <p>
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * <p>
 * Note:
 * In case of invalid arguments you should throw java.lang.IllegalArgumentException
 */

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine == null || ransomNote == null || magazine.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            ransomNote = ransomNote.replaceAll(" ", "");
            magazine = magazine.replace(" ", "");

            List<Character> ransomList = ransomNote.chars()
                    .mapToObj(c -> (char) c)
                    .sorted()
                    .collect(toList());
            List<Character> magazineList = magazine.toLowerCase().chars()
                    .mapToObj(c -> (char) c)
                    .sorted()
                    .collect(toList());

            return ransomList.stream().allMatch(magazineList::remove);
        }
    }

}
