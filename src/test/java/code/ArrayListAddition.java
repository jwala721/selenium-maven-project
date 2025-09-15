package code;

import java.util.ArrayList;
import java.util.List;

public class ArrayListAddition {

    public static void main(String[] args) {
        // Create two ArrayLists
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Add elements to the first ArrayList
        list1.add(2);
        list1.add(6);
        list1.add(8);

        // Add elements to the second ArrayList
        list2.add(9);
        list2.add(5);
        list2.add(3);

        // Perform element-wise addition and store the result in a new ArrayList
        List<Integer> result = new ArrayList<>();

        if (list1.size() == list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                int sum = list1.get(i) + list2.get(i);
                result.add(sum);
            }
        } else {
            System.out.println("ArrayLists must have the same size for addition.");
        }

        // Print the result
        System.out.println("Result of addition: " + result);
    }
}
