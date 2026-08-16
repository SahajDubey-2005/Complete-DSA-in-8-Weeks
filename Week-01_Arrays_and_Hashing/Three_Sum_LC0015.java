import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum_LC0015 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        // Step 1: Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // If the current smallest number is > 0, sum can never be 0
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            // Step 2: Two pointer search for remaining two elements
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Need a larger value
                } else {
                    right--; // Need a smaller value
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Output 1: " + threeSum(nums1)); 
        // Expected: [[-1, -1, 2], [-1, 0, 1]]

        // Test Case 2
        int[] nums2 = {0, 1, 1};
        System.out.println("Output 2: " + threeSum(nums2)); 
        // Expected: []

        // Test Case 3
        int[] nums3 = {0, 0, 0};
        System.out.println("Output 3: " + threeSum(nums3)); 
        // Expected: [[0, 0, 0]]
    }
}