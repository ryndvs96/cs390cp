import java.io.*;
import java.util.*;

public class Analysis {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int[] arr = new int[N];
    int tot = 0;
    for (int i = 0; i < N; i++) 
      arr[i] = scan.nextInt();

    Arrays.sort(arr);
    scan.nextInt();
    int w = scan.nextInt();
    for (int i = 0; i < N; i++) 
      arr[i] += w;

    int negtot = 0;
    int postot = 0;
    for (int i = 0; i < N; i++) {
      int x = arr[i];
      if (x < 0) {
        negtot += -x;
      } else {
        postot += x;
      }
    } 
    System.out.printf("%d, %d\n", negtot, postot);
    System.out.println(Arrays.toString(arr));

  }
}
