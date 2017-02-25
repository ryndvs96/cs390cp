import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int m = scan.nextInt();
    boolean[][] grid = new boolean[n][m];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        grid[i][j] = scan.nextInt() == 1;

    int[][] reg = new int[n][m];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        reg[i][j] = -1;

    int regs = 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (reg[i][j] == -1 && grid[i][j]) {
          explore(reg, regs, grid, i, j);
          regs++;
        }
      }
    }

    print(reg);

    if (regs == 1) {
      System.out.println(0);
      return;
    }

    int[] count = new int[regs];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        if (reg[i][j] > 0) 
          count[reg[i][j]]++;


    int max = 0;
    for (int i = 1; i < regs; i++)
      max = max > count[i] ? max : count[i];

    System.out.println(max);

  }

  public static void explore(int[][] reg, int regs, boolean[][] grid, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || reg[i][j] != -1)
      return;

    if (!grid[i][j])
      reg[i][j] = 0; 
    else {
      reg[i][j] = regs; 
      for (int x = -1; x <= 1; x++)
        for (int y = -1; y <= 1; y++)
          if (x != 0 || y != 0)
            explore(reg, regs, grid, x + i, y + j);

    }

  }

  public static void print(int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        System.out.printf("%2d ", grid[i][j]);
      }
      System.out.println();
    }
    System.out.println("--------------");
  }

}
