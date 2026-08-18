import java.util.HashMap;
import java.util.Map;

public class Contiguous_Array_LC0525 {

    public static int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Map stores: <PrefixSum, EarliestIndexSeen>
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Base case: a prefix sum of 0 at index -1

        int maxLength = 0;
        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            // Treat 0 as -1 and 1 as +1
            prefixSum += (nums[i] == 0) ? -1 : 1;

            if (map.containsKey(prefixSum)) {
                // Same sum seen earlier -> compute length of valid subarray
                maxLength = Math.max(maxLength, i - map.get(prefixSum));
            } else {
                // Store only the earliest index to maximize potential length later
                map.put(prefixSum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {0, 1};
        System.out.println("Output 1: " + findMaxLength(nums1)); // Expected: 2

        // Test Case 2
        int[] nums2 = {0, 1, 0};
        System.out.println("Output 2: " + findMaxLength(nums2)); // Expected: 2

        // Test Case 3
        int[] nums3 = {0, 1, 1, 1, 1, 1, 0, 0, 0};
        System.out.println("Output 3: " + findMaxLength(nums3)); // Expected: 6
    }
}