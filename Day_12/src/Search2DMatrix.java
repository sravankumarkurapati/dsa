
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
       int rowId = getPotentialRow(matrix, target);
       if(rowId!=-1) return searchTarget(rowId, matrix, target);
       else return false;
    }
    
    public int getPotentialRow(int[][] matrix, int target) {
    	int low = 0;
    	int high = matrix.length-1;
    	while(low<=high) {
    		int mid = (low+high)/2;
    		if(matrix[mid][0]<=target && target<=matrix[mid][matrix[0].length-1]) {
    			return mid;
    		} else if(matrix[mid][0]>target) {
    			high = mid-1;
    		} else if(matrix[mid][0]<target) {
    			low = mid+1;
    		}
    	}
    	return -1;
    }
    
    public boolean searchTarget(int rowId, int[][] matrix, int target) {
    	int low = 0;
    	int high = matrix[rowId].length-1;
    	while(low<=high) {
    		int mid = (low+high)/2;
    		if(matrix[rowId][mid]==target) {
    			return true;
    		} else if(matrix[rowId][mid]>target) {
    			high = mid-1;
    		} else if(matrix[rowId][mid]<target) {
    			low = mid+1;
    		}
    	}
    	return false;
    }

    // Utility method to print test results
    public static void runTest(int[][] matrix, int target, boolean expected, int testNumber, Search2DMatrix sol) {
        boolean result = sol.searchMatrix(matrix, target);
        if (result == expected) {
            System.out.println("Test " + testNumber + ": Passed ✅");
        } else {
            System.out.println("Test " + testNumber + ": Failed ❌ | Expected: " + expected + ", Got: " + result);
        }
    }

    public static void main(String[] args) {
    	Search2DMatrix sol = new Search2DMatrix();

        int[][] matrix1 = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        runTest(matrix1, 3, true, 1, sol);         // Present
        runTest(matrix1, 13, false, 2, sol);       // Not present

        int[][] matrix2 = {};
        runTest(matrix2, 1, false, 3, sol);        // Empty matrix

        int[][] matrix3 = {{5}};
        runTest(matrix3, 5, true, 4, sol);         // One element, present
        runTest(matrix3, 10, false, 5, sol);       // One element, absent

        int[][] matrix4 = {{1, 3, 5, 7}};
        runTest(matrix4, 7, true, 6, sol);         // One row

        int[][] matrix5 = {{1}, {3}, {5}, {7}};
        runTest(matrix5, 5, true, 7, sol);         // One column

        int[][] matrix6 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        runTest(matrix6, 9, true, 8, sol);         // Last element
        runTest(matrix6, 1, true, 9, sol);         // First element
    }
}

