package code;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class OccuranceOfCharacterInWord {
    public static void main(String[] args){
        String inputstring="moohhhaaaan";
        Map<Character,Integer> charactercount= new LinkedHashMap<>();
        for (char c:inputstring.toCharArray()){
            if (charactercount.containsKey(c)){
                charactercount.put(c,charactercount.get(c)+1);
            }else {
                charactercount.put(c,1);
            }
        }
        System.out.println(charactercount);
    }

}


/*
Another method to write this program
import java.util.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
      String input = "Raammm";
     Map<Character,Integer> characterCount = new LinkedHashMap<>();
     for (char c:input.toCharArray()) {
     characterCount.put(c,characterCount.getOrDefault(c,0)+1);
  }

  System.out.println(characterCount);
}
}
 */