import java.util.Arrays;

public class SquareSortedArray {
    public int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++) {
        	nums[i] = nums[i]*nums[i];
        }
        int[] result = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int l = result.length - 1;
        while(i<=j) {
        	if(nums[i]<=nums[j]) {
        		result[l] = nums[j];
        		l--;
        		j--;
        	} else {
        		result[l] = nums[i];
        		l--;
        		i++;
        	}
        }
        return result;
    }

    // Utility method to print arrays
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
    	SquareSortedArray sol = new SquareSortedArray();

        // ✅ Test Case 1: Mix of negative and positive numbers
        int[] nums1 = {-4, -1, 0, 3, 10};
        System.out.print("Test Case 1 Output: ");
        printArray(sol.sortedSquares(nums1)); // Expected: [0, 1, 9, 16, 100]

        // ✅ Test Case 2: All non-negative numbers
        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.print("Test Case 2 Output: ");
        printArray(sol.sortedSquares(nums2)); // Expected: [1, 4, 9, 16, 25]

        // ✅ Test Case 3: All negative numbers
        int[] nums3 = {-7, -5, -3, -1};
        System.out.print("Test Case 3 Output: ");
        printArray(sol.sortedSquares(nums3)); // Expected: [1, 9, 25, 49]

        // ✅ Test Case 4: Single element (zero)
        int[] nums4 = {0};
        System.out.print("Test Case 4 Output: ");
        printArray(sol.sortedSquares(nums4)); // Expected: [0]

        // ✅ Test Case 5: Single negative number
        int[] nums5 = {-2};
        System.out.print("Test Case 5 Output: ");
        printArray(sol.sortedSquares(nums5)); // Expected: [4]

        // ✅ Test Case 6: Single positive number
        int[] nums6 = {3};
        System.out.print("Test Case 6 Output: ");
        printArray(sol.sortedSquares(nums6)); // Expected: [9]
    }
}
