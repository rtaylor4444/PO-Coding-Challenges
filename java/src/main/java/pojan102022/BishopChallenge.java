package pojan102022;
import java.util.ArrayList;

public class BishopChallenge {
    public static void main(String[] args){
        BishopChallenge test = new BishopChallenge();
        System.out.println(test.bishop("a1", "b4", 2));
        System.out.println(test.bishop("a1", "b5", 5));
        System.out.println(test.bishop("f1", "f1", 0));
    }

    private int[][] board;
    public BishopChallenge() {
        board = new int[8][8];
    }
    private void resetBoard() {
        for(int i = 0; i < 8; ++i) {
            for(int j = 0; j < 8; ++j) {
                board[i][j] = Integer.MAX_VALUE;
            }
        }
    }
    private void printBoard() {
        for(int i = 0; i < 8; ++i) {
            for(int j = 0; j < 8; ++j) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    private void fillAllMoves(int curRow, int curCol, int curMove, int maxMove) {
        if(curMove >= maxMove) return;
        if(curMove > board[curRow][curCol]) return;
        //Pass 1
        //Fill in all the squares we can reach
        //Top-right diag
        int y = -1, x = 1;
        while(curRow + y >= 0 && curCol + x < 8) {
            board[curRow+y][curCol+x] = Math.min(board[curRow+y][curCol+x], curMove+1);
            --y;
            ++x;
        }
        //Top-left diag
        y = -1; x = -1;
        while(curRow + y >= 0 && curCol + x >= 0) {
            board[curRow+y][curCol+x] = Math.min(board[curRow+y][curCol+x], curMove+1);
            --y;
            --x;
        }
        //Bottom-right diag
        y = 1; x = 1;
        while(curRow + y < 8 && curCol + x < 8) {
            board[curRow+y][curCol+x] = Math.min(board[curRow+y][curCol+x], curMove+1);
            ++y;
            ++x;
        }
        //Bottom-left diag
        y = 1; x = -1;
        while(curRow + y < 8 && curCol + x >= 0) {
            board[curRow+y][curCol+x] = Math.min(board[curRow+y][curCol+x], curMove+1);
            ++y;
            --x;
        }


        //Pass 2
        //Recurse and check again for all squares we can reach now that our moves are filled
        //Top-right diag
        y = -1; x = 1;
        while(curRow + y >= 0 && curCol + x < 8) {
            fillAllMoves(curRow+y, curCol+x, curMove+1, maxMove);
            --y;
            ++x;
        }
        //Top-left diag
        y = -1; x = -1;
        while(curRow + y >= 0 && curCol + x >= 0) {
            fillAllMoves(curRow+y, curCol+x, curMove+1, maxMove);
            --y;
            --x;
        }
        //Bottom-right diag
        y = 1; x = 1;
        while(curRow + y < 8 && curCol + x < 8) {
            fillAllMoves(curRow+y, curCol+x, curMove+1, maxMove);
            ++y;
            ++x;
        }
        //Bottom-left diag
        y = 1; x = -1;
        while(curRow + y < 8 && curCol + x >= 0) {
            fillAllMoves(curRow+y, curCol+x, curMove+1, maxMove);
            ++y;
            --x;
        }
    }
    boolean bishop(String start, String end, int maxMoves) {
        resetBoard();
        int startRow = start.charAt(1) - '1';
        int startCol = (start.charAt(0) | 32) - 'a';
        int endRow = end.charAt(1) - '1';
        int endCol = (end.charAt(0) | 32) - 'a';
        board[startRow][startCol] = 0;
        fillAllMoves(startRow, startCol, 0, maxMoves);
        printBoard();
        return board[endRow][endCol] <= maxMoves;
    }
}
