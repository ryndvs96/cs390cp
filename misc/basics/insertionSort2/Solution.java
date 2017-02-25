import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scan.nextInt();
    System.out.println(solve(arr, 0));
  }

  public static int solve(int[] arr, int i) {       
    if (i == arr.length) 
      return 0;

    int c = arr[i];
    int j = i;

    // find where it should be
    for (; j > 0 && c < arr[j - 1]; j--);

    int shifts = i - j;
    for (; j <= i; j++) {
      int temp = arr[j];
      arr[j] = c;
      c = temp;
    }

    return shifts + solve(arr, i + 1);
  } 
}
