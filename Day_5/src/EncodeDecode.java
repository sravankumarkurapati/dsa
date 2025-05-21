
import java.util.*;

public class EncodeDecode {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
    	String finalString ="";
       for(String str:strs) {
    	   finalString = finalString+str.length()+"#"+str;
       }
       return finalString;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i=0;
        while(i<s.length()) {
        	int j=i;
        	while(s.charAt(j)!='#') {
        		j++;
        	}
        	Integer length = Integer.parseInt(s.substring(i, j));
        	j++;
        	result.add(s.substring(j,j+length));
        	i=j+length;
        }
        return result;
    }

    // Main method with various test cases
    public static void main(String[] args) {
    	EncodeDecode codec = new EncodeDecode();

        List<List<String>> testCases = new ArrayList<>();
        testCases.add(List.of("hello", "world"));                       // Regular
        testCases.add(new ArrayList<>());                               // Empty list
        testCases.add(List.of("", "", ""));                             // Empty strings
        testCases.add(List.of("!@#$", "^&*()", "{}[]<>"));              // Special characters
        testCases.add(List.of("a#b", "c#d#e", "#"));                    // Contains #
        testCases.add(List.of("123", "456#", "78#90"));                 // Numbers & #
        testCases.add(List.of("你好", "こんにちは", "안녕하세요"));       // Unicode
        testCases.add(List.of("a".repeat(1000), "b".repeat(2000)));     // Long strings

        int caseNum = 1;
        for (List<String> testCase : testCases) {
            String encoded = codec.encode(testCase);
            List<String> decoded = codec.decode(encoded);
            boolean pass = decoded.equals(testCase);

            System.out.println("Test Case " + caseNum++);
            System.out.println("Original : " + testCase);
            System.out.println("Encoded  : " + encoded);
            System.out.println("Decoded  : " + decoded);
            System.out.println("Pass     : " + pass);
            System.out.println("--------------------------------------------------");
        }
    }
}

