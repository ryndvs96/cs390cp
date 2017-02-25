import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String str = scan.nextLine();

    char[] arr = str.toCharArray();
    solve(arr);
    System.out.println(new String(arr));
  }

  public static void solve(char[] arr) {
    int n = arr.length;
    int i = 0; // find first non 'a'
    for (; i < n && arr[i] == 'a'; i++);

    // all are 'a'
    if (i == n) {
      arr[n - 1] = shift(arr[n - 1]);
      return;
    }

    // first non 'a'
    // find all greater than 'a'
    for (; i < n && arr[i] > 'a'; i++)
      arr[i] = shift(arr[i]);
  }

  public static char shift(char c) {
    if (c == 'a')
      return 'z';
    else
      return (char)((int)c - 1);
  }

}
