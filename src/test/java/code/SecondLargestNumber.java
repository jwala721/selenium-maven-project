package code;

public class SecondLargestNumber {
    public static void main (String[] args){
        int[] numbers= {12,45, 67, 23, 80, 73, 89};
        int largest= Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int number: numbers){
            if (number>largest){
                secondLargest = largest;
                largest = number;
            } else if (number>secondLargest && number!=largest) {
                secondLargest=number;
            }
        }
        System.out.println(secondLargest);
        System.out.println(largest);
    }
}
