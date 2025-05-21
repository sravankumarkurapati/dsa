public class ValidPalindrome {

    // Method to check if a string is a valid palindrome
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
    	int i=0;
    	int j=s.length()-1;
    	while(i<j) {
    		if(s.charAt(i)!=s.charAt(j)) {
    			return false;
    		}
    		i++;
    		j--;
    	}
    	return true;
    }

    // Main method for test cases
    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();

        String[] testCases = {
            "A man, a plan, a canal: Panama",  // true
            "race a car",                      // false
            "",                                // true
            " ",                               // true
            "0P",                              // false
            "Madam",                           // true
            "Was it a car or a cat I saw?",    // true
            "No 'x' in Nixon",                 // true
            "12321",                           // true
            "123ab321"                         // false
        };

        int caseNum = 1;
        for (String test : testCases) {
            boolean result = vp.isPalindrome(test);
            System.out.println("Test Case " + caseNum++);
            System.out.println("Input  : \"" + test + "\"");
            System.out.println("Output : " + result);
            System.out.println("----------------------------------------");
        }
    }
}
