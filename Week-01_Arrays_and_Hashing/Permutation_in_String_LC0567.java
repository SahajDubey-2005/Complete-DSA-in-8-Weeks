import java.util.Arrays;

public class Permutation_in_String_LC0567 {

    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        int len1 = s1.length();
        int len2 = s2.length();

        // Initialize frequency arrays for s1 and the first window in s2
        for (int i = 0; i < len1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Count, s2Count)) {
            return true;
        }

        // Slide the fixed window of size len1 across s2
        for (int i = len1; i < len2; i++) {
            // Add incoming character
            s2Count[s2.charAt(i) - 'a']++;

            // Remove outgoing character
            s2Count[s2.charAt(i - len1) - 'a']--;

            // Check if current window matches s1's frequency profile
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println("Output 1: " + checkInclusion(s1, s2)); // Expected: true

        // Test Case 2
        String s3 = "ab", s4 = "eidboaoo";
        System.out.println("Output 2: " + checkInclusion(s3, s4)); // Expected: false
    }
}