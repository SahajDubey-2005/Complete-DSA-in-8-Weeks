public class Valid_Anagram_LC0242 {

    public static boolean isAnagram(String s, String t) {
        // Step 1: Base condition check
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Fixed frequency array for 26 lowercase English letters
        int[] charCounts = new int[26];

        // Step 3: Count frequencies in a single loop
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++; // Add count for string s
            charCounts[t.charAt(i) - 'a']--; // Subtract count for string t
        }

        // Step 4: Check if all counts netted out to zero
        for (int count : charCounts) {
            if (count != 0) {
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
    }
}