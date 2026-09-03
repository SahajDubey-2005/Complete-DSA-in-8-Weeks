import java.util.HashSet;
import java.util.Set;

public class Contains_Duplicate_LC0217 {

    public static boolean containsDuplicate(int[] nums) {
        // Step 1: Unique elements store karne ke liye HashSet
        Set<Integer> seen = new HashSet<>();

        // Step 2: Array ke har number ko check karein
        for (int num : nums) {
            // Agar number pehle se set mein hai, toh duplicate mil gaya
            if (seen.contains(num)) {
                return true;
            }
            // Warna number ko set mein add kar lein
            seen.add(num);
        }

        // Loop poora ho gaya aur koi duplicate nahi mila
        return false;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Output 1: " + containsDuplicate(nums1)); // Expected: true

        // Test Case 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Output 2: " + containsDuplicate(nums2)); // Expected: false

        // Test Case 3
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("Output 3: " + containsDuplicate(nums3)); // Expected: true
    }
}