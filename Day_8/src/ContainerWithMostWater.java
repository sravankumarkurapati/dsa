public class ContainerWithMostWater {

    // Method to implement
    public int maxArea(int[] height) {
        
    	int i =0;
    	int j = height.length -1;
    	int maxArea = 0;
    	int tempArea = 0;
    	while(i<j) {
    		tempArea = Math.min(height[i], height[j])*(j-i);
    		if(height[i]>height[j]) {
    			j--;
    		} else {
    			i++;
    		}
    		maxArea = Math.max(maxArea, tempArea);
    		
    	}
    	
    	return maxArea;
    	
    }

    // Main method to run test cases
    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();

        // Test Case 1: Example case
        System.out.println("Test Case 1: " + (solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}) == 49));

        // Test Case 2: Minimum elements
        System.out.println("Test Case 2: " + (solution.maxArea(new int[]{1,1}) == 1));

        // Test Case 3: All same height
        System.out.println("Test Case 3: " + (solution.maxArea(new int[]{5,5,5,5}) == 15));

        // Test Case 4: Decreasing heights
        System.out.println("Test Case 4: " + (solution.maxArea(new int[]{5,4,3,2,1}) == 6));

        // Test Case 5: Increasing heights
        System.out.println("Test Case 5: " + (solution.maxArea(new int[]{1,2,3,4,5}) == 6));

        // Test Case 6: Single element (edge case)
        System.out.println("Test Case 6: " + (solution.maxArea(new int[]{1}) == 0));

        // Test Case 7: Empty array (edge case)
        System.out.println("Test Case 7: " + (solution.maxArea(new int[]{}) == 0));

        // Test Case 8: Large values
        System.out.println("Test Case 8: " + (solution.maxArea(new int[]{10000, 1, 10000}) == 20000));
    }
}
