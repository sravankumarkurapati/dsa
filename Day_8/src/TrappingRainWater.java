public class TrappingRainWater {

    // Method to implement
    public int trap(int[] height) {
        
    	int left = 0;
    	int right = height.length - 1;
    	int leftMax = 0;
    	int rightMax = 0;
    	int trappedWater = 0;
    	while(left<right) {
    		
    		if(height[left]<height[right]) {
    			leftMax = Math.max(leftMax, height[left]);
    			trappedWater = trappedWater + (leftMax-height[left]);
    			left++;
    		} else {
    			rightMax = Math.max(rightMax, height[right]);
    			trappedWater = trappedWater + (rightMax-height[right]);
    			right--;
    		}
    	
    		
    	}
    			
    	return trappedWater;
    	
    }

    // Main method to run all test cases
    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();

        // Leetcode example case
        System.out.println("Test 1: " + (solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}) == 6));

        // Flat elevation
        System.out.println("Test 2: " + (solution.trap(new int[]{3,3,3,3}) == 0));

        // All ascending
        System.out.println("Test 3: " + (solution.trap(new int[]{1,2,3,4,5}) == 0));

        // All descending
        System.out.println("Test 4: " + (solution.trap(new int[]{5,4,3,2,1}) == 0));

        // Zig-zag elevation
        System.out.println("Test 5: " + (solution.trap(new int[]{4,2,0,3,2,5}) == 9));

        // Only two bars
        System.out.println("Test 6: " + (solution.trap(new int[]{2,1}) == 0));

        // Empty array
        System.out.println("Test 7: " + (solution.trap(new int[]{}) == 0));

        // Single element
        System.out.println("Test 8: " + (solution.trap(new int[]{5}) == 0));

        // Complex pattern
        System.out.println("Test 9: " + (solution.trap(new int[]{5,2,1,2,1,5}) == 14));
    }
}
