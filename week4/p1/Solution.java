import java.io.*;
import java.util.*;

public class Solution {

  public static long[] tree = null; // 1 indexed
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    for (int k = 0; k < t; k++) {
      tree = null;
      // re nullify globals

      // pad
      int n_tot = scan.nextInt();
      int n = next2(n_tot) * 2;
      tree = new long[n];
//      System.out.println(n);

      int c = scan.nextInt();
      for (int i = 0; i < c; i++) {
        int type = scan.nextInt();
        int p = scan.nextInt();
        int q = scan.nextInt();
        if (type == 0) {
          // update
          long v = scan.nextLong();
          update(1, 1, n / 2, p, q, v);
          //          print();
        } else {
          // sum value
          System.out.println(sum(1, 1, n / 2, p, q));
          //          print();
        }
      }
    }
  }

  public static int next2(int n)
  {
    int count = 0;

    /* First n in the below condition is for the case where n is 0*/
    if (n > 0 && (n&(n-1)) == 0)
      return n;

    while( n != 0 )
    {
      n  >>= 1;
      count += 1;

    }

    return 1 << count;
  }

  public static void print() {
    System.out.print("[");
    for (long i : tree)
      System.out.print(i + " ");
    System.out.println("]");
  }

  // l and r are this nodes bounds, i and j are the range
  public static long sum(int node, int l, int r, int i, int j) {
    //  System.out.printf("sum\t\t: %d, %d, %d, %d, %d\n", node, l, r, i, j);
    if (r < i || j < l || j < i)
      return Integer.MAX_VALUE;

    // if exact range
    if (l == i && r == j)
      return tree[node];

    int halfl = (l+r)/2;
    int halfr = halfl + 1;
    // if just in left subtree
    if (i >= halfr)
      return sum(1 + node * 2, halfr, r, i, j);

    // if just in right subtree
    if (j <= halfl)
      return sum(node * 2, l, halfl, i, j);

    long sum1 = sum(node * 2, l, halfl, i, halfl);
    long sum2 = sum(1 + node * 2, halfr, r, halfr, j);
    return sum1 + sum2;
  }

  public static void update(int node, int l, int r, int i, int j, long v) {
    //   System.out.printf("update\t\t: %d, %d, %d, %d, %d, %d\n", node, l, r, i, j, v);
    if (r < i || j < l || j < i)
      return;
    if (l == r && i <= l && l <= j) { 
      //     System.out.printf("incrementing: %d %d %d %d\n", l, r, i, j);
      tree[node] += v;
    } else {
      //     System.out.printf("recursing: %d %d %d %d\n", l, r, i, j);
      update(node * 2, l, (l+r)/2, i, j, v);
      update(1 + node * 2, 1 + (l+r)/2, r, i, j, v);
      //     System.out.printf("finished recursing: %d %d %d %d\n", l, r, i, j);
      tree[node] = tree[node * 2] + tree[(node * 2) + 1];
    }
  }
}
