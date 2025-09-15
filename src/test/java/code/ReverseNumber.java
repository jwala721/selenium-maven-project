package code;

import java.util.LinkedHashMap;
import java.util.Map;

public class ReverseNumber {
    public static void main(String [] args){
       String str ="tom,tom,tom,john,john,joe";


        Map<String,Integer> wordCount = new LinkedHashMap<>();
        for(String s:str.split(",")){
            wordCount.put(s,wordCount.getOrDefault(s,0)+1);
        }
        System.out.println(wordCount);
        int maxCount =0;
        String Name= " ";
        for(Map.Entry<String,Integer>entry:wordCount.entrySet()){
            if(entry.getValue()>maxCount){
                maxCount = entry.getValue();
                Name= entry.getKey();

            }
        }
        System.out.println(maxCount+"="+Name);


    }
}
