public class Valid_Anagram_LC0242 {

    public static boolean isAnagram(String s, String t) {
        // Step 1: Base check on length
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Frequency array for 26 lowercase English letters
        int[] count = new int[26];

        // Step 3: Count frequencies in both strings
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // Step 4: Verify all counts returned to 0
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "anagram", t1 = "nagaram";
        System.out.println("Output 1: " + isAnagram(s1, t1)); // Expected: true

        // Test Case 2
        String s2 = "rat", t2 = "car";
        System.out.println("Output 2: " + isAnagram(s2, t2)); // Expected: false

        // Test Case 3
        String s3 = "a", t3 = "ab";
        System.out.println("Output 3: " + isAnagram(s3, t3)); // Expected: false
    }
}