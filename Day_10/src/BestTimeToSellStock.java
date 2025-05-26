
public class BestTimeToSellStock {

    // TODO: Implement the maxProfit logic here
    public int maxProfit(int[] prices) {
        // Sample placeholder return
    	int leftMin = prices[0];
    	int maxProfit = 0;
    	for(int i=0;i<prices.length;i++) {
    		int tempProfit = prices[i]-leftMin;
    		maxProfit = Math.max(maxProfit, tempProfit);
    		leftMin = Math.min(leftMin, prices[i]);
    	}
    	
        return maxProfit;
    }

    // Helper method to run and evaluate test cases
    public static void runTest(int testCaseNum, int[] prices, int expected) {
    	BestTimeToSellStock sol = new BestTimeToSellStock();
        int result = sol.maxProfit(prices);

        if (result == expected) {
            System.out.println("✅ Test Case " + testCaseNum + " Passed");
        } else {
            System.out.println("❌ Test Case " + testCaseNum + " Failed - Expected: " + expected + ", Got: " + result);
        }
    }

    public static void main(String[] args) {
        // LeetCode sample test cases
        runTest(1, new int[]{7, 1, 5, 3, 6, 4}, 5);   // Buy at 1, sell at 6
        runTest(2, new int[]{7, 6, 4, 3, 1}, 0);      // No profit possible
        runTest(3, new int[]{2, 4, 1}, 2);            // Buy at 2, sell at 4
        runTest(4, new int[]{1, 2}, 1);               // Buy at 1, sell at 2
        runTest(5, new int[]{1}, 0);                  // Only one day, can't sell
        runTest(6, new int[]{3, 3, 3, 3}, 0);         // All prices same
        runTest(7, new int[]{1, 2, 3, 4, 5}, 4);      // Increasing prices
        runTest(8, new int[]{5, 4, 3, 2, 1}, 0);      // Decreasing prices
        runTest(9, new int[]{3, 2, 6, 5, 0, 3}, 4);   // Buy at 2, sell at 6
    }
}

