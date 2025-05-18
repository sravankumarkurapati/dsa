package day2;

import java.util.*;

public class GroupAnagrams {

    /**
     * Groups anagrams from the input array.
     *
     * @param strs array of strings
     * @return list of grouped anagrams
     */
    public List<List<String>> groupAnagrams(String[] strs) {
    	Map<String,ArrayList<String>> tempMap = new HashMap<>();
    	
    	for(int i=0;i<strs.length;i++) {
    		String s=strs[i];
    		int[] arr = new int[26];
    		for(char c: s.toCharArray()) {
    			arr[c-'a']++;
    		}
    		StringBuilder sb = new StringBuilder();
    		for(int j:arr) {
    			sb.append("#");
    			sb.append(j);
    		}
    		String key = sb.toString();
    		if(tempMap.get(key)==null) {
    			tempMap.put(key, new ArrayList<>());
    		}
    		tempMap.get(key).add(s);
    	}
    	;
    	return new ArrayList<>(tempMap.values());
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();

        // 🔹 Test Case 1: Multiple groups
        String[] input1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> output1 = solution.groupAnagrams(input1);
        System.out.println("Test 1 Output: " + output1);

        // 🔹 Test Case 2: Single word
        String[] input2 = {"hello"};
        List<List<String>> output2 = solution.groupAnagrams(input2);
        System.out.println("Test 2 Output: " + output2);

        // 🔹 Test Case 3: Empty input
        String[] input3 = {};
        List<List<String>> output3 = solution.groupAnagrams(input3);
        System.out.println("Test 3 Output: " + output3);

        // 🔹 Test Case 4: Duplicates
        String[] input4 = {"a", "b", "a"};
        List<List<String>> output4 = solution.groupAnagrams(input4);
        System.out.println("Test 4 Output: " + output4);

        // 🔹 Test Case 5: Mixed case
        String[] input5 = {"bat", "tab", "tab"};
        List<List<String>> output5 = solution.groupAnagrams(input5);
        System.out.println("Test 5 Output: " + output5);
    }
}

