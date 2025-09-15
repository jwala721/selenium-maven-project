package code;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateCharactersInString {
    public static void main(String[] args) {
        String inputString = "automation";
//        Set<Character> seen = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (char c : inputString.toCharArray()) {
            if (result.indexOf(String.valueOf(c))==-1) {
//                seen.add(c);
                result.append(c);
            }
        }

        System.out.println("String after removing duplicates: " + result.toString());
    }
}

/*
public class Main {
    public static void main(String[] args) {
    String str ="Jwalaa";

    Map<Character,Integer> charCount= new LinkedHashMap<>();
    for(char s:str.toCharArray()){
      charCount.put(s,charCount.getOrDefault(s,0)+1);
    }
    System.out.println(charCount);

    StringBuilder result = new StringBuilder();
    for(Map.Entry<Character,Integer> entry:charCount.entrySet()){
      result.append(entry.getKey());
    }
    System.out.println("RemoveDuplicate: " + result.toString());
}
}
 */
