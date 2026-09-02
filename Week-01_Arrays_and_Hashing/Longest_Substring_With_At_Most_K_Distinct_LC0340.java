public class Longest_Substring_With_At_Most_K_Distinct_LC0340 {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        int[] charFreq = new int[256];
        int left = 0;
        int distinctCount = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            // New distinct character entered the window
            if (charFreq[rightChar] == 0) {
                distinctCount++;
            }
            charFreq[rightChar]++;

            // Shrink window if distinct characters exceed k
            while (distinctCount > k) {
                char leftChar = s.charAt(left);
                charFreq[leftChar]--;
                if (charFreq[leftChar] == 0) {
                    distinctCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "eceba";
        int k1 = 2;
        System.out.println("Output 1: " + lengthOfLongestSubstringKDistinct(s1, k1)); // Expected: 3

        // Test Case 2
        String s2 = "aa";
        int k2 = 1;
        System.out.println("Output 2: " + lengthOfLongestSubstringKDistinct(s2, k2)); // Expected: 2

        // Test Case 3
        String s3 = "a";
        int k3 = 0;
        System.out.println("Output 3: " + lengthOfLongestSubstringKDistinct(s3, k3)); // Expected: 0
    }
}