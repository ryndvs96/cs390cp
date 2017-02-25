import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    while (n > 0) {
      int[] trips = new int[n];
      int[] poops = new int[n];
      for (int i = 0; i < n; i++) {
        trips[i] = scan.nextInt();
        poops[i] = scan.nextInt();
      }
      int x = solve(n, trips, poops);
      System.out.println(x);
      n = scan.nextInt();
    }
  }

  public static class MyComp implements Comparator<Integer> {
    public int compare(Integer n1, Integer n2) {
      if (n1 < n2)
        return 1;
      if (n2 < n1)
        return -1;
      return 0;
    }
  }
  public static int solve(int n, int[] trips, int[] poops) {
    
    PriorityQueue<Integer> q = new PriorityQueue<>(n, new MyComp());
    int tot = 0;
    for (int i = n - 1; i >= 0; i--) {
      int k = poops[i];
      for (int j = 0; j < k && !q.isEmpty(); j++) {
        int time = q.poll() / 2;
        tot += time;
      }
      q.add(trips[i]);
    }
    while (!q.isEmpty())
      tot += q.poll();

    return tot;
  }
}
