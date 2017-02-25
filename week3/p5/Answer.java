import java.io.*;
import java.util.*;

public class Answer {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt();
    int b = scan.nextInt();
    int c = scan.nextInt();
    int d = scan.nextInt();
    int[] arr = new int[]{a, b, c, d};
    Arrays.sort(arr);

    a = arr[0];
    b = arr[1];
    c = arr[2];
    d = arr[3];

    int tot = 0;
    int bae = 0;

    for (int w = 1; w <= a; w++) {
      for (int x = w; x <= b; x++) {
        for (int y = x; y <= c; y++) {
          for (int z = y; z <= d; z++) {
            if ((w ^ x ^ y ^ z) != 0)
              bae++;
            else {
              print(w, x, y, z);
            }
            tot++;
          }
        }
      }
    }

    System.out.printf("%d : %d\n", bae, tot);
  }

  public static void print(int a, int b, int c, int d) {
    int bits = 6;
    int[] aa = bits(bits, a);
    int[] bb = bits(bits, b);
    int[] cc = bits(bits, c);
    int[] dd = bits(bits, d);

    System.out.printf("%2d %2d %2d %2d\n-- -- -- --\n", a, b, c, d);
    for (int i = 0; i < bits; i++) {
      System.out.printf("%2d %2d %2d %2d\n", aa[i], bb[i], cc[i], dd[i]);
    }
    System.out.println();
  }

  public static int[] bits(int bits, int a) {
    int[] num = new int[bits];

    int i = bits - 1;
    while (a > 0 && i >= 0) {
      num[i] = a & 1;
      i--;
      a >>= 1;
    }

    return num;
  }
}
