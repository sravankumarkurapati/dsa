package day2;
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) {
        	return false;
        }
        
        int[] arr = new int[26];
        for(int i=0; i<s.length();i++) {
        	arr[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++) {
        	arr[s.charAt(i)-'a']--;
        	if(arr[s.charAt(i)-'a']<0) {
        		return false;
        	}
        }
        return true;
        
    }

    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();

        // Example test case
        String s = "anagram";
        String t = "nagaram";
        boolean result = solution.isAnagram(s, t);

        System.out.println("Is Anagram: " + result);
    }
}

