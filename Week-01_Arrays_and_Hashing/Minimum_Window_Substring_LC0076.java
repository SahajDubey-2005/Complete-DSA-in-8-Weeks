public class Minimum_Window_Substring_LC0076 {

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // ASCII frequency array for target string t
        int[] targetCount = new int[128];
        for (char c : t.toCharArray()) {
            targetCount[c]++;
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;
        int required = t.length();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            // If the character is needed, reduce the remaining required count
            if (targetCount[rightChar] > 0) {
                required--;
            }
            targetCount[rightChar]--;

            // When the window contains all characters of t, shrink from left
            while (required == 0) {
                int currentWindowLen = right - left + 1;
                if (currentWindowLen < minLen) {
                    minLen = currentWindowLen;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                targetCount[leftChar]++;

                // If removing leftChar makes the window invalid
                if (targetCount[leftChar] > 0) {
                    required++;
                }
                left++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(startIndex, startIndex + minLen);
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