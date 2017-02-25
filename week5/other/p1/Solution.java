import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int tests = scan.nextInt();
    for (int t = 0; t < tests; t++) {
      int n = scan.nextInt();
      boolean can = true;
      char[][] m = new char[n][n];
      for (int i = 0; i < n; i++) {
        m[i] = scan.next().trim().toCharArray();
        Arrays.sort(m[i]);
      }
      for (int j = 0; j < n; j++) {
        int prev = (int)'a' - 1;
        for (int i = 0; i < n; i++) {
          if (m[i][j] < prev) {
            can = false;
            break;
          } else {
            prev = m[i][j];
          }
        }
      }

      System.out.printf("%s\n", can ? "YES" : "NO");
    }
  }
}
