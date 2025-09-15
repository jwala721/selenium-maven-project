package code;

import java.util.HashMap;
import java.util.Map;

public class FindUniqueWords {
    public static void main(String[] args) {
        String str = "I am am Indian Indian brave";
        String[] words = str.split(" ");

        Map<String, Integer> wordCount = new HashMap<>();

        // Count occurrences of each word
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Print words that appear only once
        System.out.print("Unique words: ");
        for (String word : words) {
            if (wordCount.get(word) == 1) {
                System.out.print(word + " ");
            }
        }
    }
}
