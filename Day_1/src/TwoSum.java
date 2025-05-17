
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // TODO: Implement your solution here
    	
    	Map<Integer,Integer> differenceMap = new HashMap<>();
    	
    	for(int i=0;i<nums.length;i++) {
    		
    		Integer diffIndex = differenceMap.get(nums[i]);
    		if(diffIndex != null) {
    			return new int[] {diffIndex,i};
    		}
    		differenceMap.put(target-nums[i], i);
    		
    	}
    	
        return new int[]{}; // placeholder
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        test(solution, new int[]{2, 7, 11, 15}, 9);         // Expected: [0, 1]
        test(solution, new int[]{1, 2, 3, 4, 6}, 6);        // Expected: [1, 3]
        test(solution, new int[]{-3, 4, 3, 90}, 0);         // Expected: [0, 2]
        test(solution, new int[]{3, 2, 4, 3}, 6);           // Expected: [0, 3] or [2, 3]
        test(solution, new int[]{1, 2, 3}, 7);              // Expected: No valid pair found
        test(solution, new int[]{1000000, 2999999, -1000000, 2000000}, 1999999);  // Expected: [1, 2]
    }

    private static void test(TwoSum solution, int[] nums, int target) {
        int[] result = solution.twoSum(nums, target);
        System.out.print("Input: " + Arrays.toString(nums) + ", Target: " + target + " => ");
        if (result.length == 2) {
            System.out.println("Indices: " + Arrays.toString(result));
        } else {
            System.out.println("No valid pair found.");
        }
    }
}

