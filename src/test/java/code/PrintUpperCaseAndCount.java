package code;

public class PrintUpperCaseAndCount {
    public static void main(String[] args) {
        String s="Years of Experience as a Software Test Engineer. Career Objective: Seek to obtain a\r\n"
                + "challenging and responsible position in the field of Software Testing where my knowledge and\r\n"
                + "ability will be utilized towards the growth of the organization\r\n"
                + "L1 discussion with Prashant-QA Automation";
        int count = 0;
        for (int i=0; i< s.length(); i++){
            if(Character.isUpperCase(s.charAt(i))){
                count++;
                System.out.print(s.charAt(i));

            }
        }
        System.out.println(" ");
        System.out.print("print the count of upper case: " +count);
    }
}
