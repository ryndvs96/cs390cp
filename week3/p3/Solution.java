import java.util.*;
import java.io.*;

public class Solution {
  public static MyScanner scan;
  public static PrintWriter out;
  public static void main(String[] args) {
    scan = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int q = scan.nextInt();
    for (int i = 0; i < q; i++)
      prob();
    out.close();
  }

  public static void prob() {
    int n = scan.nextInt();
    long m = scan.nextLong();
    long[] comp = new long[n];
    comp[0] = scan.nextLong() % m;
    for (int i = 1; i < n; i++) {
      comp[i] = comp[i-1] + scan.nextLong() + m;
      comp[i] %= m;
    }
    solve(comp, m, n);
  }

  public static void solve(long[] comp, long m, int n) {
    TreeSet<Long> set = new TreeSet<>();
    long[] maxs = new long[n];
    maxs[0] = comp[0] % m;
    long max = maxs[0];
    set.add(comp[0]);
    for (int i = 1; i < n; i++) {
      Long elem = set.ceiling(comp[i] + 1);
      maxs[i] = (elem == null ? comp[i] : comp[i] - elem + m) % m;
      max = max > maxs[i] ? max : maxs[i];
      set.add(comp[i]);
    }

    out.printf("%d\n", max);
  }

  public static class MyScanner {
    BufferedReader br;
    StringTokenizer st;
    public MyScanner() {
      br = new BufferedReader(new InputStreamReader(System.in));

    }
    public boolean hasNext() {
      try {
        boolean a = br.ready();
        return a;

      } catch (IOException e) {
        return false;

      }

    }
    public String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());

        } catch (IOException e) {
          e.printStackTrace();

        }

      }
      return st.nextToken();

    }
    public int nextInt() {
      return Integer.parseInt(next());

    }
    public long nextLong() {
      return Long.parseLong(next());

    }
    public double nextDouble() {
      return Double.parseDouble(next());

    }
    public char nextChar() {
      return next().charAt(0);

    }
    public String nextLine() {
      String str = "";
      try {
        str = br.readLine();

      } catch (IOException e) {
        e.printStackTrace();

      }
      return str;

    }

  }
}


