public class Longest_Substring_Without_Repeating_Characters_LC0003 {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Stores the next valid position for left pointer when duplicate is found
        int[] lastIndex = new int[128];
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);

            // If curr character was seen at or after 'left', jump 'left' forward
            left = Math.max(left, lastIndex[curr]);

            // Update max length of current window
            maxLen = Math.max(maxLen, right - left + 1);

            // Record next starting index after current position
            lastIndex[curr] = right + 1;
        }

        return maxLen;
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

        // Test Case 4
        String s4 = " ";
        System.out.println("Output 4: " + lengthOfLongestSubstring(s4)); // Expected: 1
    }
}