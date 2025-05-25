
import java.util.*;

public class LongSubStringWithoutRepeatChar {

    // Method to be implemented
    public int lengthOfLongestSubstring(String s) {
             int left = 0;
             int maxlength = 0;
             Set<Character> set = new HashSet<>();
             for(int right=0;right<s.length();right++) {
            	 while(set.contains(s.charAt(right))) {
            		 set.remove(s.charAt(left));
            		 left++;
            	 }
            	 set.add(s.charAt(right));
            	 maxlength = Math.max(maxlength, right-left+1);
            	 
             }
            	return maxlength;
          
    }

    // Test runner
    public static void main(String[] args) {
    	LongSubStringWithoutRepeatChar sol = new LongSubStringWithoutRepeatChar();

        // Test Cases
        String[] testStrings = {
            "abcabcbb",    // Expected: 3 ("abc")
            "bbbbb",       // Expected: 1 ("b")
            "pwwkew",      // Expected: 3 ("wke")
            "",            // Expected: 0 (empty string)
            " ",           // Expected: 1 (single space)
            "au",          // Expected: 2 ("au")
            "dvdf",        // Expected: 3 ("vdf")
            "anviaj",      // Expected: 5 ("nviaj")
            "abba",        // Expected: 2 ("ab" or "ba")
            "tmmzuxt",     // Expected: 5 ("mzuxt")
        };

        int[] expected = {
            3, 1, 3, 0, 1, 2, 3, 5, 2, 5
        };

        // Test execution
        for (int i = 0; i < testStrings.length; i++) {
            int result = sol.lengthOfLongestSubstring(testStrings[i]);
            System.out.println("Test " + (i + 1) + ": Input = \"" + testStrings[i] + "\"");
            System.out.println("Expected = " + expected[i] + ", Got = " + result);
            System.out.println(result == expected[i] ? "✅ Passed" : "❌ Failed");
            System.out.println("----------");
        }
    }
}

