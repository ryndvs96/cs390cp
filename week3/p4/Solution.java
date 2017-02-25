import java.io.*;
import java.util.*;

public class Solution {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner scan = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));

    int N = scan.nextInt();
    int[] arr = new int[N];
    int tot = 0;
    for (int i = 0; i < N; i++) 
      arr[i] = scan.nextInt();
    Arrays.sort(arr);
    int min = arr[0];

    long w = 0;
    // make everything positive
    if (min < 0) {
      w = min;
      for (int i = 0; i < N; i++)
        arr[i] -= w;
    }

    // compounding total
    int[] comp = new int[N]; 
    comp[0] = arr[0];
    for (int i = 1; i < N; i++) {
      comp[i] = arr[i] + comp[i - 1];
    }

    //    System.out.printf("weight = %d\narr  = %s\ncomp = %s\n", w, Arrays.toString(arr), Arrays.toString(comp));

    int Q = scan.nextInt();
    for (int k = 0; k < Q; k++) {
      w += scan.nextLong();
      //    System.out.printf("weight = %d\narr  = %s\ncomp = %s\n", w, Arrays.toString(arr), Arrays.toString(comp));

      long temp = 0;
      if (w >= 0) {
        // weight is greater than zero, everything increases
        temp = comp[N-1] + w*N;
      } else if (-w > arr[N-1]) {
        // all elements will be less than zero after w applied;
        temp = -(comp[N-1] + w*N);
      } else {
        // binary search for the last element less than -weight;
        int i = Arrays.binarySearch(arr, -((int)w+1));
        if (i < 0) {
          i = -(i+2);
        }
        while (i + 1 < N && arr[i + 1] < -w){
          i++;
        }

        //System.out.printf("w = %d, i = %d, arr[i] = %d, arr[i+1] = %d\n", w,i, arr[i], arr[i+1]);

        // some elements will be less, some greater.
        // i = last element that will be less than 0 after w.
        // elements [0, i] will be less than 0
        // elements [i+1, N-1] will be greater, aplly similar to above.
        long ltot = comp[i];
        long rtot = comp[N-1] - ltot;
        long left = -(ltot + w*(i+1)); // left contribution
        long right = (rtot + w*(N-1-i)); // right contribution
        temp = left + right;
        //System.out.printf("%d, %d\n", left, right);
      }
      out.println(temp);
    }
    out.close();
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
