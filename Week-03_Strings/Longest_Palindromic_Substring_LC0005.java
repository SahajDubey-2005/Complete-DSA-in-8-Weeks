public class Longest_Palindromic_Substring_LC0005 {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd length palindromes (e.g., "aba")
            int len1 = expandAroundCenter(s, i, i);

            // Case 2: Even length palindromes (e.g., "abba")
            int len2 = expandAroundCenter(s, i, i + 1);

            int maxLen = Math.max(len1, len2);

            // Update start and end pointers if a longer palindrome is found
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "babad";
        System.out.println("Output 1: " + longestPalindrome(s1)); // Expected: "bab" or "aba"

        // Test Case 2
        String s2 = "cbbd";
        System.out.println("Output 2: " + longestPalindrome(s2)); // Expected: "bb"
    }
}