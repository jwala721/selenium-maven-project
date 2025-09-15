package code;

public class SpacingWithString {
    public static void main (String[] args){
        String s = "My--Name---------Is----------Jwala";
        for(;;){
            if(s.contains("--")){
                s = s.replaceAll("--","-");
            }else
                break;
        }
        System.out.println(s);
    }
}
