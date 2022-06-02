import java.util.Locale;

public class StringArrayProblems {

    /**
     * Problem statement
     * -----------------
     * Implement an algorithm to determine if a string has all unique characters. What if you
     * cannot use additional data structures?
     */

    public static boolean isUniqueCharsBF(String input) {
        if (input.length() > 128) return false; // Bigger than then alphabet there must be a repetition

        for (int i = 0; i < input.length(); i++) {
            char singleChar = input.charAt(i);

            for (int j = i + 1; j < input.length(); j++) {
                if (singleChar == input.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    } // Time complexity: O(n^2) / Space complexity: O(1)

    public static boolean isUniqueCharsWithASCII(String input) {
        if (input.length() > 128) return false; // Bigger than then alphabet there must be a repetition

        // Note1: can be 256 on the extended ASCII
        // Note2: all the boolean init as false
        boolean[] charSet = new boolean[128];
        for (int i = 0; i < input.length(); i++) {
            int val = input.charAt(i);
            if (charSet[val]) {
                return false;
            }

            charSet[val] = true;
        }

        return true;
    } // Time complexity: O(n) / Space complexity: O(1)
}
