import java.io.*;
import java.util.*;

public class Solution {

  // O(n) solution, everything gets enqueued and dequeued once at most
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int k = scan.nextInt();

    if (n == 0 || k == 0)
      return;

    ArrayList<Integer> arrl = new ArrayList<>();

    String strs = "";
    while ((strs = scan.nextLine()).equals(""));

    strs = strs.trim();
    for (String str : strs.split("\\s+")) {
      try {
        int x = Integer.parseInt(str);
        arrl.add(x);
      } catch (Exception e) {
        // not an int
      }
    }

    if (k > n) {
      int max = Integer.MIN_VALUE;
      for (int x : arrl)
        max = max > x ? max : x;
      System.out.println(max);
      return;
    }

    int[] arr = new int[n];
    for (int i = 0; i < n && i < arrl.size(); i++)
      arr[i] = arrl.get(i);

    for (int i = 0; i < n - k + 1; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = 0; j < k; j++)
        max = max > arr[i + j] ? max : arr[i + j];
      System.out.println(max);
    }
  }
}
