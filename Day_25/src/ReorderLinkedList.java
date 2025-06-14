import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class ReorderLinkedList {

    // --- Reorder List (Empty Implementation) ---
    public void reorderList(ListNode head) {
    	if(head==null) return;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        ListNode second = slow.next;
        ListNode prev = null;
        slow.next = null;
        while(second!=null) {
        	ListNode tmp = second.next;
        	second.next = prev;
        	prev = second;
        	second = tmp;
        }
        ListNode first = head;
        second = prev;
        while(second!=null) {
        	ListNode tmp1 = first.next; 
        	ListNode tmp2 =	second.next;
        	first.next = second;
        	second.next = tmp1;
        	first = tmp1;
        	second = tmp2;
        }
        		
    }

    // --- Utility methods for testing ---

    // Create linked list from array
    public static ListNode createList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode curr = head;
        for (int i = 1; i < values.length; i++) {
            curr.next = new ListNode(values[i]);
            curr = curr.next;
        }
        return head;
    }

    // Convert linked list to list for comparison
    public static List<Integer> toList(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

    // Compare two linked lists
    public static boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }

    // --- Test runner ---
    public static void main(String[] args) {
        ReorderLinkedList sol = new ReorderLinkedList();

        int[][][] testCases = {
            { {}, {} },
            { {1}, {1} },
            { {1, 2}, {1, 2} },
            { {1, 2, 3}, {1, 3, 2} },
            { {1, 2, 3, 4}, {1, 4, 2, 3} },
            { {1, 2, 3, 4, 5}, {1, 5, 2, 4, 3} },
            { {10, 20, 30, 40, 50, 60}, {10, 60, 20, 50, 30, 40} }
        };

        int testNum = 1;
        for (int[][] test : testCases) {
            ListNode input = createList(test[0]);
            ListNode expected = createList(test[1]);

            sol.reorderList(input);  // Currently does nothing

            boolean result = isEqual(input, expected);
            System.out.println("Test Case " + testNum + ": " + (result ? "Passed ✅" : "Failed ❌"));
            testNum++;
        }
    }
}
