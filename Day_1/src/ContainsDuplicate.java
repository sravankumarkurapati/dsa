import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
       Set<Integer> seenSet = new HashSet<>();
       for(int i=0;i<nums.length;i++) {
    	   if(seenSet.contains(nums[i])) {
    		   return true;
    	   }
    	   seenSet.add(nums[i]);
       }
       return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();

        test(solution, new int[]{1, 2, 3, 4});               // Expected: false
        test(solution, new int[]{1, 2, 3, 1});               // Expected: true
        test(solution, new int[]{-1, -2, -3, -1});           // Expected: true
        test(solution, new int[]{0, 1, 2, 3, 4, 5});         // Expected: false
        test(solution, new int[]{100, 200, 100, 300});       // Expected: true
        test(solution, new int[]{});                         // Expected: false
    }

    private static void test(ContainsDuplicate solution, int[] nums) {
        boolean result = solution.containsDuplicate(nums);
        System.out.println("Input: " + Arrays.toString(nums) + " => Contains Duplicate? " + result);
    }
}
