import java.util.HashMap;

public class Subarray_Sum_Equals_K_LC0560 {

    public static int subarraySum(int[] nums, int k) {
        // Map stores <PrefixSum, Frequency>
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

        // Base Case: A prefix sum of 0 has occurred once 
        // (handles subarrays starting from index 0 whose sum equals k)
        prefixSumMap.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            // Check if (currentSum - k) exists in map
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }

            // Update frequency of current prefix sum
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Output 1: " + subarraySum(nums1, k1)); // Expected: 2

        // Test Case 2
        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("Output 2: " + subarraySum(nums2, k2)); // Expected: 2
    }
}