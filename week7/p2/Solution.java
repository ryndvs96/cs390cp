import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int q = scan.nextInt();
    ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
    for (int i = 0; i < n; i++)
      adj.add(new ArrayList<Pair>());
    for (int i = 0; i < n - 1; i++) {
      int n1 = scan.nextInt() - 1;
      int n2 = scan.nextInt() - 1;
      int w = scan.nextInt();
      adj.get(n1).add(new Pair(n2, w));
      adj.get(n2).add(new Pair(n1, w));
    }
    
    int x = solve(-1, 0, q, n, adj);
    System.out.println(x);
  }

  public static int solve(int p, int i, int q, int n, ArrayList<ArrayList<Pair>> adj) {
    if (adj.get(i).size() == 1 && adj.get(i).get(0).f == p) {
      return 0;
    }

    int parent = -1;
    int neighbors = adj.get(i).size();
    for (int k = 0; k < neighbors; k++) {
      Pair x = adj.get(i).get(k);
      if (x.f == p) {
        parent = k;
        break;
      }
    }

    int max = 0;
    for (int k = 1; k <= (int) Math.pow(2, neighbors - 1); k++) {
      int card = card(k);
      if (q - card < 0)
        continue;
      int w = 0;
      System.out.println("testing " + card + " children");
      for (int j = 0; j < neighbors; j++) {
        if ((k & (1 << j)) == 1) {
          Pair next = null;
          if (j >= parent) {
            next = adj.get(i).get(j + 1);
          } else {
            next = adj.get(i).get(j);
          }
          w += next.s;
          w += solve(i, next.f, q - card, n, adj);
        }
      }
      max = Math.max(max, w);
    }

    return max;
  }

  public static int card(int i) {
    int c = 0;
    while (i > 0) {
      if ((i & 1) == 1)
        c++;
      i >>= 1;
    }
    return c;
  }
}

class Pair {
  int f;
  int s;
  public Pair(int f, int s) {
    this.f = f;
    this.s = s;
  }
}
