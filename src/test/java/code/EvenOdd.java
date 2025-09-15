package code;

public class EvenOdd {
    public static void main(String[] args){
        int[] a={1,2,5,6,8,21};
        for (int i=0; i<a.length;i++){
            if (a[i]%2==0) {
                System.out.println("Even: " + a[i]);
            }
            else if (a[i]%2==1) {
                System.out.println("odd: " + a[i]);
            }

        }
    }
}
