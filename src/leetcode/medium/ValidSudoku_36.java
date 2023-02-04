package leetcode.medium;

import java.util.HashSet;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */

public class ValidSudoku_36 {

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{
                {'.', '4', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '1', '.', '.', '7', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '3', '.', '.', '.', '6', '.'},
                {'.', '.', '.', '.', '.', '6', '.', '9', '.'},
                {'.', '.', '.', '.', '1', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '8', '.', '.', '.', '.', '.'}}
        ));
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            var row = board[i];
            if (hasDuplicates(row)) {
                return false;
            }

            var column = new char[9];
            var square = new char[9];
            for (int j = 0; j < 9; j++) {
                column[j] = board[j][i];
                if (j % 3 == 0 && i % 3 == 0) {
                    square[0] = board[i]    [j];
                    square[1] = board[i + 1][j];
                    square[2] = board[i + 2][j];
                    square[3] = board[i]    [j + 1];
                    square[4] = board[i + 1][j + 1];
                    square[5] = board[i + 2][j + 1];
                    square[6] = board[i]    [j + 2];
                    square[7] = board[i + 1][j + 2];
                    square[8] = board[i + 2][j + 2];
                }
                if (hasDuplicates(square)) {
                    return false;
                }
            }

            if (hasDuplicates(column)) {
                return false;
            }

        }

        return true;
    }

    private static boolean hasDuplicates(char[] chars) {
        var result = new HashSet<Character>();
        for (char aChar : chars) {
            if (!Character.isDigit(aChar)) {
                continue;
            }
            if (!result.add(aChar)) {
                return true;
            }
        }
        return false;
    }

}
