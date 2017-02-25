import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int tests = scan.nextInt();
    for (int t = 0; t < tests; t++) {
      int n = scan.nextInt();
      int[] m = new int[n + 1];
      for (int i = 0; i < n + 1; i++) {
        String p = scan.next();
        for (int j = 0; j < n; j++) {
          m[i] |= (p.charAt(j) == '1') ? (1 << j) : 0;
        }
      }
      long x = solve(n, m);
      System.out.printf("Case %d: %d\n", t + 1, x);
    }
  }

  public static long solve(int n, int[] m) {
    long[] results = new long[(1 << n)];
    LinkedList<Pair> q = new LinkedList<>();

    results[0] = 1;
    q.addLast(new Pair(0, m[0]));
    while (!q.isEmpty()) {
      Pair p = q.removeFirst();
//      System.out.print("state: ");
//      print(p.first, n);
//      System.out.print("\ncando: ");
//      print(p.second, n);
//      System.out.println("\n");
      for (int i = 0; i < n; i++) {
  //      print(1<<i, n);
  //      System.out.println();
        if ((p.first & (1 << i)) == 0 && (p.second & (1 << i)) > 0) {
          // not already destroyed, and can destroy
          Pair t = new Pair(p.first | (1 << i), p.second | m[i + 1]);
          if (results[t.first] == 0) 
            q.addLast(t);
          results[t.first] += results[p.first];
        }
      }
    }
    return results[(1 << n) - 1];
  }

  public static void print(int i, int n) {
    for (int j = 0; j < n; j++) {
      System.out.print(i & 1);
      i >>= 1;
    }
  }

  public static class Pair {
    int first;
    int second;
    public Pair(int f, int s) {
      this.first = f;
      this.second = s;
    }
  }
}
