import java.io.*;
import java.util.*;

public class Solution {

  public static int n = 0;
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    int sum = 0;

    for (int i = 0; i < n; i++) {
      boolean[][] board = new boolean[n][n];
      board[0][i] = true;
      sum += place(board, 1);

    }
    System.out.println(sum);

  }

  public static int place(boolean[][] board, int row) {
    if (row == n) {
      for(int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          System.out.printf("%d ", board[i][j] ? 1 : 0);
        }
        System.out.println();
      }
      System.out.println("-----------------");
      return 1;
  
    }

    int sum = 0;
    for (int j = 0; j < n; j++) {
      if (!conf(row, j, board)) {
        board[row][j] = true;
        sum += place(board, row + 1);
        board[row][j] = false;

      }

    }
    return sum;

  }

  public static boolean conf(int row, int col, boolean[][] board) {
    for (int i = row - 1; i >= 0; i--)
      if (board[i][col])
        return true;

    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; j--, i--)
      if (board[i][j])
        return true;

    for (int i = row - 1, j = col + 1; i >= 0 && j < n; j++, i--)
      if (board[i][j])
        return true;

    return false;

  }

  public static int getRdag(int i, int j) {
    return n - i + j;

  }
  public static int getLdag(int i, int j) {
    return i + j + 1;

  }

}
