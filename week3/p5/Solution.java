import java.io.*;
import java.util.*;

public class Solution {
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

    double notbeauty = not(Math.min(a, b), Math.min(c, d));
    double totalbeauty = total(a, b, c, d);

    System.out.printf("%.0f - %.0f\n", totalbeauty, notbeauty);
    double tot = totalbeauty - notbeauty;

    System.out.println(tot);
  } 

  public static double total(double a, double b, double c, double d) {
    //for (int w = 1; w <= a; w++)
    //  for (int x = w; x <= b; x++)
    //    for (int y = x; y <= c; y++)
    //      for (int z = y; z <= d; z++)
    //        sum++;
    
    double tot = 0;

    for (double w = 1; w <= a; w++) {
      for (double x = w; x <= b; x++) {
        double temp = c - x + 1;
        temp *= (c - 2*d + x - 2);
        temp /= 2;
        temp = 0 - temp;
        tot += temp;
      }
    }

    return tot;
  }

  public static double not(double a, double b) {
    //for (int i = 1; i <= a; i++) {
    //  for (int j = i; j <= b; j++) {
    //    tot++;
    //  }
    //}
    
    // implements loop sum above
    double tot = a*(a - 2*b - 1);
    tot /= 2;
    tot = 0 - tot;

    return tot;
  }
}
