package code;

import java.util.Arrays;

public class MoveZeroToStart {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 0, 3, 0, 4, 5};

        int[] result = new int[arr.length];
        int index = arr.length - 1; // Start from the end of result array

        // Fill from end with non-zero elements
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                result[index] = arr[i];
                index--;
            }
        }
        // Remaining elements (from 0 to index) will be 0 by default
        System.out.println("After moving zeros to start: " + Arrays.toString(result));
    }
}
