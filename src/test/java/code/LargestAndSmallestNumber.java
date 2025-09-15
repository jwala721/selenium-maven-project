package code;

public class LargestAndSmallestNumber {
    public static void main(String[] args){
        int[] a= {10, -20, 30};
        int largest = a[0];
        int smallest = a[0];
        for(int i:a){
            if(i>largest){
                largest= i;
            } else if (i<smallest) {
                smallest = i;
            }
        }
        System.out.println("Largest no: " +largest);
        System.out.println("smallest no: "+smallest);
    }
}
