import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int Q = scan.nextInt();
    int[] arr = new int[N];
    for (int i = 0; i < N; i++)
      arr[i] = scan.nextInt();
    Fenwick f = new Fenwick(arr);
    for (int k = 0; k < Q; k++) {
      String str = scan.next();
      if (str.equals("G")) {
        /*  G i num_marbles - if the mom decides to 
         *  give num_marbles to student i.
         */
        int i = scan.nextInt();
        int x = scan.nextInt();
        f.update(i, x);
      } else if (str.equals("T")) {
        /*  T i num_marbles - if the mom decides to 
         *  take away num_marbles from student i
         */
        int i = scan.nextInt();
        int x = scan.nextInt();
        f.update(i, -x);
      } else if (str.equals("S")){
        /*  S i j - if the mom wants to find the sum 
         *  of the number of marbles from students i to j. 
         */
        int i = scan.nextInt();
        int j = scan.nextInt();
        System.out.printf("%d\n", f.sum(i, j));
      } else {
        System.out.println(f);
      }
    }
  }
}

class Fenwick {
  public int size;
  public int[] tree; // self contained 1-indexed
  // create new fenwick tree size n
  public Fenwick(int n) {
    this.size = n + 1;
    this.tree = new int[this.size];
  }
  // initialize fenwick tree with array
  public Fenwick(int[] arr) {
    this.size = arr.length + 1;
    this.tree = new int[this.size];
    for (int i = 0; i < arr.length; i++)
      this.update(i, arr[i]);
  }

  // sum up from 1 to i
  public int sum(int i) {
    i = i + 1;
    int sum = 0;
    while (i > 0) {
      sum += tree[i];
      i -= (i & (-i)); // remove right most bit
    }
    return sum;
  }
  public int sum(int i, int j) {
    return this.sum(j) - this.sum(i - 1);
  }

  // update index i and all frequencies
  public void update(int i, int num) {
    i = i + 1;
    while (i < this.size) {
      tree[i] += num;
      i += (i & (-i)); // add right most bit
    }
  }

  public String toString() {
    String str = "[";
    for (int a : tree) {
      str += a + ", ";
    }
    str += "]";
    return str;
  }
}
