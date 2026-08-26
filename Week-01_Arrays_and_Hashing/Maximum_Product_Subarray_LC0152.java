public class Maximum_Product_Subarray_LC0152 {

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // When a negative number is encountered, min becomes max and vice-versa
            if (num < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            // Either start a new subarray at num or continue the previous one
            currMax = Math.max(num, currMax * num);
            currMin = Math.min(num, currMin * num);

            // Update overall maximum product found so far
            maxProduct = Math.max(maxProduct, currMax);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {2, 3, -2, 4};
        System.out.println("Output 1: " + maxProduct(nums1)); // Expected: 6

        // Test Case 2
        int[] nums2 = {-2, 0, -1};
        System.out.println("Output 2: " + maxProduct(nums2)); // Expected: 0

        // Test Case 3
        int[] nums3 = {-2, 3, -4};
        System.out.println("Output 3: " + maxProduct(nums3)); // Expected: 24
    }
}