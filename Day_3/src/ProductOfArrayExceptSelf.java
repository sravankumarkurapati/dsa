import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    /**
     * Returns an array such that each element at index i is the product of all elements in the array except nums[i].
     *
     * @param nums The input array
     * @return The resulting array
     */
    public int[] productExceptSelf(int[] nums) {
        int[] leftproduct = new int[nums.length];
        int[] rightproduct = new int[nums.length];
        leftproduct[0]=1;
        rightproduct[nums.length-1]=1;
        for(int i=1;i<nums.length;i++) {
        	leftproduct[i] = leftproduct[i-1]*nums[i-1];
        }
        for(int i=nums.length-2;i>-1;i--) {
        	rightproduct[i] = rightproduct[i+1]*nums[i+1];
        }
        
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
        	res[i] = leftproduct[i]*rightproduct[i];
        }
        return res;
    }

    // === Test cases ===
    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();

        System.out.println("Test Case 1");
        int[] result1 = solution.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println("Expected: [24,12,8,6] → Got: " + Arrays.toString(result1));

        System.out.println("\nTest Case 2");
        int[] result2 = solution.productExceptSelf(new int[]{2, 3, 4, 5});
        System.out.println("Expected: [60,40,30,24] → Got: " + Arrays.toString(result2));

        System.out.println("\nTest Case 3");
        int[] result3 = solution.productExceptSelf(new int[]{1, 1, 1, 1});
        System.out.println("Expected: [1,1,1,1] → Got: " + Arrays.toString(result3));

        System.out.println("\nTest Case 4");
        int[] result4 = solution.productExceptSelf(new int[]{0, 1, 2, 3});
        System.out.println("Expected: [6,0,0,0] → Got: " + Arrays.toString(result4));

        System.out.println("\nTest Case 5");
        int[] result5 = solution.productExceptSelf(new int[]{0, 0, 2, 3});
        System.out.println("Expected: [0,0,0,0] → Got: " + Arrays.toString(result5));
    }
}
