
import java.util.*;

public class LongestRepeatingCharacterReplacement {

    // Method to be implemented
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxWindow = 0;
        for(int right=0;right<s.length();right++) {
        	freq[s.charAt(right)-'A']++;
        	maxFreq = Math.max(maxFreq, freq[s.charAt(right)-'A']);
        	int windowSize = right-left+1;
        	if(windowSize-maxFreq > k) {
        		freq[s.charAt(left)-'A']--;
        		left++;
        	}
        	windowSize = right - left +1 ;
        	maxWindow = Math.max(maxWindow, windowSize);
        	
        }
        return maxWindow;
    }

    // Test runner
    public static void main(String[] args) {
    	LongestRepeatingCharacterReplacement sol = new LongestRepeatingCharacterReplacement();

        // Test Cases: { input string, k value, expected result }
        String[] testStrings = {
            "ABAB",        // Expected: 4 (change two 'A's or two 'B's)
            "AABABBA",     // Expected: 4 (change one 'A' or one 'B')
            "AAAA",        // Expected: 4 (already repeating)
            "ABCDE",       // Expected: 3 (change 2 to get 3 same)
            "",            // Expected: 0 (empty string)
            "BAAA",        // Expected: 4
            "ABBB",        // Expected: 4
            "AAAB",        // Expected: 4
            "ABAA",        // Expected: 4
        };

        int[] kValues = {
            2, 1, 2, 2, 1, 0, 2, 2, 0
        };

        int[] expected = {
            4, 4, 4, 3, 0, 3, 4, 4, 2
        };

        // Test execution
        for (int i = 0; i < testStrings.length; i++) {
            int result = sol.characterReplacement(testStrings[i], kValues[i]);
            System.out.println("Test " + (i + 1) + ": Input = \"" + testStrings[i] + "\", k = " + kValues[i]);
            System.out.println("Expected = " + expected[i] + ", Got = " + result);
            System.out.println(result == expected[i] ? "✅ Passed" : "❌ Failed");
            System.out.println("----------");
        }
    }
}

