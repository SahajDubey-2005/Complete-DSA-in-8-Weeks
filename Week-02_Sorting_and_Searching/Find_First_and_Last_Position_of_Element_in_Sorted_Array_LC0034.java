import java.util.Arrays;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array_LC0034 {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        result[0] = findBound(nums, target, true);  // Find first position
        
        // If target is not found at all, no need to search for the last position
        if (result[0] != -1) {
            result[1] = findBound(nums, target, false); // Find last position
        }

        return result;
    }

    private static int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0;
        int right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                bound = mid; // Potential answer found
                if (isFirst) {
                    right = mid - 1; // Keep searching left for first position
                } else {
                    left = mid + 1;  // Keep searching right for last position
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return bound;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        System.out.println("Output 1: " + Arrays.toString(searchRange(nums1, target1))); 
        // Expected: [3, 4]

        // Test Case 2
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        System.out.println("Output 2: " + Arrays.toString(searchRange(nums2, target2))); 
        // Expected: [-1, -1]

        // Test Case 3
        int[] nums3 = {};
        int target3 = 0;
        System.out.println("Output 3: " + Arrays.toString(searchRange(nums3, target3))); 
        // Expected: [-1, -1]
    }
}