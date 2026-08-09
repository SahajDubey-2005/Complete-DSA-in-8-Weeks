import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array_LC0215 {

    public static int findKthLargest(int[] nums, int k) {
        // Min-Heap to maintain top 'k' largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);

            // Maintain heap size to at most k elements
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove smallest element in current heap
            }
        }

        // The root element is the kth largest element
        return minHeap.peek();
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("Output 1: " + findKthLargest(nums1, k1)); // Expected: 5

        // Test Case 2
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println("Output 2: " + findKthLargest(nums2, k2)); // Expected: 4
    }
}