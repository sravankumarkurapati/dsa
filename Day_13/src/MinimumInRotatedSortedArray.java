

public class MinimumInRotatedSortedArray {

    // Method to be implemented
	
	public int findMin(int[] nums) {

	    // Initialize two pointers: left and right to the bounds of the array
	    int left = 0;
	    int right = nums.length - 1;

	    // Perform binary search
	    while (left < right) {

	        // Calculate the middle index
	        int mid = (left + right) / 2;

	        // If the middle element is greater than the rightmost element,
	        // it means the smallest value is to the right of mid (rotation point is to the right)
	        if (nums[mid] > nums[right]) {
	            // So, move left to mid + 1
	            left = mid + 1;
	        } else {
	            // Else, the minimum must be at mid or to the left of mid
	            right = mid;
	        }
	    }

	    // When left == right, we've found the minimum element
	    return nums[left];
	}


    // Helper to run and validate test cases
    public static void runTest(int[] nums, int expected, int testCaseNumber) {
    	MinimumInRotatedSortedArray solution = new MinimumInRotatedSortedArray();
        int result = solution.findMin(nums);
        if (result == expected) {
            System.out.println("Test Case " + testCaseNumber + " PASSED ✅");
        } else {
            System.out.println("Test Case " + testCaseNumber + " FAILED ❌");
            System.out.println("Expected: " + expected + ", Got: " + result);
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Rotated
        runTest(new int[]{3, 4, 5, 1, 2}, 1, 1);

        // Test Case 2: Rotated
        runTest(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 2);

        // Test Case 3: Not Rotated
        runTest(new int[]{11, 13, 15, 17}, 11, 3);

        // Test Case 4: Single element
        runTest(new int[]{1}, 1, 4);

        // Test Case 5: Two elements, rotated
        runTest(new int[]{2, 1}, 1, 5);

        // Test Case 6: Two elements, not rotated
        runTest(new int[]{1, 2}, 1, 6);

        // Test Case 7: Large rotation
        runTest(new int[]{5, 6, 7, 0, 1, 2, 3, 4}, 0, 7);

        // Test Case 8: Full rotation (last element is smallest)
        runTest(new int[]{2, 3, 4, 5, 6, 7, 1}, 1, 8);
    }
}
