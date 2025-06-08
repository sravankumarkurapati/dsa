import java.util.*;

public class CarFleet {

    // Main method to test multiple test cases
    public static void main(String[] args) {
    	CarFleet tester = new CarFleet();

        // Test Case 1
        int[] position1 = {10, 8, 0, 5, 3};
        int[] speed1 = {2, 4, 1, 1, 3};
        int target1 = 12;
        int expected1 = 3;
        tester.runTest(position1, speed1, target1, expected1, 1);

        // Test Case 2
        int[] position2 = {3};
        int[] speed2 = {3};
        int target2 = 10;
        int expected2 = 1;
        tester.runTest(position2, speed2, target2, expected2, 2);

        // Test Case 3
        int[] position3 = {0, 2, 4};
        int[] speed3 = {4, 2, 1};
        int target3 = 100;
        int expected3 = 1;
        tester.runTest(position3, speed3, target3, expected3, 3);

        // Add more test cases if needed
    }

    // Method to execute and check a test case
    private void runTest(int[] position, int[] speed, int target, int expected, int testCaseNumber) {
        Solution solution = new Solution();
        int result = solution.carFleet(target, position, speed);
        if (result == expected) {
            System.out.println("Test Case " + testCaseNumber + ": Passed");
        } else {
            System.out.println("Test Case " + testCaseNumber + ": Failed");
            System.out.println("  Expected: " + expected);
            System.out.println("  Got:      " + result);
        }
    }
}

// Solution class with method to implement
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
    	int[][] cars = new int[position.length][2];
    	for(int i=0;i<position.length;i++) {
    		
    		cars[i][0] = position[i];
    		cars[i][1] = speed[i];
    		
    	}
    	
    	Arrays.sort(cars,(a,b)->Integer.compare(b[0],a[0]));
    	
    	Stack<Double> fleetStack = new Stack<>();
    	for(int[] car: cars) {
    	 fleetStack.push((double)(target-car[0])/car[1]);
    	 if(fleetStack.size()>=2 && fleetStack.peek()<=fleetStack.get(fleetStack.size()-2)) {
    		 fleetStack.pop();
    	 }
    	}
    	
        return fleetStack.size(); // Placeholder return
    }
}
