package code;

public class FibonacciSeries {
    public static void main (String[] args){
        int first = 0, second = 1, next;
        System.out.println("Fibonacci series is ");
        for ( int i = 0; i<=15; i++)
        {
            System.out.print(first + " ");
            next = second+first;
            first = second;
            second = next;
        }
    }
}
