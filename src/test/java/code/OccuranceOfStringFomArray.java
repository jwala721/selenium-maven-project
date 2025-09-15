package code;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class OccuranceOfStringFomArray {

    public static void main(String[] args) {
        String input = "jwwala";
        char[] filterChars = {'a', 'j'};

        // Convert filter array to Set for faster lookup
        Set<Character> filterSet = new HashSet<>();
        for (char ch : filterChars) {
            filterSet.add(ch);
        }

        // Count characters using LinkedHashMap to maintain order
        Map<Character, Integer> characterCount = new LinkedHashMap<>();
        for (char c : input.toCharArray()) {
            if (filterSet.contains(c)) {
                characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
            }
        }

        // Print the result
        for (Map.Entry<Character, Integer> entry : characterCount.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}



/*
public class Main {
    public static void main(String[] args) {
   String input = "jwwala";
        char[] filterChars = {'a', 'j'};

        // Count characters using LinkedHashMap to maintain order
        Map<Character, Integer> characterCount = new LinkedHashMap<>();
        for (char c : input.toCharArray()) {

                characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);

        }
        for(char c:filterChars){
          int count = characterCount.getOrDefault(c,0);
          System.out.println(c +"="+ count);
        }

}
}
 */
