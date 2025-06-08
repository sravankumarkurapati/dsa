import java.util.Stack;

public class MinStack {
     
	Stack<Integer> stack;
	Stack<Integer> minStack;

    // ================================
    // Constructor
    // ================================
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // ================================
    // Public Methods
    // ================================

    public void push(int val) {
       stack.push(val);
       if(minStack.isEmpty() || val<=minStack.peek()) {
    	   minStack.push(val);
       }
    }

    public void pop() {
       int top = stack.pop();
       if(top == minStack.peek())
    	   minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    // ================================
    // Main method with test cases
    // ================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // -------- Test Case 1 --------
        try {
            MinStack ms = new MinStack();
            ms.push(-2);
            ms.push(0);
            ms.push(-3);
            check(ms.getMin(), -3, "Test 1.1 - getMin()");
            ms.pop();
            check(ms.top(), 0, "Test 1.2 - top()");
            check(ms.getMin(), -2, "Test 1.3 - getMin() after pop");
            pass += 3;
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
            fail++;
        }

        // -------- Test Case 2 --------
        try {
            MinStack ms = new MinStack();
            ms.push(2);
            ms.push(2);
            ms.push(1);
            check(ms.getMin(), 1, "Test 2.1 - getMin()");
            ms.pop();  // remove 1
            check(ms.getMin(), 2, "Test 2.2 - getMin() after pop");
            ms.pop();  // remove 2
            check(ms.getMin(), 2, "Test 2.3 - getMin() after duplicate pop");
            pass += 3;
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
            fail++;
        }

        // -------- Summary --------
        System.out.println();
        System.out.println("=========== Test Summary ===========");
        System.out.println("✅ Passed: " + pass);
        System.out.println("❌ Failed: " + fail);
    }

    // Helper for checking values
    private static void check(int actual, int expected, String testName) {
        if (actual != expected) {
            throw new AssertionError("❌ " + testName + ": Expected " + expected + ", Got " + actual);
        } else {
            System.out.println("✅ " + testName + " passed.");
        }
    }
}

