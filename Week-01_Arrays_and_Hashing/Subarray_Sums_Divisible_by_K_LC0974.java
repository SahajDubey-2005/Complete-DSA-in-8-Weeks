public class Subarray_Sums_Divisible_by_K_LC0974 {

    public static int subarraysDivByK(int[] nums, int k) {
        // Remainder frequency array of size k (remainders 0 to k-1)
        int[] remainderCount = new int[k];
        remainderCount[0] = 1; // Base case for prefix sums directly divisible by k

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            // Compute normalized remainder (handles negative prefix sums)
            int remainder = (prefixSum % k + k) % k;

            // If this remainder has been seen before, add its frequency
            count += remainderCount[remainder];

            // Increment frequency of current remainder
            remainderCount[remainder]++;
        }

        return count;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {4, 5, 0, -2, -3, 1};
        int k1 = 5;
        System.out.println("Output 1: " + subarraysDivByK(nums1, k1)); // Expected: 7

        // Test Case 2
        int[] nums2 = {5};
        int k2 = 9;
        System.out.println("Output 2: " + subarraysDivByK(nums2, k2)); // Expected: 0

        // Test Case 3
        int[] nums3 = {-1, 2, 9};
        int k3 = 2;
        System.out.println("Output 3: " + subarraysDivByK(nums3, k3)); // Expected: 2
    }
}