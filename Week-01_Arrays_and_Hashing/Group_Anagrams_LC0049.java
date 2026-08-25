import java.util.*;

public class Group_Anagrams_LC0049 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Count character frequency
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Build unique key from frequency count (e.g., "#1#0#2...")
            StringBuilder keyBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                keyBuilder.append('#');
                keyBuilder.append(count[i]);
            }
            String key = keyBuilder.toString();

            // Insert into map
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        // Test Case 1
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Output 1: " + groupAnagrams(strs1));
        // Expected: [[eat, tea, ate], [bat], [tan, nat]]

        // Test Case 2
        String[] strs2 = {""};
        System.out.println("Output 2: " + groupAnagrams(strs2));
        // Expected: [[""]]

        // Test Case 3
        String[] strs3 = {"a"};
        System.out.println("Output 3: " + groupAnagrams(strs3));
        // Expected: [["a"]]
    }
}