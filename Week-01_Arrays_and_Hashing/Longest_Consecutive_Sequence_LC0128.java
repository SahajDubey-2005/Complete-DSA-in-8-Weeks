import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence_LC0128 {

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Add all elements to a HashSet for O(1) lookups and duplicate removal
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        for (int num : numSet) {
            // Only start counting if 'num' is the beginning of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Expand sequence forward
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                maxLength = Math.max(maxLength, currentStreak);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Output 1: " + longestConsecutive(nums1)); // Expected: 4

        // Test Case 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Output 2: " + longestConsecutive(nums2)); // Expected: 9

        // Test Case 3
        int[] nums3 = {1, 0, 1, 2};
        System.out.println("Output 3: " + longestConsecutive(nums3)); // Expected: 3
    }
}
