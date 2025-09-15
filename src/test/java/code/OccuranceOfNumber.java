package code;

import java.util.HashMap;
import java.util.Map;

public class OccuranceOfNumber {
    public static void main(String[] args){
        int[] a= {1,1,1,3,2,3,4,2};
        Map<Integer,Integer> numOcc =new HashMap<>();
        for(int i:a){
            numOcc.put(i,numOcc.getOrDefault(i,0)+1);
        }
        System.out.println(numOcc);
    }
}
