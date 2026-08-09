public class Search_in_Rotated_Sorted_Array_LC0033 {
    public static int search(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;

        while(left <= right) {
            int mid = left + (right-left) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid-1;
                } else {
                    left = mid + 1;
                }
            }

            else {
                if(nums[mid] <= target && target < nums[right]) {
                    left = mid+1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println("Output 1: " + search(nums1, target1)); // Expected: 4

        // Test Case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println("Output 2: " + search(nums2, target2)); // Expected: -1

        // Test Case 3
        int[] nums3 = {1};
        int target3 = 0;
        System.out.println("Output 3: " + search(nums3, target3)); // Expected: -1
    }
}
