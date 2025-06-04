import java.util.*;

public class ValidParenthesesTest {

    // Solution class as required by Leetcode
    static class Solution {
        public boolean isValid(String s) {
               Stack<Character> stack = new Stack<>();
               for(char ch:s.toCharArray()) {
            	   if(ch == '{')
            		   stack.push('}');
            	   else if(ch == '(')
            		   stack.push(')');
            	   else if(ch == '[')
            		   stack.push(']');
            	   else if(stack.isEmpty() || stack.pop() != ch) {
            		   return false;
            	   }
               }
        	 return stack.isEmpty();
        }
    }

    // Helper to test each case
    static void runTest(String input, boolean expected) {
        Solution sol = new Solution();
        boolean result = sol.isValid(input);
        if (result == expected) {
            System.out.println("✅ Passed: \"" + input + "\"");
        } else {
            System.out.println("❌ Failed: \"" + input + "\" → Expected: " + expected + ", Got: " + result);
        }
    }

    // Main test runner
    public static void main(String[] args) {
        // Standard test cases from Leetcode
        runTest("()", true);
        runTest("()[]{}", true);
        runTest("(]", false);
        runTest("([)]", false);
        runTest("{[]}", true);
        runTest("]", false);
        runTest("[", false);
        runTest("({[()]})", true);
        runTest("((()))", true);
        runTest("((())", false);
        runTest("", true); // Empty string is valid

        // Edge cases
        runTest("(((((((((())))))))))", true);
        runTest("(((((((((()))))))))))", false);
    }
}
