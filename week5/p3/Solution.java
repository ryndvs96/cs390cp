import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scan.nextInt();

    solve(arr);
  }

  public static void solve(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++)
      arr[i] = arr[i] + arr[i + 1];
  
    for (int i : arr)
      System.out.print(i + " ");
    System.out.println();
  }

}
