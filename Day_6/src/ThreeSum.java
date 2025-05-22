import java.util.*;

public class ThreeSum {

    // Method to implement: threeSum
    public List<List<Integer>> threeSum(int[] nums) {
    	Arrays.sort(nums);
    	Set<List<Integer>> resultSet = new HashSet<>();
    	for(int i=0;i<nums.length-2;i++) {
    		
    		int l = i+1;
    		int r = nums.length-1;
    		while(l<r) {
    			int sum = nums[i] + nums[l]+nums[r];
    			if(sum == 0) {
    				
    				resultSet.add(Arrays.asList(nums[i],nums[l],nums[r]));
    				l++;
    				r--;
    				
    			} else if (sum>0) {
    				r--;
    			} else {
    				l++;
    			}
    			
    			
    		}
    		
    		
    	}
    	return new ArrayList<>(resultSet);
    	
    }

    // Helper method to format and print result lists
    private static void printResult(List<List<Integer>> result) {
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
        System.out.println("Total Triplets: " + result.size());
        System.out.println("-----");
    }

    // Test cases
    public static void runTests() {
        ThreeSum solution = new ThreeSum();

        // Test Case 1
        int[] test1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Test Case 1:");
        printResult(solution.threeSum(test1)); // Expected: [[-1, -1, 2], [-1, 0, 1]]

        // Test Case 2
        int[] test2 = {0, 1, 1};
        System.out.println("Test Case 2:");
        printResult(solution.threeSum(test2)); // Expected: []

        // Test Case 3
        int[] test3 = {0, 0, 0};
        System.out.println("Test Case 3:");
        printResult(solution.threeSum(test3)); // Expected: [[0, 0, 0]]

        // Test Case 4 - Negative and positive
        int[] test4 = {-2, 0, 0, 2, 2};
        System.out.println("Test Case 4:");
        printResult(solution.threeSum(test4)); // Expected: [[-2, 0, 2]]

        // Test Case 5 - Large input with no result
        int[] test5 = {1, 2, -2, -1};
        System.out.println("Test Case 5:");
        printResult(solution.threeSum(test5)); // Expected: []

        // Test Case 6 - Multiple duplicates
        int[] test6 = {-2, 0, 0, 2, 2, -2};
        System.out.println("Test Case 6:");
        printResult(solution.threeSum(test6)); // Expected: [[-2, 0, 2]]
    }

    // Main method
    public static void main(String[] args) {
        runTests();
    }
}
