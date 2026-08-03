public class Maximum_Subarray_LC0053 {
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;

            // Update the global maximum sum if the current subarray sum is higher
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            // Reset current sum to 0 if it drops below zero
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Output 1: " + maxSubArray(nums1)); // Expected: 6 ([4, -1, 2, 1])

        // Test Case 2
        int[] nums2 = {1};
        System.out.println("Output 2: " + maxSubArray(nums2)); // Expected: 1

        // Test Case 3
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Output 3: " + maxSubArray(nums3)); // Expected: 23
    }
}
