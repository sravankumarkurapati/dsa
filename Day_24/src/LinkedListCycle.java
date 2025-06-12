// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListCycle {

    // LeetCode method to detect a cycle in a linked list
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null) {
        	fast = fast.next.next;
        	slow = slow.next;
        	if(fast==slow) {
        		return true;
        	}
        }
        return false;
    }

    // Utility to print test result
    private static void test(String description, boolean expected, boolean actual) {
        System.out.println(description + " => " + (expected == actual ? "PASSED" : "FAILED") +
                " (Expected: " + expected + ", Got: " + actual + ")");
    }

    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();

        // Test case 1: No cycle
        ListNode node1 = new ListNode(3);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(0);
        node1.next.next.next = new ListNode(-4);
        test("Test Case 1: No Cycle", false, solution.hasCycle(node1));

        // Test case 2: Cycle at position 1 (tail connects to node 2)
        ListNode node2 = new ListNode(3);
        ListNode n2_2 = new ListNode(2);
        ListNode n2_3 = new ListNode(0);
        ListNode n2_4 = new ListNode(-4);
        node2.next = n2_2;
        n2_2.next = n2_3;
        n2_3.next = n2_4;
        n2_4.next = n2_2; // create cycle
        test("Test Case 2: Cycle at node 2", true, solution.hasCycle(node2));

        // Test case 3: Single node, no cycle
        ListNode node3 = new ListNode(1);
        test("Test Case 3: Single node, no cycle", false, solution.hasCycle(node3));

        // Test case 4: Single node, cycle to itself
        ListNode node4 = new ListNode(1);
        node4.next = node4; // cycle
        test("Test Case 4: Single node with cycle", true, solution.hasCycle(node4));

        // Test case 5: Two nodes, no cycle
        ListNode node5 = new ListNode(1);
        node5.next = new ListNode(2);
        test("Test Case 5: Two nodes, no cycle", false, solution.hasCycle(node5));

        // Test case 6: Two nodes, cycle
        ListNode node6 = new ListNode(1);
        ListNode n6_2 = new ListNode(2);
        node6.next = n6_2;
        n6_2.next = node6; // cycle
        test("Test Case 6: Two nodes with cycle", true, solution.hasCycle(node6));
    }
}

