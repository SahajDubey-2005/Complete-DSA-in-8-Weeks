import java.util.HashMap;
import java.util.Map;

public class Continuous_Subarray_Sum_LC0523 {

    public static boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        // Map stores: <Remainder, FirstOccurrenceIndex>
        Map<Integer, Integer> remainderIndexMap = new HashMap<>();
        remainderIndexMap.put(0, -1); // Base case for prefix sum starting from index 0

        int runningSum = 0;

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];

            int remainder = runningSum % k;

            if (remainderIndexMap.containsKey(remainder)) {
                // Ensure subarray length is at least 2
                if (i - remainderIndexMap.get(remainder) >= 2) {
                    return true;
                }
            } else {
                // Only store first occurrence to maximize the window length
                remainderIndexMap.put(remainder, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {23, 2, 4, 6, 7};
        int k1 = 6;
        System.out.println("Output 1: " + checkSubarraySum(nums1, k1)); // Expected: true

        // Test Case 2
        int[] nums2 = {23, 2, 6, 4, 7};
        int k2 = 6;
        System.out.println("Output 2: " + checkSubarraySum(nums2, k2)); // Expected: true

        // Test Case 3
        int[] nums3 = {23, 2, 6, 4, 7};
        int k3 = 13;
        System.out.println("Output 3: " + checkSubarraySum(nums3, k3)); // Expected: false
    }
}