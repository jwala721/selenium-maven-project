package code;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FindDuplicateNumbersUsingSet {
    public static void main(String []args){
        int[] a={4,2,4,5,7,9,5,7};
        Set<Integer> obj= new HashSet();
        Set<Integer> duplicateValue = new LinkedHashSet();
        for (int i:a){
            if(obj.add(i)==false){
//                System.out.println(i);
                duplicateValue.add(i);
            }
        }
        System.out.println(duplicateValue);
    }
}



/*
Using map
public class Main {
    public static void main(String[] args) {
    int[] num = {2,2,2, 1,9,6,5,5,8};
    Map<Integer,Integer> intCount = new LinkedHashMap<>();

    for(int n:num){
      intCount.put(n,intCount.getOrDefault(n,0)+1);
    }
    System.out.println(intCount);

    System.out.println("Duplicate num: ");
    for(Map.Entry<Integer,Integer>entry:intCount.entrySet()){
      if(entry.getValue()>1){
        System.out.println(entry.getKey());
      }
    }
}
}
 */