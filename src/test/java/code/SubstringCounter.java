package code;

import java.util.Arrays;

public class SubstringCounter {
    public static void main(String[] args) {
        String[] str = {"pen", "pen", "pencil", "pencil"};
        String target = "pen";
        int count = 0;

        for (String word : str) {
            if (word.contains(target)) {
                count++;
            }
        }

        System.out.println(target + " = " + count);
    }
}
