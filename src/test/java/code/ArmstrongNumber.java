package code;

public class ArmstrongNumber {
    public static void main(String[] args) {
        int number = 153; // You can change this to test other numbers
        int original = number;
        int result = 0;

        while (number > 0) {
            int digit = number % 10;
            result += digit * digit * digit;
            number /= 10;
        }

        if (result == original) {
            System.out.println(original + " is an Armstrong number");
        } else {
            System.out.println(original + " is not an Armstrong number");
        }
    }
}
