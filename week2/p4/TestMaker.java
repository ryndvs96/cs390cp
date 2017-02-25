import java.util.*;
import java.io.*;

public class TestMaker {
  public static ArrayList<ArrayList<Num>> arr = new ArrayList<ArrayList<Num>>(100);
  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      arr.add(new ArrayList<Num>());
    }

    Num l = new Num(0, 1);
    Num r = new Num(1, 0);
    Num c = new Num(1, 1);
    t(l, c, r, 0);
    for (ArrayList<Num> list : arr) {
      for (Num i : list) {
        System.out.printf("%d/%d ", i.num, i.den);
      }
      System.out.println();
    } 
  }
  public static void t(Num left, Num cent, Num right, int step) {
    if (step == 20 || cent.num > 100 || cent.den > 100)
      return;

    if (arr.get(step) == null)
      arr.set(step, new ArrayList<Num>());

    arr.get(step).add(cent);
    // left
    t(left, new Num(left.num + cent.num, left.den + cent.den), cent, step + 1);
    // right
    t(cent, new Num(right.num + cent.num, right.den + cent.den), right, step + 1);
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
