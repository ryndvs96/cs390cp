import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) {
    MyScanner scan = new MyScanner();

    int n;
    while ((n = scan.nextInt()) != 0) {
      int n2 = next2(n);
      int[] arr = new int[n2 + 1];
      for (int i = 1; i <= n; i++)
        arr[i] = scan.nextInt();

      int max = solve(arr, 1, n2);
      System.out.println(max);
    }
  }

  public static int solve(int[] arr, int i, int j) {
  //  System.out.printf("solving... %d %d\n", i, j);
    // base case
    if (i == j) {
    //  System.out.println("returning " + arr[j] );
      return arr[j];
    }

    // divide
    int l = (i + j) / 2;
    int r = l + 1;
    int maxl = solve(arr, i, l);
    int maxr = solve(arr, r, j);
    int best = Math.max(maxl, maxr);

    // conquer
    int h = Math.min(arr[l], arr[r]);
    int max = (r - l + 1) * h;
    while (l >= i && r <= j) {
      // expand if we can
      while (l - 1 >= i && arr[l - 1] >= h) {
        // expand left
        l--;
      }
      while (r + 1 <= j && arr[r + 1] >= h) {
        // expand right
        r++;
      }
      int temp = (r - l + 1) * h;
      max = Math.max(temp, max);

      // take max of next left and next right
      if (l - 1 >= i && r + 1 <= j) {
        if (arr[l - 1] >= arr[r + 1]) {
          l--;
          h = arr[l];
        } else {
          r++;
          h = arr[r];
        }
      } else if (l - 1 >= i) {
        l--;
        h = arr[l];
      } else if (r + 1 <= j) {
        r++;
        h = arr[r];
      } else {
        break;
      }
    }
   // System.out.println("returning " + Math.max(best, max));
    return Math.max(best, max);
  }

  public static int next2(int n)
  {
    int count = 0;

    /* First n in the below condition is for the case where n is 0*/
    if (n > 0 && (n&(n-1)) == 0)
      return n;

    while( n != 0  )
    {
      n  >>= 1;
      count += 1;


    }

    return 1 << count;

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
