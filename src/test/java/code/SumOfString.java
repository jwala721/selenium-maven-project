package code;

public class SumOfString {
    public static void main(String[] args){
        String[] arr= {"Ram", "Sam", "Raju"};
        String finalOutput = " ";
        for(String i:arr){
            finalOutput= finalOutput +i+ " ";
        }
        System.out.println(finalOutput);
    }
}
