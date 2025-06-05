import java.util.*;

public class ReversePolishNotation {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Cases
        String[][] inputs = {
            {"2", "1", "+", "3", "*"},                     // Expected: 9
            {"4", "13", "5", "/", "+"},                    // Expected: 6
            {"10", "6", "9", "3", "/", "-", "*"},          // Expected: 30
            {"3", "4", "+"},                               // Expected: 7
            {"5"},                                         // Expected: 5
            {"5", "1", "2", "+", "4", "*", "+", "3", "-"}  // Expected: 14
        };

        int[] expectedOutputs = {9, 6, 30, 7, 5, 14};

        for (int i = 0; i < inputs.length; i++) {
            int result = sol.evalRPN(inputs[i]); // Call the (to-be-implemented) method
            boolean passed = result == expectedOutputs[i];
            System.out.printf("Test Case %d: %s => Output: %d | Expected: %d | %s\n",
                    i + 1,
                    Arrays.toString(inputs[i]),
                    result,
                    expectedOutputs[i],
                    passed ? "Passed" : "Failed"
            );
        }
    }
}

// Skeleton for the actual solution class (to be implemented)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String s:tokens) {
        	if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")) {
        		stack.push(doOperation(Integer.parseInt(stack.pop()),Integer.parseInt(stack.pop()),s));
        	}
        	else {
        	stack.push(s);
        	}
        }
        return Integer.parseInt(stack.pop());
    }
    
    public String doOperation(Integer i1, Integer i2, String operation) {
    	if(operation.equals("+"))
    		return String.valueOf(i1+i2);
    	else if(operation.equals("-"))
    		return String.valueOf(i2-i1);
    	else if(operation.equals("*"))
    		return String.valueOf(i1*i2);
    	else if(operation.equals("/"))
    		return String.valueOf(i2/i1);
    	return null;
    }
    
}
