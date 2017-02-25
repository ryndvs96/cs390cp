import java.io.*;
import java.util.*;

public class Solution1 {
  public static void main(String[] args) {
    MyScanner scan = new MyScanner();
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    int n = scan.nextInt();
    int m = scan.nextInt();
    int q = scan.nextInt() + 1;

    int[] cardinality = new int[q];
    BitSet[][] arr = new BitSet[q][n];
    for (int i = 0; i < n; i++) {
      arr[0][i] = new BitSet(m);
      cardinality[0] = 0;
    }
    
    for (int k = 1; k < q; k++) {
      for (int i = 0; i < n; i++)
        arr[k][i] = arr[k-1][i];
      cardinality[k] = cardinality[k-1];
      // dealing with arr[k] bitset array
      int op = scan.nextInt();
      int i, j;
      switch (op) {
        case 1:
          i = scan.nextInt() - 1;
          j = scan.nextInt() - 1;
          cardinality[k] += arr[k][i].get(j) ? 0 : 1;
          arr[k][i] = (BitSet) arr[k - 1][i].clone();
          arr[k][i].set(j);
          break;
        case 2:
          i = scan.nextInt() - 1;
          j = scan.nextInt() - 1;
          cardinality[k] -= arr[k][i].get(j) ? 1 : 0;
          arr[k][i] = (BitSet) arr[k - 1][i].clone();
          arr[k][i].clear(j);
          break;
        case 3:
          i = scan.nextInt() - 1;
          cardinality[k] -= arr[k][i].cardinality();
          arr[k][i] = (BitSet) arr[k - 1][i].clone();
          arr[k][i].flip(0, m);
          cardinality[k] += arr[k][i].cardinality();
          break;
        case 4:
          i = scan.nextInt();
          arr[k] = arr[i];
          cardinality[k] = cardinality[i];
          break;
      }
      out.println(cardinality[k]);
    }
    out.flush();
  }

  
  // Scanner
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
    public String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
    public int nextInt() { return Integer.parseInt(next());  }
    public long nextLong() { return Long.parseLong(next());  }
    public double nextDouble() { return Double.parseDouble(next());  }
    public char nextChar() { return next().charAt(0);  }
  }
}
