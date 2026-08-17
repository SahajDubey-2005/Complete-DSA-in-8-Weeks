public class Subarray_Product_Less_Than_K_LC0713 {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        // Base edge case
        if (k <= 1) {
            return 0;
        }

        int count = 0;
        int product = 1;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            // Shrink window if product is >= k
            while (product >= k) {
                product /= nums[left];
                left++;
            }

            // All subarrays ending at 'right' within window [left, right] are valid
            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {10, 5, 2, 6};
        int k1 = 100;
        System.out.println("Output 1: " + numSubarrayProductLessThanK(nums1, k1)); 
        // Expected: 8

        // Test Case 2
        int[] nums2 = {1, 2, 3};
        int k2 = 0;
        System.out.println("Output 2: " + numSubarrayProductLessThanK(nums2, k2)); 
        // Expected: 0

        // Test Case 3
        int[] nums3 = {1, 1, 1};
        int k3 = 2;
        System.out.println("Output 3: " + numSubarrayProductLessThanK(nums3, k3)); 
        // Expected: 6
    }
}