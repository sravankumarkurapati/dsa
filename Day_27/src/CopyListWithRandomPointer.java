import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    
    // Function to implement
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> copyMap = new HashMap<>();
        copyMap.put(null, null);
        Node curr = head;
        while(curr!=null) {
        	
        	if(!copyMap.containsKey(curr)) {
        		copyMap.put(curr, new Node(0));
        	}
        	copyMap.get(curr).val = curr.val;
        	
        	if(!copyMap.containsKey(curr.next)) {
        		copyMap.put(curr.next, new Node(0));
        	}
        	copyMap.get(curr).next = copyMap.get(curr.next);
        	
        	if(!copyMap.containsKey(curr.random)) {
        		copyMap.put(curr.random, new Node(0));
        	}
        	copyMap.get(curr).random = copyMap.get(curr.random);
        	curr = curr.next;
        }
        return copyMap.get(head);
    }

    // Helper to compare two linked lists with random pointers
    private static boolean isEqual(Node a, Node b) {
        Map<Node, Integer> indexMapA = new HashMap<>();
        Map<Node, Integer> indexMapB = new HashMap<>();
        List<Node> listA = new ArrayList<>();
        List<Node> listB = new ArrayList<>();

        Node temp = a;
        int idx = 0;
        while (temp != null) {
            indexMapA.put(temp, idx++);
            listA.add(temp);
            temp = temp.next;
        }

        temp = b;
        idx = 0;
        while (temp != null) {
            indexMapB.put(temp, idx++);
            listB.add(temp);
            temp = temp.next;
        }

        if (listA.size() != listB.size()) return false;

        for (int i = 0; i < listA.size(); i++) {
            Node n1 = listA.get(i);
            Node n2 = listB.get(i);
            if (n1.val != n2.val) return false;
            Integer r1 = n1.random == null ? null : indexMapA.get(n1.random);
            Integer r2 = n2.random == null ? null : indexMapB.get(n2.random);
            if (!Objects.equals(r1, r2)) return false;
        }
        return true;
    }

    // Helper to build a list from values and random index mapping
    private static Node buildList(int[] values, int[] randomIndices) {
        if (values.length == 0) return null;

        Node[] nodes = new Node[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Node(values[i]);
        }

        for (int i = 0; i < values.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        for (int i = 0; i < values.length; i++) {
            if (randomIndices[i] != -1) {
                nodes[i].random = nodes[randomIndices[i]];
            }
        }

        return nodes[0];
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();

        // Test case 1
        Node test1 = buildList(new int[]{7, 13, 11, 10, 1}, new int[]{-1, 0, 4, 2, 0});
        Node expected1 = buildList(new int[]{7, 13, 11, 10, 1}, new int[]{-1, 0, 4, 2, 0});
        Node result1 = solution.copyRandomList(test1);
        System.out.println("Test Case 1: " + (isEqual(expected1, result1) ? "PASSED" : "FAILED"));

        // Test case 2
        Node test2 = buildList(new int[]{1, 2}, new int[]{1, 1});
        Node expected2 = buildList(new int[]{1, 2}, new int[]{1, 1});
        Node result2 = solution.copyRandomList(test2);
        System.out.println("Test Case 2: " + (isEqual(expected2, result2) ? "PASSED" : "FAILED"));

        

        // Test case 4 - empty list
        Node test4 = buildList(new int[]{}, new int[]{});
        Node expected4 = buildList(new int[]{}, new int[]{});
        Node result4 = solution.copyRandomList(test4);
        System.out.println("Test Case 4 (Empty List): " + (isEqual(expected4, result4) ? "PASSED" : "FAILED"));
    }
}
