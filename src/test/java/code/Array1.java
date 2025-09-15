package code;

import java.util.LinkedHashMap;
import java.util.Map;

public class Array1 {
    public static void main(String[] args){
//        int[] a ={10, 20, 30, 40, 50};
//
////        for(int i=0; i < a.length-1; i++){
////            System.out.println(a[i] );
////        }
//
//        for (int i:a){
//            System.out.println(i);
//        }

        String str = "aautto";
        Map<Character,Integer> charCount = new LinkedHashMap<>();
        for(char s:str.toCharArray()){
            charCount.put(s,charCount.getOrDefault(s,0)+1);
        }
        System.out.println(charCount);
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character,Integer>entry:charCount.entrySet()){
            result.append(entry.getKey()).append(entry.getValue());
        }
        System.out.println(result);
    }
}
