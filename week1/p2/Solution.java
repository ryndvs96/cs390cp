import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int tests = scan.nextInt();
    for (int i = 0; i < tests; i++) {
      ArrayList<String> top = new ArrayList<String>();
      int max = Integer.MIN_VALUE;
      for (int j = 0; j < 10; j++) {
        String str = scan.next();
        int score = scan.nextInt();
        if (score > max) {
          //System.out.println("clearing...\nadding... " + str);
          top.clear();
          top.add(str);
          max = score;
        } else if (score == max) {
          //System.out.println("adding... " + str);
          top.add(str);
        }
      }
      System.out.printf("Case #%d:\n", i+1);
      for (String str : top)
        System.out.println(str);   
    }
  }
}
