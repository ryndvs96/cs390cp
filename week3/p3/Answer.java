import java.io.*;
import java.util.*;

public class Answer {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int q = scan.nextInt();

    for (int i = 0; i < q; i++) {
      int n = scan.nextInt();
      int m = scan.nextInt();

      int[] arr = new int[n];
      for (int j = 0; j < n; j++)
        arr[j] = scan.nextInt();

      int max = solve(arr, n, m); 

      System.out.println(max);
    }
    scan.close();
  }

  public static int solve(int[] arr, int n, int m) {
    int max = 0;
    int maxsum = 0;
    int maxi = 0;
    int maxj = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
          sum += arr[k];
        }
        
        if (sum % m > max) {
          max = sum % m;
          maxsum = sum;
          maxi = i;
          maxj = j;
        }
      }
    }
    System.err.printf("max = %d, sum = %d from (%d, %d)\n", max, maxsum, maxi, maxj);
    return max;
  }

}
