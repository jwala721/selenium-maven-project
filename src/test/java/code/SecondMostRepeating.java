public class SecondMostRepeating {
    public static void main(String[] args) {
        String str = "success";

        int[] freq = new int[256];

        for (char c : str.toCharArray()) {
            freq[c]++;
        }

        int first = 0, second = 0;
        char firstChar = 0, secondChar = 0;

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > first) {
                second = first;
                secondChar = firstChar;
                first = freq[i];
                firstChar = (char) i;
            } else if (freq[i] > second && freq[i] != first) {
                second = freq[i];
                secondChar = (char) i;
            }
        }

        System.out.println("Second most repeating character: " + secondChar);
    }
}