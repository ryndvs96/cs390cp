import java.util.*;
import java.io.*;

public class TestMaker {
  public static void main(String[] args) {
    int n = 100000;
    int m = 90000;
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = ((int) (Math.random() * (double) 1000000));
    }
    System.out.printf("%d %d\n%s\n", n, m, toString(arr));

  }
  public static String toString(int[] arr) {
    String str = "";
    for (int i = 0; i < arr.length; i++) {
      str += arr[i] + " ";
    }
    return str;
  }
}
