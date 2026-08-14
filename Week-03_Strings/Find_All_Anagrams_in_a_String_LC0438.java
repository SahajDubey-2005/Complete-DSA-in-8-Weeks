import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find_All_Anagrams_in_a_String_LC0438 {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        // Base Condition
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        int pLen = p.length();
        int sLen = s.length();

        // Step 1: Count frequency of pattern p and the first window in s
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // Check if the initial window at index 0 is an anagram
        if (Arrays.equals(sCount, pCount)) {
            result.add(0);
        }

        // Step 2: Slide the window of size pLen across s
        for (int i = pLen; i < sLen; i++) {
            // Add the new incoming character
            sCount[s.charAt(i) - 'a']++;

            // Remove the oldest outgoing character
            sCount[s.charAt(i - pLen) - 'a']--;

            // Check if current window matches pCount
            if (Arrays.equals(sCount, pCount)) {
                result.add(i - pLen + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "cbaebabacd", p1 = "abc";
        System.out.println("Output 1: " + findAnagrams(s1, p1)); // Expected: [0, 6]

        // Test Case 2
        String s2 = "abab", p2 = "ab";
        System.out.println("Output 2: " + findAnagrams(s2, p2)); // Expected: [0, 1, 2]
    }
}