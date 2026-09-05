public class Majority_Element_LC0169 {

    public static int majorityElement(int[] nums) {
        int candidate = 0;
        int votes = 0;

        for (int num : nums) {
            // When balance is zero, assign a fresh candidate
            if (votes == 0) {
                candidate = num;
            }

            // Same element reinforces candidate, different cancels a vote
            if (num == candidate) {
                votes++;
            } else {
                votes--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {3, 2, 3};
        System.out.println("Output 1: " + majorityElement(nums1)); // Expected: 3

        // Test Case 2
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Output 2: " + majorityElement(nums2)); // Expected: 2

        // Test Case 3
        int[] nums3 = {1};
        System.out.println("Output 3: " + majorityElement(nums3)); // Expected: 1
    }
}