import java.io.*;
import java.util.*;

public class Solution {

  // O(n) solution, everything gets enqueued and dequeued once at most
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int k = scan.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      if (scan.hasNext())
        arr[i] = scan.nextInt();
    scan.close();

    // index of elements
    LinkedList<Integer> d = new LinkedList<>();

    // process first k elements
    int i = 0;
    for (; i < k; i++) {
      while (d.size() > 0 && arr[d.getLast()] <= arr[i])
        d.removeLast();
      d.addLast(i);
    }

    // process rest of them
    for (; i < n; i++) {
      if (d.size() > 0)
        System.out.println(arr[d.getFirst()]);

      // remove ones that are out of bounds
      while (d.size() > 0 && d.getFirst() < i - k + 1)
        d.removeFirst();    

      // add next element where necessary
      while (d.size() > 0 && arr[d.getLast()] <= arr[i])
        d.removeLast();
      d.addLast(i);
    }
    if (d.size() > 0)
      System.out.println(arr[d.getFirst()]);
  }
}
