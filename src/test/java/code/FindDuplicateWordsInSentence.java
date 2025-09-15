package code;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FindDuplicateWordsInSentence {
    public static void main(String[]args){
        String str= "I am am Indian Indian";
        String[] strarr= str.split(" ");

        Set<String> obj= new HashSet();
        Set<String> duplicateValue = new LinkedHashSet();
        for (String word :strarr){
            if (obj.add(word)==false){
                duplicateValue.add(word);
            }
        }
        System.out.println(duplicateValue);
    }
}



/*
public class FindDuplicateWordsInSentence {
    public static void main(String[] args) {
    String str ="I I Go PATNA PATNA";
    Map<String,Integer> strCount = new LinkedHashMap<>();

    for(String s:str.split(" ")){
      strCount.put(s,strCount.getOrDefault(s,0)+1);
    }
    System.out.println(strCount);

    System.out.println("Duplicate Words: ");
    for(Map.Entry<String,Integer>entry:strCount.entrySet()){
      if(entry.getValue()>1){
        System.out.println(entry.getKey());
      }
    }
}
}
 */