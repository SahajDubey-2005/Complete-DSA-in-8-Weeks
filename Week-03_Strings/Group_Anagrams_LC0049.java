import java.util.*;

public class Group_Anagrams_LC0049 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            // Generate frequency key string (e.g., "#1#0#0...#1")
            StringBuilder sb = new StringBuilder();
            for (int val : count) {
                sb.append('#').append(val);
            }
            String key = sb.toString();

            // Group anagrams under the frequency key
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        // Test Case 1
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Output 1: " + groupAnagrams(strs1));

        // Test Case 2
        String[] strs2 = {""};
        System.out.println("Output 2: " + groupAnagrams(strs2));

        // Test Case 3
        String[] strs3 = {"a"};
        System.out.println("Output 3: " + groupAnagrams(strs3));
    }
}