package code;

public class SumOfStrings {
    public static void main(String[]args){
        String[] str={"Ram","sam","dev"};
        String finaloutput=" ";
        for (String s:str){
            finaloutput= finaloutput+s+" ";
        }
        System.out.println(finaloutput);
    }
}
