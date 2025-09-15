package code;

public class ConvertSmallcaseTouppercase {
    public static void main(String [] args)  {
        String name = "Jwala Kumar";
        String[] words = name.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                // Convert first character to lowercase, rest to uppercase
                String converted = Character.toLowerCase(word.charAt(0)) + word.substring(1).toUpperCase();
                result.append(converted).append(" ");
            }
        }

        // Trim trailing space and print
        System.out.println(result.toString().trim());
    }
}

/*
First letter of each word → lowercase
Rest of the letters in the word → uppercase

Splits the string into words using space " " as the delimiter.
Now words[0] = "Jwala", words[1] = "Kumar"

We use a StringBuilder to efficiently build the final string as we process each word.

This is the core transformation:
word.charAt(0) — gets the first character of the word.
Character.toLowerCase(...) — converts the first letter to lowercase.
word.substring(1).toUpperCase() — gets the rest of the word (from index 1 to end) and converts it to uppercase.
These two parts are concatenated to form the transformed word.
For example:
"Jwala" → 'j' + "WALA" → "jWALA"
"Kumar" → 'k' + "UMAR" → "kUMAR"

result.toString() turns the StringBuilder into a regular string.
.trim() removes the extra space at the end.
System.out.println(...) prints the final result.




public class Main {
    public static void main(String[] args) {
        String name = "JwAla Kumar";
        StringBuilder result = new StringBuilder();

        for (char ch : name.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                result.append(Character.toUpperCase(ch));
            } else {
                result.append(ch); // Keep spaces or symbols unchanged
            }
        }

        System.out.println(result.toString()); // Output: jWaLA kUMAR
    }
}


 */