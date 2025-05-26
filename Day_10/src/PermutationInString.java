
public class PermutationInString {

    // TODO: Implement this function
    public boolean checkInclusion(String s1, String s2) {
          int len1 = s1.length();
          int len2 = s2.length();
          if(len1>len2) {
        	  return false;
          }
          int[] freq = new int[26];
          for(int i=0;i<s1.length();i++) {
        	  freq[s1.charAt(i)-'a']++;
          }
          for(int i=0;i<s2.length();i++) {
        	  freq[s2.charAt(i)-'a']--;
        	  if(i-len1 >=0) {
        		  freq[s2.charAt(i-len1)-'a']++;
        	  }
        	 if (checkIfAllZero(freq))
        	   return true;
          }
         return false;
    }
  public boolean checkIfAllZero(int[] freq) {
	  for(int i=0;i<26;i++) {
		  if(freq[i]!=0) {
			  return false;
		  }
	  }
	  
	  return true;
  }
    // Helper to run and validate each test case
    public static void runTest(int testCaseNum, String s1, String s2, boolean expected) {
    	PermutationInString sol = new PermutationInString();
        boolean result = sol.checkInclusion(s1, s2);

        if (result == expected) {
            System.out.println("✅ Test Case " + testCaseNum + " Passed");
        } else {
            System.out.println("❌ Test Case " + testCaseNum + " Failed - Expected: " + expected + ", Got: " + result);
        }
    }

    public static void main(String[] args) {
        // LeetCode + Custom Test Cases
        runTest(1, "ab", "eidbaooo", true);      // "ba" is a permutation of "ab"
        runTest(2, "ab", "eidboaoo", false);     // No permutation found
        runTest(3, "adc", "dcda", true);         // "cda" contains "adc"
        runTest(4, "hello", "ooolleoooleh", false);
        runTest(5, "a", "a", true);              // Exact match
        runTest(6, "a", "b", false);             // Different chars
        runTest(7, "ab", "a", false);            // s1 > s2
        runTest(8, "abcd", "eidbacdcbad", true); // "bacd" is a match
        runTest(9, "xyz", "afxyzcdef", true);    // "xyz" exists
        runTest(10, "xyz", "axyz", true);        // match at end
    }
}

