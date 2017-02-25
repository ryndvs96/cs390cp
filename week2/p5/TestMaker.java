import java.util.*;
import java.io.*;

public class TestMaker {
  public static void main(String[] args) {
    int n = (int) (Math.random() * 1_000_000d) + 1_000;
    int k = (int) (Math.random() * 1_000d);
    System.out.println(n + " " + k);

    for (int i = 0; i < n; i++) {
      System.out.print((int) (Math.random() * 400_000_000d) + " ");
    }
    System.out.println();
  }
}
