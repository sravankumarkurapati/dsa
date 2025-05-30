public class RotatedArraySearch {

    // TODO: Implement this method
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right) {
        	int mid = (left+right)/2;
        	if(nums[mid]==target) {
        		return mid;
        	}
        	if(nums[mid]>=nums[left]) {
        		if(target>nums[mid]||target<nums[left]) {
        			left = mid+1;
        		} else {
        			right = mid-1;
        		}
        	} else {
        		if(target<nums[mid]||target>nums[right]) {
        			right = mid-1;
        		} else {
        			left = mid+1;
        		}
        	}
        }
        return -1;
    }

    // Utility method to run and check test case
    public static void runTest(int testCaseNum, int[] nums, int target, int expected) {
        RotatedArraySearch solution = new RotatedArraySearch();
        int result = solution.search(nums, target);
        if (result == expected) {
            System.out.println("Test Case " + testCaseNum + ": Passed ✅");
        } else {
            System.out.println("Test Case " + testCaseNum + ": Failed ❌ (Expected " + expected + ", Got " + result + ")");
        }
    }

    // Main method with test cases
    public static void main(String[] args) {
        runTest(1, new int[]{4,5,6,7,0,1,2}, 0, 4);
        runTest(2, new int[]{4,5,6,7,0,1,2}, 3, -1);
        runTest(3, new int[]{1}, 0, -1);
        runTest(4, new int[]{1,3}, 3, 1);
        runTest(5, new int[]{1,3}, 1, 0);
        runTest(6, new int[]{5,1,3}, 5, 0);
        runTest(7, new int[]{5,1,3}, 3, 2);
        runTest(8, new int[]{3,1}, 1, 1);
        runTest(9, new int[]{6,7,0,1,2,4,5}, 6, 0);
        runTest(10, new int[]{1}, 1, 0);
    }
}
