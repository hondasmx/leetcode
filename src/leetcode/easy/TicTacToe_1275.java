package leetcode.easy;

import java.util.Arrays;

/**
 * Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:
 * <p>
 * Players take turns placing characters into empty squares ' '.
 * The first player A always places 'X' characters, while the second player B always places 'O' characters.
 * 'X' and 'O' characters are always placed into empty squares, never on filled ones.
 * The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
 * The game also ends if all squares are non-empty.
 * No more moves can be played if the game is over.
 * Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli]. return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".
 * <p>
 * You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.
 */
public class TicTacToe_1275 {

    public static void main(String[] args) {
        tictactoe(new int[][]{{2, 2}, {0, 2}, {1, 0}, {0, 1}, {2, 0}, {0, 0}});
    }

    public static String tictactoe(int[][] moves) {
        var rows = new int[3];
        var cols = new int[3];
        var diag1 = 0;
        var diag2 = 0;
        for (int i = 0; i < moves.length; i++) {
            int[] move = moves[i];
            var owner = i % 2 == 0 ? 1 : -1; // A = +1, B = -1
            int x = move[0];
            int y = move[1];
            rows[x] += owner;
            cols[y] += owner;
            if (x == y) {
                diag1 += owner;
            }
            if (x + y == 2) {
                diag2 += owner;
            }
        }
        Arrays.sort(rows);
        Arrays.sort(cols);

        if (diag1 == 3 || diag2 == 3 || rows[2] == 3 || cols[2] == 3) {
            return "A";
        }
        if (diag1 == -3 || diag2 == -3 || rows[0] == -3 || cols[0] == -3) {
            return "B";
        }

        return moves.length < 9 ? "Pending" : "Draw";
    }

}
