package reverseVowels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Example 1:
 * Given s = "hello", return "holle".
 * <p>
 * Example 2:
 * Given s = "letmecode", return "letmocede".
 * <p>
 * Note:
 * The vowels does not include the letter "y".
 * The vowels could be capital letters as well.
 */
public class ReverseVowels {

    public String reverseVowels(String input) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        StringBuilder sb = new StringBuilder(input);
        char[] revWord = sb.reverse().toString().toCharArray();
        char[] word = input.toCharArray();
        List<Integer> indexCounter = new ArrayList<>();

        for (int i = 0; i < word.length; i++) {
            if (vowels.contains(word[i])){
                for (int j = 0; j < revWord.length; j++){
                    if (vowels.contains(revWord[j]) && !indexCounter.contains(j)){
                        word[i] = revWord[j];
                        indexCounter.add(j);
                        break;
                    }
                }
            }
        }
        input = String.valueOf(word);
        return input;
    }

    public String reverseVowels1(String input) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        input.chars().forEach(changeLetters(vowels, input));
        return input;
    }

    public IntConsumer changeLetters(List<Character> vowels, String input) {
        StringBuilder sb = new StringBuilder(input);
        char[] revWord = sb.reverse().toString().toCharArray();
        char[] word = input.toCharArray();
        List<Integer> indexCounter = new ArrayList<>();
        for (int i = 0; i < word.length; i++) {
            if (vowels.contains(word[i])){
                for (int j = 0; j < revWord.length; j++){
                    if (vowels.contains(revWord[j]) && !indexCounter.contains(j)){
                        word[i] = revWord[j];
                        indexCounter.add(j);
                        break;
                    }
                }
            }
        }
        input = String.valueOf(word);
        System.out.println(input);
        return null;
    }
}