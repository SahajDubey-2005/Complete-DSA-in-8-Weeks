public class Best_Time_to_Buy_and_Sell_Stock_0121 {

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Update the lowest price seen so far
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // Update the maximum profit
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Output 1: " + maxProfit(prices1)); // Expected: 5

        // Test Case 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Output 2: " + maxProfit(prices2)); // Expected: 0
    }
}
