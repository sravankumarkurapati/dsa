import java.util.Arrays;

public class TwoSumSorted {

    // Method to implement: twoSum
    public int[] twoSum(int[] numbers, int target) {
        
    	int left = 0;
    	int right = numbers.length-1;
    	while(left<right) {
    		
    		int sum = numbers[left]+numbers[right];
    		if(sum == target) {
    			return new int[] {left+1,right+1};
    		} else if (sum>target) {
    			right--;
    		} else {
    			left++;
    		}
    		
    	}
    	return new int[] {};
    	
    }

    // Helper method to run test cases
    public static void runTests() {
        TwoSumSorted solution = new TwoSumSorted();

        // Test Case 1
        int[] result1 = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("Test Case 1: " + Arrays.toString(result1)); // Expected: [1, 2]

        // Test Case 2
        int[] result2 = solution.twoSum(new int[]{2, 3, 4}, 6);
        System.out.println("Test Case 2: " + Arrays.toString(result2)); // Expected: [1, 3]

        // Test Case 3
        int[] result3 = solution.twoSum(new int[]{-1, 0}, -1);
        System.out.println("Test Case 3: " + Arrays.toString(result3)); // Expected: [1, 2]

        // Test Case 4 - Large input
        int[] input4 = new int[1000];
        for (int i = 0; i < 1000; i++) {
            input4[i] = i + 1;
        }
        int[] result4 = solution.twoSum(input4, 1999);
        System.out.println("Test Case 4: " + Arrays.toString(result4)); // Expected: [999, 1000]

        // Test Case 5 - Duplicates
        int[] result5 = solution.twoSum(new int[]{1, 1, 3, 4}, 2);
        System.out.println("Test Case 5: " + Arrays.toString(result5)); // Expected: [1, 2]

        // Test Case 6 - Edge
        int[] result6 = solution.twoSum(new int[]{1, 2}, 3);
        System.out.println("Test Case 6: " + Arrays.toString(result6)); // Expected: [1, 2]
    }

    // Main method
    public static void main(String[] args) {
        runTests();
    }
}
