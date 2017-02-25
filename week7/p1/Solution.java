import java.io.*;
import java.util.*;

public class Solution {
  public static int[] best;
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] p = new int[n];
    for (int i = 0; i < n; i++)
      p[i] = scan.nextInt();
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++)
      adj.add(new ArrayList<Integer>());
    for (int i = 0; i < n - 1; i++) {
      int u = scan.nextInt();
      int v = scan.nextInt();
      adj.get(u - 1).add(v - 1);
      adj.get(v - 1).add(u - 1);
    }

    best = new int[n];
    int x = solve(-1, 0, n, adj, p);
    System.out.println(x);

//    for (int i = 0; i < n; i++) {
  //    System.out.println("best i = " + i + ", " + best[i]);
    //}
  }


  public static int solve(int par, int i, int n, ArrayList<ArrayList<Integer>> adj, int[] p) {
    if (best[i] != 0)
      return best[i];
    if (adj.get(i).size() == 1 && adj.get(i).get(0) == par) {
      best[i] = p[i];
      return best[i];
    }

    // with this node
    int with = p[i];
    int without = 0;
    for (int u : adj.get(i)) {
      if (u == par)
        continue;
      for (int v : adj.get(u)) {
        if (v != i)
          with += solve(u, v, n, adj, p);
      }
      without += solve(i, u, n, adj, p);
    }
    best[i] = Math.max(with, without);
    return best[i];
  }
}
