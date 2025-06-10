import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;
        while(currNode != null) {
        	ListNode temp = currNode.next;
        	currNode.next = prevNode;
        	prevNode = currNode;
        	currNode = temp;
        }
        return prevNode;
    }

    // Converts array to linked list
    public static ListNode arrayToList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Converts linked list to array
    public static List<Integer> listToArray(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

    // Runs a single test case
    public static boolean runTest(int testCaseNum, int[] inputArr, int[] expectedArr, ReverseLinkedList sol) {
        ListNode input = arrayToList(inputArr);
        ListNode result = sol.reverseList(input);
        List<Integer> output = listToArray(result);
        List<Integer> expected = new ArrayList<>();
        for (int val : expectedArr) expected.add(val);

        boolean passed = output.equals(expected);
        System.out.println("Test Case " + testCaseNum + ": " + (passed ? "PASSED" : "FAILED"));
        if (!passed) {
            System.out.println("  Input: " + Arrays.toString(inputArr));
            System.out.println("  Expected: " + expected);
            System.out.println("  Got: " + output);
        }
        return passed;
    }

    public static void main(String[] args) {
    	ReverseLinkedList sol = new ReverseLinkedList();
        boolean allPassed = true;

        allPassed &= runTest(1, new int[]{}, new int[]{}, sol);
        allPassed &= runTest(2, new int[]{1}, new int[]{1}, sol);
        allPassed &= runTest(3, new int[]{1, 2}, new int[]{2, 1}, sol);
        allPassed &= runTest(4, new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}, sol);
        allPassed &= runTest(5, new int[]{1, 3, 3, 2}, new int[]{2, 3, 3, 1}, sol);

        System.out.println("\nSummary: " + (allPassed ? "All test cases PASSED ✅" : "Some test cases FAILED ❌"));
    }
}
