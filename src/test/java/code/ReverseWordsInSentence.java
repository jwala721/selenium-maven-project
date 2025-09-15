package code;

public class ReverseWordsInSentence {
    public static void main(String[] args){
        String str= "Hello World Program";
        String result =" ";
        String[] words= str.split(" ");
        for (String word:words){
            String reverseWord=" ";
            for (int i=word.length()-1; i>=0; i--){
                reverseWord = reverseWord + word.charAt(i);
            }
            result =result + reverseWord + " ";
        }
        System.out.println(result.trim());
    }
}


//class Main {
//    public static void main(String[] args) {
//        String str = "ancdef1234";
//        StringBuilder result = new StringBuilder();
//        for(int i=str.length()-1; i>=0; i--){
//            result.append(str.charAt(i));
//        }
//        System.out.println(result.toString());
//    }
//}
