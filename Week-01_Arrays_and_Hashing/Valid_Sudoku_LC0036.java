public class Valid_Sudoku_LC0036 {

    public static boolean isValidSudoku(char[][] board) {
        // rows[i][d] means digit (d + 1) is present in row i
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char current = board[r][c];

                if (current == '.') {
                    continue;
                }

                int digit = current - '1'; // map '1'-'9' to index 0-8
                int boxIndex = (r / 3) * 3 + (c / 3);

                // Check if already seen in row, column, or 3x3 box
                if (rows[r][digit] || cols[c][digit] || boxes[boxIndex][digit]) {
                    return false;
                }

                // Mark current digit as seen
                rows[r][digit] = true;
                cols[c][digit] = true;
                boxes[boxIndex][digit] = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println("Is Valid Sudoku: " + isValidSudoku(board)); // Expected: true
    }
}