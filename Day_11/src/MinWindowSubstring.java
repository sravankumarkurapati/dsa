import java.util.*;

class MinWindowSubstring {
    public String minWindow(String s, String t) {
    	//edge case - empty string in case the String s size is less than target t
    	if(s.length()<t.length()) return ""; 
    	//Create a map to track all the entries of characters with their count
    	Map<Character,Integer> targetMap = new HashMap<>();
    	for(char ch:t.toCharArray()) {
    		targetMap.put(ch, targetMap.getOrDefault(ch, 0)+1);
    	}
    	//For window management create left and right indexes
    	int left=0;
    	int right=0;
    	//To find the start of the minimum length string create one index
    	int minleft=0;
    	//To track the minimum size window containing elements of the target
    	int minSize=Integer.MAX_VALUE; 
    	//Map to track characters in the window
    	Map<Character,Integer> windowMap = new HashMap<>();
    	//Track number of matched items
    	int matched = 0;
    	
    	while(right<s.length()) {
    		//Update the counter of the character read in the window map
    		windowMap.put(s.charAt(right), windowMap.getOrDefault(s.charAt(right),0)+1);
    		//Check if the current character is there in the target Map.
    		//Check the count of characters in window map and target map if it matches increment the matched counter
    		if(targetMap.containsKey(s.charAt(right))&& 
    				windowMap.get(s.charAt(right)).intValue() ==  targetMap.get(s.charAt(right)).intValue()) {
    			matched ++;
    		}
    		//when matched count is equal to the targetMap size it means the characters are found
    		while(targetMap.size() == matched) {
    			//If window size is the minimum length we have to replace minSize accordingly and also track minleft
    			if(right-left+1 < minSize) {
    				minSize = right-left+1;
    				minleft = left;		
    			}
    			//Remove left most character and decrement it from map if it is present in targetMap and update matched counter
    			char leftChar = s.charAt(left);
    			windowMap.put(leftChar, windowMap.get(leftChar)-1);
    			if(targetMap.containsKey(leftChar) && targetMap.get(leftChar).intValue()>windowMap.get(leftChar).intValue()) {
    				matched--;
    			}
    			left++;
    		}
    		right++;
    	}
    	return minSize ==Integer.MAX_VALUE? "":s.substring(minleft,minleft+minSize);
      
    }

    // Helper to test individual cases
    public static void runTest(String s, String t, String expected) {
    	MinWindowSubstring sol = new MinWindowSubstring();
        String result = sol.minWindow(s, t);
        if (result.equals(expected)) {
            System.out.println("PASSED ✅  Input: s = \"" + s + "\", t = \"" + t + "\" → Output: \"" + result + "\"");
        } else {
            System.out.println("FAILED ❌  Input: s = \"" + s + "\", t = \"" + t + "\" → Output: \"" + result + "\", Expected: \"" + expected + "\"");
        }
    }

    public static void main(String[] args) {
        // 🔹 Sample LeetCode-style test cases
        runTest("ADOBECODEBANC", "ABC", "BANC");
        runTest("a", "a", "a");
        runTest("a", "aa", "");
        runTest("ab", "b", "b");
        runTest("aa", "aa", "aa");
        runTest("bba", "ab", "ba");
        runTest("aaaaaaaaaaaabbbbbcdd", "abcdd", "abbbbbcdd");
        runTest("ab", "a", "a");
        runTest("ab", "c", "");
        runTest("abc", "ac", "abc");
    }
}

