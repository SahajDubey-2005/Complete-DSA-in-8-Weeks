public class First_Missing_Positive_LC0041 {

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int n = nums.length;

        // Step 1: Place each number in its target index (value x goes to index x - 1)
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // Step 2: Find the first index where nums[i] != i + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: If all 1 to n are present
        return n + 1;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 0};
        System.out.println("Output 1: " + firstMissingPositive(nums1)); // Expected: 3

        // Test Case 2
        int[] nums2 = {3, 4, -1, 1};
        System.out.println("Output 2: " + firstMissingPositive(nums2)); // Expected: 2

        // Test Case 3
        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println("Output 3: " + firstMissingPositive(nums3)); // Expected: 1
    }
}