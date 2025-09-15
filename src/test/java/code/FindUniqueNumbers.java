package code;

import java.util.HashMap;
import java.util.Map;

public class FindUniqueNumbers {
    public static void main(String[] args) {
        int[] a = {4, 2, 4, 5, 7, 9, 5, 7};

        Map<Integer, Integer> countMap = new HashMap<>();
        // Count occurrences of each number
        for (int num : a) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        // Print numbers that appear only once
        System.out.print("Unique numbers: ");
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
