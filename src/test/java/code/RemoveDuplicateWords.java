package code;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateWords {
    public static void main(String[] args) {
        String str = "I am am Indian Indian";
        String[] words = str.split(" ");

        Set<String> uniqueWords = new LinkedHashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }

        // Join the words back into a string
        StringBuilder result = new StringBuilder();
        for (String word : uniqueWords) {
            result.append(word).append(" ");
        }

        // Trim trailing space and print
        System.out.println(result.toString().trim());
    }
}


/*
By using Map

public class RemoveDuplicateWords {
    public static void main(String[] args) {
    String str ="I am am Indian Indian";

    Map<String,Integer> charCount= new LinkedHashMap<>();
    for(String s:str.split(" ")){
      charCount.put(s,charCount.getOrDefault(s,0)+1);
    }
    System.out.println(charCount);

    StringBuilder result = new StringBuilder();
    for(Map.Entry<String,Integer> entry:charCount.entrySet()){
      result.append(entry.getKey()).append(" ");
    }
    System.out.println("RemoveDuplicate: " + result.toString().trim());
}
}
 */