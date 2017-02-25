import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int[] arr = new int[15];
    for (int i = 0; i < 15; i++)
      arr[i] = scan.nextInt();
    scan.close();
    System.out.println(solve(arr));
  }

  public static int solve(int[] arr) {
    int tot = 0;
    for (int i = 0; i < 15; i++) {
      for (int j = i + 2; j < 15; j++) {
        int prev = arr[i];
        int last = arr[j];
        //System.out.printf("Checking range: (%d, %d) (l = %d, r = %d)... ", i, j, prev, last);
        boolean b = true;
        for (int k = i + 1; k < j; k++)
          b = b && (arr[k] > prev && arr[k] > last);
        tot += b ? 1 : 0;
      }
    }
    return tot;
  }
}
