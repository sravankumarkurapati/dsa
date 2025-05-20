import java.util.*;

public class ValidSudoku {

    // Method to be implemented
    public boolean isValidSudoku(char[][] board) {
        // TODO: Implement the logic to validate the board
    	Set<String> set = new HashSet<>();
    	for(int i=0;i<9;i++) {
    		for(int j=0;j<9;j++) {
    			if(board[i][j]=='.') {
    				continue;
    			}
    			if(!set.add(board[i][j]+" at row "+i)) {
    				return false;
    			}
    			if(!set.add(board[i][j]+" at col "+j)) {
    				return false;
    			}
    			if(!set.add(board[i][j]+" at box "+i/3+"-"+j/3)) {
    				return false;
    			}
    		}
    	}
    	
    	
    	
        return true;
    }

    // Helper method to print the board
    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    // Main method with test cases
    public static void main(String[] args) {
    	ValidSudoku solution = new ValidSudoku();

        // Test Case 1: Valid board
        char[][] board1 = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println("Test Case 1:");
        printBoard(board1);
        System.out.println("Expected Output: true");
        System.out.println("Actual Output: " + solution.isValidSudoku(board1));
        System.out.println();

        // Test Case 2: Invalid due to duplicate in row
        char[][] board2 = {
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println("Test Case 2:");
        printBoard(board2);
        System.out.println("Expected Output: false");
        System.out.println("Actual Output: " + solution.isValidSudoku(board2));
        System.out.println();
    }
}
