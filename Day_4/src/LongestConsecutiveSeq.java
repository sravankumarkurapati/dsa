import java.util.*;

public class LongestConsecutiveSeq {

    // Method to be implemented
    public int longestConsecutive(int[] nums) {
        // TODO: Implement the logic here
    	int longestseq=0;
    	Map<Integer,Boolean> exploredMap = new HashMap<>();
    	for(int n: nums) {
    		exploredMap.put(n, Boolean.FALSE);
    	}
    	for(int current: nums) {
    		int temp =1;
    		int nextNum = current+1;
    		while(exploredMap.get(nextNum)!=null && exploredMap.get(nextNum)==false) {
    			temp++;
    			exploredMap.put(nextNum, Boolean.TRUE);
    			nextNum++;
    			
    		}
    		
    		int prevNum = current-1;
    		while(exploredMap.get(prevNum)!=null && exploredMap.get(prevNum)==false) {
    			temp++;
    			exploredMap.put(prevNum, Boolean.TRUE);
    			prevNum--;
    			
    		}
    	   longestseq = Math.max(longestseq, temp);	
    	}
    	
    	
        return longestseq;
    }

    // Main method with multiple test cases
    public static void main(String[] args) {
    	LongestConsecutiveSeq solution = new LongestConsecutiveSeq();

        // Test Case 1
        int[] testCase1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Test Case 1: " + Arrays.toString(testCase1));
        System.out.println("Expected Output: 4");
        System.out.println("Actual Output: " + solution.longestConsecutive(testCase1));
        System.out.println();

        // Test Case 2
        int[] testCase2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Test Case 2: " + Arrays.toString(testCase2));
        System.out.println("Expected Output: 9");
        System.out.println("Actual Output: " + solution.longestConsecutive(testCase2));
        System.out.println();

        // Test Case 3
        int[] testCase3 = {};
        System.out.println("Test Case 3: " + Arrays.toString(testCase3));
        System.out.println("Expected Output: 0");
        System.out.println("Actual Output: " + solution.longestConsecutive(testCase3));
        System.out.println();

        // Test Case 4
        int[] testCase4 = {1, 2, 0, 1};
        System.out.println("Test Case 4: " + Arrays.toString(testCase4));
        System.out.println("Expected Output: 3");
        System.out.println("Actual Output: " + solution.longestConsecutive(testCase4));
        System.out.println();

        // Test Case 5
        int[] testCase5 = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        System.out.println("Test Case 5: " + Arrays.toString(testCase5));
        System.out.println("Expected Output: 7");
        System.out.println("Actual Output: " + solution.longestConsecutive(testCase5));
        System.out.println();
    }
}
