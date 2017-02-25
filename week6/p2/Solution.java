import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    for (int i = 0; i < n; i++) {
      int board = 0;
      char[] line = scan.next().toCharArray();
      for (int j = 0; j < 12; j++) {
        if (line[j] == 'o')
          board |= (1 << j);
      }
      int x = solve(board);
      System.out.println(x);
    }
  }

  public static int count(int i) {
    int c = 0;
    while (i > 0) {
      if ((i & 1) == 1)
        c++;
      i >>= 1;
    }
    return c;
  }

  public static void print(int i ) {
    for (int j = 0; j < 12; j++) {
      if ((i & 1) == 1) {
        System.out.print("o");
      } else {
        System.out.print("-");
      }
      i >>= 1;
    }
    System.out.println();
  }

  public static int solve(int board) {
    HashSet<Integer> checked = new HashSet<>();
    LinkedList<Integer> q = new LinkedList<>();
    int min = count(board);
    q.addLast(board);

    while (!q.isEmpty()) {
      int state = q.removeFirst();  
//      print(state);
      min = Math.min(count(state), min);

      // moves right
      int r = 0b110;
      int m = 0b111;
      for (int i = 0; i < 10; i++) {
        int s = state;
        if ((m & s) == r) {
          s = s ^ m;
          if (!checked.contains(s)) {
  /*          System.out.println("moved right: from ");
            print(state);
            System.out.println("to");
            print(s);
            System.out.println();
    */        q.addLast(s);
          }
        }
        r <<= 1;
        m <<= 1;
      }
      
      // moves left
      r = 0b011;
      m = 0b111;
      for (int i = 0; i < 10; i++) {
        int s = state;
        if ((m & s) == r) {
          s = s ^ m;
          if (!checked.contains(s)) {
      /*      System.out.println("moved left: from ");
            print(state);
            System.out.println("to");
            print(s);
            System.out.println();
        */    q.addLast(s);
          }
        }
        r <<= 1;
        m <<= 1;
      }
    }

    return min;
  }
}
