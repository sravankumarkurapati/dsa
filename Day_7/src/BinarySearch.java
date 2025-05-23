public class BinarySearch {
    public int search(int[] nums, int target) {
    	int i = 0;
    	int j = nums.length -1;
    	int mid = 0;
    	while(i<=j) {
    		mid = (i+j)/2;
    		if(nums[mid]==target) {
    			return mid;
    		} else if(nums[mid]>target) {
    			j = mid - 1;
    		} else {
    			i = mid + 1;
    		}
    		
    	}
    	return -1;
    }

    // Main method for testing
    public static void main(String[] args) {
    	BinarySearch sol = new BinarySearch();

        // ✅ Test Case 1: Target is present in the middle
        int[] nums1 = {-10, -3, 0, 5, 9, 12};
        int target1 = 9;
        System.out.println("Test Case 1 Output: " + sol.search(nums1, target1)); // Expected: 4

        // ✅ Test Case 2: Target is the first element
        int[] nums2 = {-10, -3, 0, 5, 9, 12};
        int target2 = -10;
        System.out.println("Test Case 2 Output: " + sol.search(nums2, target2)); // Expected: 0

        // ✅ Test Case 3: Target is the last element
        int[] nums3 = {-10, -3, 0, 5, 9, 12};
        int target3 = 12;
        System.out.println("Test Case 3 Output: " + sol.search(nums3, target3)); // Expected: 5

        // ✅ Test Case 4: Target is not in the array
        int[] nums4 = {-10, -3, 0, 5, 9, 12};
        int target4 = 8;
        System.out.println("Test Case 4 Output: " + sol.search(nums4, target4)); // Expected: -1

        // ✅ Test Case 5: Array has one element, target found
        int[] nums5 = {3};
        int target5 = 3;
        System.out.println("Test Case 5 Output: " + sol.search(nums5, target5)); // Expected: 0

        // ✅ Test Case 6: Array has one element, target not found
        int[] nums6 = {3};
        int target6 = 1;
        System.out.println("Test Case 6 Output: " + sol.search(nums6, target6)); // Expected: -1
    }
}
