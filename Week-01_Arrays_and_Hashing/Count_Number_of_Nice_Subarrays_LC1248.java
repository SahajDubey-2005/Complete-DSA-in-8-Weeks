public class Count_Number_of_Nice_Subarrays_LC1248 {

    public static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] prefixOddCounts = new int[n + 1];
        prefixOddCounts[0] = 1; // Base case: 0 odd numbers seen initially

        int currentOdds = 0;
        int result = 0;

        for (int num : nums) {
            // Increment odd count if number is odd
            currentOdds += (num % 2 != 0) ? 1 : 0;

            // If we have at least k odds, add valid starting points
            if (currentOdds >= k) {
                result += prefixOddCounts[currentOdds - k];
            }

            // Record occurrence of the current odd count
            prefixOddCounts[currentOdds]++;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 1, 2, 1, 1};
        int k1 = 3;
        System.out.println("Output 1: " + numberOfSubarrays(nums1, k1)); // Expected: 2

        // Test Case 2
        int[] nums2 = {2, 4, 6};
        int k2 = 1;
        System.out.println("Output 2: " + numberOfSubarrays(nums2, k2)); // Expected: 0

        // Test Case 3
        int[] nums3 = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k3 = 2;
        System.out.println("Output 3: " + numberOfSubarrays(nums3, k3)); // Expected: 16
    }
}