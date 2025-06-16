public class DeleteNthNodeFromEnd {

    // LeetCode-style ListNode definition
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Method to implement (placeholder)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode left = dummy;
        ListNode right = head;
        while(n>0) {
        	right = right.next;
        	n--;
        }
        while(right!=null) {
        	left = left.next;
        	right = right.next;
        }
        left.next = left.next.next;
    	return dummy.next;
    }

    // -------------------- Local Testing Framework --------------------
    public static void main(String[] args) {
    	DeleteNthNodeFromEnd sol = new DeleteNthNodeFromEnd();

        runTest(sol, new int[]{1, 2, 3, 4, 5}, 2, new int[]{1, 2, 3, 5});
        runTest(sol, new int[]{1}, 1, new int[]{});
        runTest(sol, new int[]{1, 2}, 1, new int[]{1});
        runTest(sol, new int[]{1, 2}, 2, new int[]{2});
        runTest(sol, new int[]{1, 2, 3}, 3, new int[]{2, 3});
        runTest(sol, new int[]{1, 2, 3, 4}, 1, new int[]{1, 2, 3});
        runTest(sol, new int[]{1, 2, 3, 4}, 4, new int[]{2, 3, 4});
    }

    // Test runner
    public static void runTest(DeleteNthNodeFromEnd sol, int[] input, int n, int[] expectedOutput) {
        ListNode head = buildList(input);
        ListNode expected = buildList(expectedOutput);
        ListNode result = sol.removeNthFromEnd(head, n);

        if (equals(result, expected)) {
            System.out.println("Test passed ✅ Input: " + toString(input) + ", n=" + n);
        } else {
            System.out.println("Test FAILED ❌ Input: " + toString(input) + ", n=" + n);
            System.out.println("Expected: " + toString(expected));
            System.out.println("Got     : " + toString(result));
        }
    }

    // Build linked list from array
    public static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Check if two linked lists are equal
    public static boolean equals(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }

    // Convert linked list to string
    public static String toString(ListNode head) {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(", ");
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // Convert array to string
    public static String toString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; ++i) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

