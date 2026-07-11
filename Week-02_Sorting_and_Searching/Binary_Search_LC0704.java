public class Binary_Search_LC0704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Binary_Search_LC0704 obj = new Binary_Search_LC0704();
        
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        
        int result = obj.search(nums, target);
        System.out.println("Element found at index: " + result); // Output: 4
    }
}