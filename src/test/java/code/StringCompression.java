package code;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringCompression {
    public static void main(String [] args){
        String str = "abbccc";
        Map<Character,Integer> charCount= new LinkedHashMap<>();
        for(char s:str.toCharArray()){
            charCount.put(s,charCount.getOrDefault(s,0)+1);
        }
        System.out.println(charCount);
        StringBuilder compressed = new StringBuilder();
        for (Map.Entry<Character,Integer>entry:charCount.entrySet()){
            compressed.append(entry.getKey()).append(entry.getValue());
        }
        System.out.println(compressed);
    }
}
