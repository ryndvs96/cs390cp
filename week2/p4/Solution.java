import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    for (int i = 0; i < n; i++) {
      int a1 = scan.nextInt();
      int a2 = scan.nextInt();
      int b1 = scan.nextInt();
      int b2 = scan.nextInt();

      // initial nums
      Num a = new Num(a1, b1);
      Num b = new Num(a2, b2);
      Num c = new Num(1, 1);
      Num d = new Num(0, 1);
      Num e = new Num(1, 0);

      Num anc = ancestor(a, b, c, d, e);
      System.out.println(anc.num + "/" + anc.den);
    }
  }

  public static Num ancestor(Num a, Num b, Num c, Num d, Num e) {
    // calculate numerators
    int num1 = a.num * b.den * c.den;
    int num2 = a.den * b.num * c.den;
    int num3 = a.den * b.den * c.num;

    if (num1 < num3 && num2 < num3) {
      Num center = new Num(c.num + d.num, c.den + d.den);
      return ancestor(a, b, center, d, c);
    } else if (num1 > num3 && num2 > num3) {
      Num center = new Num(c.num + e.num, c.den + e.den);
      return ancestor(a, b, center, c, e);
    } else {
      return c;
    }
  }

}
class Num {
  public int num;
  public int den;
  public Num(int num, int den) {
    this.num = num;
    this.den = den;
  }
}
