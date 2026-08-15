import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements_LC0347 {
    public static int[] topKFrequent(int[] nums, int k){

        // Step.1 : frequency count using HashMap
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1 );
        }

        // Step 2: min-heap of size k based on element frequencies
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> countMap.get(a) - countMap.get(b));

        for(int num : countMap.keySet()) {
            heap.add(num);
            if(heap.size() > k) {
                heap.poll(); // Discard element with the lowest frequency
            }
        }

        // Step 3: Extract top k element from the heap into result array
        int[] result = new int[k];
        for(int i=0; i<k; i++){
            result[i] = heap.poll();
        }
        return result;

    }

    public static void main(String[] args) {
        // Test case 
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println("Output 1: "+ Arrays.toString(topKFrequent(nums1, k1)));
        // Expected: [2, 1] or [1, 2]

        // Test Case 2
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println("Output 2: " + Arrays.toString(topKFrequent(nums2, k2))); 
        // Expected: [1]

        // Test Case 3
        int[] nums3 = {1, 2, 1, 2, 1, 2, 3, 1, 3, 2};
        int k3 = 2;
        System.out.println("Output 3: " + Arrays.toString(topKFrequent(nums3, k3))); 
        // Expected: [2, 1] or [1, 2]
    }
}
