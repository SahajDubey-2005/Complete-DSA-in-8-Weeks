public class Longest_Repeating_Character_Replacement_LC0424 {

    public static int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] charCount = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            // Update frequency of current character
            char currentChar = s.charAt(right);
            charCount[currentChar - 'A']++;

            // Track max frequency of any character in the window
            maxFreq = Math.max(maxFreq, charCount[currentChar - 'A']);

            // Number of characters to replace = windowLength - maxFreq
            int windowLength = right - left + 1;
            if (windowLength - maxFreq > k) {
                // Shrink window from the left
                charCount[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "ABAB";
        int k1 = 2;
        System.out.println("Output 1: " + characterReplacement(s1, k1)); // Expected: 4

        // Test Case 2
        String s2 = "AABABBA";
        int k2 = 1;
        System.out.println("Output 2: " + characterReplacement(s2, k2)); // Expected: 4

        // Test Case 3
        String s3 = "AAAA";
        int k3 = 2;
        System.out.println("Output 3: " + characterReplacement(s3, k3)); // Expected: 4
    }
}