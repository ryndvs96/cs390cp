import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) {
    MyScanner scan = new MyScanner();
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    int n = scan.nextInt();
    int m = scan.nextInt();
    int q = scan.nextInt() + 1;
    String[][] queries = new String[q][];
    for (int i = 1; i < q; i++) 
      queries[i] = scan.nextLine().split(" ");

    Bookcase[] arr = new Bookcase[q];
    arr[0] = new Bookcase(null, m);

    for (int k = 1; k < q; k++) {
      String[] qu = queries[k];
      arr[k] = new Bookcase(arr[k - 1], m);

      // dealing with arr[k] bitset array
      int i, j;
      switch (qu[0]) {
        case "1":
          i = Integer.parseInt(qu[1]) - 1;
          j = Integer.parseInt(qu[2]) - 1;
          // contains / puts
          arr[k].place(i, j);
          break;
        case "2":
          i = Integer.parseInt(qu[1]) - 1;
          j = Integer.parseInt(qu[2]) - 1;
          // contains / puts
          arr[k].remove(i, j);
          break;
        case "3":
          i = Integer.parseInt(qu[1]) - 1;
          // flip
          arr[k].flip(i);
          break;
        case "4":
          i = Integer.parseInt(qu[1]);
          arr[k] = arr[i];
          break;
      }
      out.println(arr[k].card);
      out.flush();
    }
  }

  public static class Bookcase {
    public Bookcase base;
    public BitSet set;
    public int shelf;
    public int card;
    public int m;
    public Bookcase(Bookcase base, int m) {
      this.base = base;
      this.set = null;
      this.shelf = -1;
      this.card = base == null ? 0 : base.card;
      this.m = m;
    }

    public void place(int i, int j) {
      this.shelf = i;
      BitSet prev = this.base.getShelf(i);
      this.set = prev != null ? (BitSet) prev.clone() : new BitSet(this.m);
      this.card += this.set.get(j) ? 0 : 1;
      this.set.set(j);
    }
    public void flip(int i) {
      this.shelf = i;
      BitSet prev = this.base.getShelf(i);
      this.set = prev != null ? (BitSet) prev.clone() : new BitSet(this.m);
      this.card -= this.set.cardinality();
      this.set.flip(0, this.m);
      this.card += this.set.cardinality();
    }
    public void remove(int i, int j) {
      BitSet prev = this.base.getShelf(i);
      if (prev == null)
        return;
      
      this.shelf = i;
      this.set = (BitSet) prev.clone();
      this.card -= this.set.get(j) ? 1 : 0;
      this.set.clear(j);
    }

    public BitSet getShelf(int i) {
      if (this.shelf == i)
        return this.set;
      if (this.base != null)
        return this.base.getShelf(i);
      return null;
    }
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
