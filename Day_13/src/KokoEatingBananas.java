import java.util.Arrays;

public class KokoEatingBananas {

    // Method to find minimum eating speed
    public int minEatingSpeed(int[] piles, int h) {
    	//Get the bound of number of maximum bananas which Koko can eat
    	//In all cases it will eat atleast 1 banana and maximum of maximum number present in piles array
    	int low = 1;
    	int high = Integer.MIN_VALUE;
    	for(int i=0;i<piles.length;i++) {
    		high = Math.max(high, piles[i]);
    	}
    	int res = high;
    	//Now do binary search based on the high and low bounds
    	while(low<=high) {
    		
    		int speed = (low+high)/2;
    		long totalHours = 0;
    		//each time considering the mid calculated as speed calculate the total hours
    		for(int p:piles) {
    			totalHours += (int) Math.ceil((double)p/speed);
    		}
    		//Check if the total hours is less than or equal to the hours limit
    		//Then try for a lower option after that
    		if(totalHours<=h) {
    			res = speed;
    			high = speed - 1;
    		} else {
    			low = speed + 1;
    		}
    		
    		
    	}
    	return res;	
    }

    // Helper method to run and validate test cases
    public static void runTest(int[] piles, int h, int expected, int testCaseNumber) {
        KokoEatingBananas solution = new KokoEatingBananas();
        int result = solution.minEatingSpeed(piles, h);
        if (result == expected) {
            System.out.println("Test Case " + testCaseNumber + " PASSED ✅");
        } else {
            System.out.println("Test Case " + testCaseNumber + " FAILED ❌");
            System.out.println("Expected: " + expected + " | Got: " + result);
        }
    }

    // Main method to run all test cases
    public static void main(String[] args) {
        // Test Case 1
        runTest(new int[]{3, 6, 7, 11}, 8, 4, 1);

        // Test Case 2
        runTest(new int[]{30, 11, 23, 4, 20}, 5, 30, 2);

        // Test Case 3
        runTest(new int[]{30, 11, 23, 4, 20}, 6, 23, 3);

        // Test Case 4: Single pile
        runTest(new int[]{312884470}, 312884469, 2, 4);

        // Test Case 5: Large piles
        runTest(new int[]{1000000000}, 2, 500000000, 5);

        // Test Case 6: All piles same
        runTest(new int[]{1, 1, 1, 1}, 4, 1, 6);

        
    }
}
