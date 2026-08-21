import java.util.ArrayList;
import java.util.List;

public class Majority_Element_II_LC0229 {

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        // Step 1: Find potential candidates
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        int threshold = nums.length / 3;
        if (count1 > threshold) {
            result.add(candidate1);
        }
        if (count2 > threshold) {
            result.add(candidate2);
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {3, 2, 3};
        System.out.println("Output 1: " + majorityElement(nums1)); // Expected: [3]

        // Test Case 2
        int[] nums2 = {1};
        System.out.println("Output 2: " + majorityElement(nums2)); // Expected: [1]

        // Test Case 3
        int[] nums3 = {1, 2};
        System.out.println("Output 3: " + majorityElement(nums3)); // Expected: [1, 2]
    }
}