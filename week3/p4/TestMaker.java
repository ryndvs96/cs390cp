import java.util.*;
import java.io.*;

public class TestMaker {
  public static void main(String[] args) {
    int N = 500000;
    int Q = 500000;
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = (int) (Math.random() * 4000d) - 2000;
    }
    int[] qs = new int[Q];
    for (int i = 0; i < Q; i++) {
      qs[i] = (int) (Math.random() * 4000d) - 2000;
    }
    System.out.println(N);
    for (int i : arr)
      System.out.print(i + " ");
    System.out.println();
    System.out.println(Q);
    for (int i : qs)
      System.out.print(i + " ");
    System.out.println();
  }
}
