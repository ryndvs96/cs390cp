import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int q = scan.nextInt();
    for (int t = 0; t < q; t++) {
      int n = scan.nextInt();
      int m = scan.nextInt();
      int[][] adj = new int[n][n];
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
          adj[i][j] = (i == j ? 0 : (int) Short.MAX_VALUE); // prevent overflow to negs
      for (int i = 0; i < m; i++) {
        int v1 = scan.nextInt() - 1;
        int v2 = scan.nextInt() - 1;
        adj[v1][v2] = 6;
        adj[v2][v1] = 6;
      }

      int s = scan.nextInt() - 1;
      int[] dist = bfs(adj, s, n);
      for (int i = 0; i < n; i++) {
        if (i == s)
          continue;
        if (dist[i] == (int) Short.MAX_VALUE) {
          System.out.printf("-1 ");
        } else {
          System.out.printf("%d ", dist[i]);
        }
      }
      System.out.println();
    }
  }
  public static void print(int[][] adj, int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.printf("%7d, ", adj[i][j]);
      }
      System.out.println();
    }
  }

  public static int[] bfs(int[][] adj, int s, int n) {
    int[] dist = new int[n]; // from s to v
    for (int i = 0; i < n; i++)
      dist[i] = (i == s ? 0 : (int) Short.MAX_VALUE);
    HashSet<Integer> checked = new HashSet<>();
    LinkedList<Integer> q = new LinkedList<Integer>();
    q.addLast(s);
    checked.add(s);
    while (!q.isEmpty()) {
      int v = q.removeFirst();
      for (int i = 0; i < n; i++) {
        if (!checked.contains(i) && adj[v][i] != Short.MAX_VALUE) {
          dist[i] = dist[v] + adj[v][i];
          checked.add(i);
          q.addLast(i);
        }
      }
    }
    return dist;
  }
}
