public class Container_With_Most_Water_LC0011 {

    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int currentArea = width * minHeight;

            maxWater = Math.max(maxWater, currentArea);

            // Move the pointer with the smaller height to search for a taller boundary
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Output 1: " + maxArea(height1)); // Expected: 49

        // Test Case 2
        int[] height2 = {1, 1};
        System.out.println("Output 2: " + maxArea(height2)); // Expected: 1

        // Test Case 3
        int[] height3 = {4, 3, 2, 1, 4};
        System.out.println("Output 3: " + maxArea(height3)); // Expected: 16
    }
}