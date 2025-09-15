package code;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateNumber {
    public static void main(String[] args) {
        int[] a = {4, 2, 4, 5, 7, 9, 5, 7};

        Set<Integer> uniqueSet = new LinkedHashSet<>();
        for (int num : a) {
            uniqueSet.add(num);
        }
        // Convert Set back to array (optional)
        int[] result = new int[uniqueSet.size()];
        int i = 0;
        for (int num : uniqueSet) {
            result[i++] = num;
        }
        // Print the result
        System.out.print("Array after removing duplicates: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
