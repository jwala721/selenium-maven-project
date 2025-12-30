//Move Vowels → Left | Consonants → Middle 
// | Special Characters → Right



public class RearrangeString {
    public static void main(String[] args) {
        String str = "a@b#e1i$";

        String vowels = "";
        String consonants = "";
        String special = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isLetter(ch)) {
                if ("aeiouAEIOU".indexOf(ch) != -1)
                    vowels += ch;
                else
                    consonants += ch;
            } else {
                special += ch;
            }
        }

        System.out.println(vowels + consonants + special);
    }
}