import java.io.*;
import java.util.*;

public class SolutionN {
  public static void main(String[] args) {
    MyScanner scan = new MyScanner();

    int n;
    while ((n = scan.nextInt()) != 0) {
      int[] arr = new int[n];
      for (int i = 0; i < n; i++)
        arr[i] = scan.nextInt();

      int max = solve(arr, n);
      System.out.println(max);
    }
  }

  public static int solve(int[] arr, int n) {
    if (n == 0)
      return -1;
    if (n == 1)
      return arr[0];

    // maintain stack of indices
    Stack<Integer> s = new Stack<>();
    s.push(0);
    int max = Integer.MIN_VALUE;

    for (int r = 0; r < n; r++) {
      while (!s.isEmpty() && arr[r] < arr[s.peek()]) {
        // found the rectangle less on the right
        int height = arr[s.pop()];
        int l = s.isEmpty() ? -1 : s.peek();
        max = Math.max(max, (r - l - 1) * height);
      }
      s.push(r);
    }
    while (!s.isEmpty()) {
      int height = arr[s.pop()];
      int l = s.isEmpty() ? -1 : s.peek();
      max = Math.max(max, (n - l - 1) * height);
    }

    return max;
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
