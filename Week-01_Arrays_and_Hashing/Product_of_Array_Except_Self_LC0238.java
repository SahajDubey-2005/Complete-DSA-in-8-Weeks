import java.util.Arrays;

public class Product_of_Array_Except_Self_LC0238 {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Prefix products (Left side elements product)
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Step 2: Suffix products (Right side elements product) on the fly
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffix;
            suffix *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Output 1: " + Arrays.toString(productExceptSelf(nums1))); // Expected: [24, 12, 8, 6]

        // Test Case 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println("Output 2: " + Arrays.toString(productExceptSelf(nums2))); // Expected: [0, 0, 9, 0, 0]
    }
}