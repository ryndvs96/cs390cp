import java.io.*;
import java.util.*;

public class Solution1 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int[] arr = new int[N];
    int tot = 0;
    for (int i = 0; i < N; i++) 
      arr[i] = scan.nextInt();
    
    int Q = scan.nextInt();
    int w = 0;
    for (int k = 0; k < Q; k++) {
      w += scan.nextInt();
      long temp = 0;
      for (int i = 0; i < arr.length; i++) {
        int x = arr[i] + w;
        temp += x >= 0 ? x : -x;
      } 
      System.out.println(temp);
    }
    scan.close();
  }
}
