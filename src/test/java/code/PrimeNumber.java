package code;

public class PrimeNumber {
    public static void main(String[] args){
        int num =23;
        int numberOfFactor =0;
        for (int i=2; i<=num/2; i++) {
            if (num % i == 0) {
                numberOfFactor++;
            }
        }
                if (numberOfFactor==0)
                    System.out.println(num+ "is Prime");
                else
                    System.out.println(num+ "not prime");
            }
        }

