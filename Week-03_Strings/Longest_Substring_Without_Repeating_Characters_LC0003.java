import java.util.Arrays;

public class Longest_Substring_Without_Repeating_Characters_LC0003 {

    public static int lengthOfLongestSubstring(String s) {
        // Direct Address Table for 128 ASCII characters (stores 1-based index)
        int[] lastSeen = new int[128];
        
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If character was seen inside current window, jump 'left' past its last location
            if (lastSeen[currentChar] > left) {
                left = lastSeen[currentChar];
            }

            // Store (right + 1) to distinguish uninitialized 0 from index 0
            lastSeen[currentChar] = right + 1;

            // Calculate current window length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "abcabcbb";
        System.out.println("Output 1: " + lengthOfLongestSubstring(s1)); // Expected: 3

        // Test Case 2
        String s2 = "bbbbb";
        System.out.println("Output 2: " + lengthOfLongestSubstring(s2)); // Expected: 1

        // Test Case 3
        String s3 = "pwwkew";
        System.out.println("Output 3: " + lengthOfLongestSubstring(s3)); // Expected: 3
    }
}