import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    while (n > 0) {
      int max = (int) Math.pow(2, n);
      int[] scores = new int[n];
      int[] groups = new int[n];
      HashSet<Integer> members = new HashSet<>();
      for (int g = 0; g < n; g++) {
        int group = 0;
        for (int i = 0; i < 3; i++) {
          int m = scan.nextInt() - 1;
          members.add(m);
          group |= (1 << m);
        }

        int score = scan.nextInt();
        groups[g] = group;
        scores[g] = score;
      }
      if (members.size() == 12) {
        int m = compute(n, groups, scores);
        System.out.println(m);
      } else {
        System.out.println("-1");
      }
      n = scan.nextInt();
    }
    scan.close();
  }

  public static int compute(int n, int[] groups, int[] scores) {
    ArrayList<Tuple> t = new ArrayList<>();
    t.add(new Tuple(0, 0));
    for (int i = 0; i < n; i++) {
      ArrayList<Tuple> ti = new ArrayList<>();
      int g = groups[i];
      int s = scores[i];
      for (Tuple k : t) {
        if ((k.members & g) == 0) {
          ti.add(new Tuple(k.value + s, k.members | g));
        }
      }
      for (Tuple k : t) {
        ti.add(k);
      }
      t = ti;
    }

    int max = 0;
    for (Tuple k : t)
      max = Math.max(k.value, max);
    return max;
  }
}

class Tuple {
  int value;
  int members;
  public Tuple(int value, int members) {
    this.value = value;
    this.members = members;
  }
}
