// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) { 
        this.val = val; 
    }

    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while(list1!=null && list2!=null) {
        	if(list1.val < list2.val) {
        		node.next = list1;
        		list1 = list1.next;
        	} else {
        		node.next = list2;
        		list2 = list2.next;
        	}
        	node = node.next;
        }
        if(list1!=null) {
        	node.next = list1;
        } else {
        	node.next = list2;
        }
        return dummy.next;
    }
}

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Input: [1,2,4], [1,3,4] → Expected: [1,1,2,3,4,4]
        test(sol, new int[]{1,2,4}, new int[]{1,3,4}, new int[]{1,1,2,3,4,4}, 1);

        // Test Case 2: Input: [], [] → Expected: []
        test(sol, new int[]{}, new int[]{}, new int[]{}, 2);

        // Test Case 3: Input: [], [0] → Expected: [0]
        test(sol, new int[]{}, new int[]{0}, new int[]{0}, 3);

        // Test Case 4: Input: [5], [1,2,3] → Expected: [1,2,3,5]
        test(sol, new int[]{5}, new int[]{1,2,3}, new int[]{1,2,3,5}, 4);

        // Test Case 5: Input: [2,6,9], [1,3,7] → Expected: [1,2,3,6,7,9]
        test(sol, new int[]{2,6,9}, new int[]{1,3,7}, new int[]{1,2,3,6,7,9}, 5);
    }

    // Helper function to run a test case
    public static void test(Solution sol, int[] a1, int[] a2, int[] expected, int testNum) {
        ListNode list1 = buildList(a1);
        ListNode list2 = buildList(a2);
        ListNode result = sol.mergeTwoLists(list1, list2);

        if (compareList(result, buildList(expected))) {
            System.out.println("Test " + testNum + " PASSED");
        } else {
            System.out.println("Test " + testNum + " FAILED");
            System.out.print("Expected: ");
            printList(buildList(expected));
            System.out.print("Got     : ");
            printList(result);
        }
    }

    // Helper to build a linked list from an array
    public static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper to compare two linked lists
    public static boolean compareList(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }

    // Helper to print a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
