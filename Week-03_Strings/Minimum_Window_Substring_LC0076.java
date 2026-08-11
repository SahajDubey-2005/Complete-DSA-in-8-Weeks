public class Minimum_Window_Substring_LC0076 {

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] tCount = new int[128];
        int requiredUniqueCount = 0;

        // Step 1: Count target frequencies
        for (char c : t.toCharArray()) {
            if (tCount[c] == 0) {
                requiredUniqueCount++;
            }
            tCount[c]++;
        }

        int[] windowCount = new int[128];
        int formed = 0;

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        // Step 2: Expand window with 'right' pointer
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            windowCount[rightChar]++;

            if (tCount[rightChar] > 0 && windowCount[rightChar] == tCount[rightChar]) {
                formed++;
            }

            // Step 3: Shrink window with 'left' pointer as long as it's valid
            while (formed == requiredUniqueCount) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                windowCount[leftChar]--;

                if (tCount[leftChar] > 0 && windowCount[leftChar] < tCount[leftChar]) {
                    formed--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "ADOBECODEBANC", t1 = "ABC";
        System.out.println("Output 1: " + minWindow(s1, t1)); // Expected: "BANC"

        // Test Case 2
        String s2 = "a", t2 = "a";
        System.out.println("Output 2: " + minWindow(s2, t2)); // Expected: "a"

        // Test Case 3
        String s3 = "a", t3 = "aa";
        System.out.println("Output 3: " + minWindow(s3, t3)); // Expected: ""
    }
}