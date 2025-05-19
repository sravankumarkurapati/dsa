
import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        
    	List<Integer>[] bucket = new List[nums.length+1];
    	Map<Integer,Integer> frequencyMap = new HashMap<>();
    	for(int num: nums) {
    		frequencyMap.put(num,frequencyMap.getOrDefault(num, 0)+1);
    	}
    	for(int key: frequencyMap.keySet()) {
    		int frequency = frequencyMap.get(key);
    		if(bucket[frequency]==null) {
    			bucket[frequency] = new ArrayList<>();
    		}
    		bucket[frequency].add(key);
    	}
    	int[] res = new int[k];
    	int counter = 0;
    	for(int pos=bucket.length-1; pos>0 &&counter<k ;pos--) {
    		if(bucket[pos]!=null) {
    		for(int i=0;i<bucket[pos].size()&&counter<k;i++) {
    		  res[counter]= bucket[pos].get(i);
    		  counter++;
    		}
    		}
    	}
    	
    	return res;
    }

    // === Test cases ===
    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();

        System.out.println("Test Case 1");
        int[] result1 = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println("Expected: [1, 2] → Got: " + Arrays.toString(result1));

        System.out.println("\nTest Case 2");
        int[] result2 = solution.topKFrequent(new int[]{1}, 1);
        System.out.println("Expected: [1] → Got: " + Arrays.toString(result2));

        System.out.println("\nTest Case 3");
        int[] result3 = solution.topKFrequent(new int[]{4, 4, 4, 4}, 1);
        System.out.println("Expected: [4] → Got: " + Arrays.toString(result3));

        System.out.println("\nTest Case 4");
        int[] result4 = solution.topKFrequent(new int[]{4, 4, 1, 1, 2, 2, 3}, 2);
        System.out.println("Expected: [4, 1] or [4, 2] or [1, 2] → Got: " + Arrays.toString(result4));

        System.out.println("\nTest Case 5");
        int[] result5 = solution.topKFrequent(new int[]{}, 0);
        System.out.println("Expected: [] → Got: " + Arrays.toString(result5));
    }
}
