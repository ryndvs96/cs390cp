import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] larr = new int[n];
    for (int i = 0; i < n; i++)
      larr[i] = scan.nextInt();

    solve(n, larr);
  }

  public static void solve(int n, int[] arr) {
    Arrays.sort(arr);
    int i = n - 1;
    for (i = n - 1; i > 1; i--) {
      int l1 = arr[i];
      int l2 = arr[i - 1];
      int l3 = arr[i - 2];
      if (l3 + l2 > l1)
        break;
    }
    if (i > 1) {
      System.out.printf("%d %d %d\n", arr[i - 2], arr[i - 1], arr[i]);
    } else {
      System.out.printf("-1\n");
    }
  }
  
}
