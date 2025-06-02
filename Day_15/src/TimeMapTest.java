import java.util.*;

public class TimeMapTest {
    public static void main(String[] args) {
        // LeetCode-style commands and inputs
        String[] commands = {"TimeMap", "set", "get", "set", "get", "get"};
        Object[][] inputs = {
            {}, 
            {"foo", "bar", 1}, 
            {"foo", 1}, 
            {"foo", "bar2", 4}, 
            {"foo", 4}, 
            {"foo", 5}
        };
        String[] expected = {"null", "null", "bar", "null", "bar2", "bar2"};

        List<String> outputs = new ArrayList<>();
        TimeMap obj = null;

        // Execute commands
        for (int i = 0; i < commands.length; i++) {
            String cmd = commands[i];
            switch (cmd) {
                case "TimeMap":
                    obj = new TimeMap();
                    outputs.add("null");
                    break;
                case "set":
                    String key = (String) inputs[i][0];
                    String value = (String) inputs[i][1];
                    int ts = (int) inputs[i][2];
                    obj.set(key, value, ts);
                    outputs.add("null");
                    break;
                case "get":
                    key = (String) inputs[i][0];
                    ts = (int) inputs[i][1];
                    outputs.add(obj.get(key, ts));
                    break;
            }
        }

        // Check results
        int passed = 0;
        int failed = 0;
        for (int i = 0; i < expected.length; i++) {
            if (outputs.get(i).equals(expected[i])) {
                System.out.println("Test " + (i + 1) + ": Passed");
                passed++;
            } else {
                System.out.println("Test " + (i + 1) + ": Failed — Expected: " + expected[i] + ", Got: " + outputs.get(i));
                failed++;
            }
        }

        System.out.println("\nTotal Passed: " + passed);
        System.out.println("Total Failed: " + failed);
    }
}

// Define TimeMap class separately (not as an inner class)
class TimeMap {
   
    Map<String,ArrayList<TimeStampValue>> mainMap;
    public TimeMap() {
        mainMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
       if( !mainMap.containsKey(key)) {
    	   mainMap.put(key, new ArrayList<>());
       }
       ArrayList<TimeStampValue> timeStampValues = mainMap.get(key);
       timeStampValues.add(new TimeStampValue(timestamp, value));
    }

    public String get(String key, int timestamp) {
       if(!mainMap.containsKey(key)) return "";
       ArrayList<TimeStampValue> timeStampValues = mainMap.get(key);
       Optional<TimeStampValue> foundTimeStamp = binarySearch(timeStampValues, timestamp);
       if(foundTimeStamp.isEmpty()) {
    	   return "";
       }
       return foundTimeStamp.get().value;
    }
    
    public Optional<TimeStampValue> binarySearch(ArrayList<TimeStampValue> arr, int targetTimeStamp){
    	int left=0;
    	int right=arr.size()-1;
    	int targetIndex = -1;
    	while(left<=right) {
    	    int mid=(left+right)/2;
    	    if(arr.get(mid).timeStamp<=targetTimeStamp) {
    	    	targetIndex = mid;
    	    	left = mid + 1;
    	    }
    	    else {
    	    	right = mid - 1;
    	    }
    	}
    	
    	if(targetIndex == -1) {
    		return Optional.empty();
    	}
    	return Optional.of(arr.get(targetIndex));
    	
    }

}

class TimeStampValue{
	int timeStamp;
	String value;
	TimeStampValue(int timeStamp,String value){
		this.timeStamp = timeStamp;
		this.value = value;
	}
}

