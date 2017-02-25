import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int lines = scan.nextInt();
    for (int i = 0; i < lines; i++) {
      int nums = scan.nextInt();
      int sum = 0;
      for (int j = 0; j < nums; j++) {
        sum += scan.nextInt();
      }
      System.out.println(sum);
    }    
  }
}

