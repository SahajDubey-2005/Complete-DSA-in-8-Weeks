public class Single_Number_LC0136 {

    public static int singleNumber(int[] nums) {
        int result = 0;

        // XOR each number; pairs cancel out to 0
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {2, 2, 1};
        System.out.println("Output 1: " + singleNumber(nums1)); // Expected: 1

        // Test Case 2
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("Output 2: " + singleNumber(nums2)); // Expected: 4

        // Test Case 3
        int[] nums3 = {1};
        System.out.println("Output 3: " + singleNumber(nums3)); // Expected: 1
    }
}