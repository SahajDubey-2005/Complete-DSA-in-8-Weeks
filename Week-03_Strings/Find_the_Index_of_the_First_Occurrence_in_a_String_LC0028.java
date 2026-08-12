public class Find_the_Index_of_the_First_Occurrence_in_a_String_LC0028 {

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }

        // Step 1: Precompute LPS (Longest Prefix Suffix) array
        int[] lps = buildLPS(needle);

        // Step 2: KMP Search
        int i = 0; // Pointer for haystack
        int j = 0; // Pointer for needle

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }

            if (j == needle.length()) {
                return i - j; // Match found
            } else if (i < haystack.length() && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1]; // Skip redundant checks using LPS
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    private static int[] buildLPS(String needle) {
        int[] lps = new int[needle.length()];
        int len = 0;
        int i = 1;

        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        // Test Case 1
        String haystack1 = "sadbutsad", needle1 = "sad";
        System.out.println("Output 1: " + strStr(haystack1, needle1)); // Expected: 0

        // Test Case 2
        String haystack2 = "leetcode", needle2 = "leeto";
        System.out.println("Output 2: " + strStr(haystack2, needle2)); // Expected: -1
    }
}