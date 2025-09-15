package code;

import java.util.HashMap;
import java.util.Map;

public class OccurrenceOfWordsInSentence {
    public static void main(String[] args){
        String str= "i am am indian indian";
        Map<String,Integer> wordsOcc =new HashMap<>();
        for(String word:str.split(" ")){
            wordsOcc.put(word,wordsOcc.getOrDefault(word,0)+1);
        }
        System.out.println(wordsOcc);
    }
}
