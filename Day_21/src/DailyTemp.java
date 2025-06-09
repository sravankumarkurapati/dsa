import java.util.*;

public class DailyTemp {
    // TODO: Implement this method
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<temperatures.length;i++) {
        	int currentTemp = temperatures[i];
        	while(!stack.isEmpty() && stack.peek()[0]<currentTemp) {
        		int[] temppair = stack.pop();
        		result[temppair[1]] = i-temppair[1];
        	}
        	stack.push(new int[] {temperatures[i],i});
        }
        return result;
    }

    // Test cases to verify the implementation
    public static void main(String[] args) {
    	DailyTemp sol = new DailyTemp();

        // Test Case 1
        test(sol, new int[]{73,74,75,71,69,72,76,73}, new int[]{1,1,4,2,1,1,0,0});

        // Test Case 2: strictly decreasing
        test(sol, new int[]{30,29,28,27}, new int[]{0,0,0,0});

        // Test Case 3: all same temperature
        test(sol, new int[]{50,50,50,50}, new int[]{0,0,0,0});

        // Test Case 4: only one element
        test(sol, new int[]{100}, new int[]{0});

        // Test Case 5: alternating up and down
        test(sol, new int[]{60, 62, 61, 63, 60}, new int[]{1,2,1,0,0});

        // Test Case 6: empty input
        test(sol, new int[]{}, new int[]{});

        // Test Case 7: strictly increasing
        test(sol, new int[]{30,40,50,60}, new int[]{1,1,1,0});
    }

    private static void test(DailyTemp sol, int[] input, int[] expected) {
        int[] output = sol.dailyTemperatures(input);
        if (Arrays.equals(output, expected)) {
            System.out.println("✅ Passed for input: " + Arrays.toString(input));
        } else {
            System.out.println("❌ Failed for input: " + Arrays.toString(input));
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Got     : " + Arrays.toString(output));
        }
    }
}
