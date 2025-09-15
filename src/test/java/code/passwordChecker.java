package code;

public class passwordChecker {
    public static void main(String[] args) {
        System.out.println(checkPassword("Jw@h11kjm"));

    }

    static boolean checkPassword(String pwd) {
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean num = false;
        boolean symbol = false;
        if (pwd.length() < 8) {
            return false;
        }
        for (char p : pwd.toCharArray()) {
            if (Character.isUpperCase(p)) {
                upperCase = true;
            }
            if (Character.isLowerCase(p)) {
                lowerCase = true;
            }
            if (Character.isDigit(p)) {
                num = true;
            }
            if (!Character.isDigit(p) && !Character.isAlphabetic(p)) {
                symbol = true;
            }
        }
        return upperCase && lowerCase && num & symbol;
    }
}
