package code;

import java.util.HashMap;
import java.util.Map;

public class AllDuplicateCharacters {
    public static void main(String[] args) {
        String inputString = "mohhaaan";
        Map<Character, Integer> charCount = new HashMap<>();

        // Count frequency of each character
        for (char c : inputString.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        System.out.println("Duplicate characters:");
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
    }
}
