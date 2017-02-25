import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int r = scan.nextInt();
    ArrayList<String> arr = new ArrayList<>();
    for (int i = 0; i < r; i++) {
      arr.add(scan.next().trim());
    }
    System.out.println(solve(null, arr));
  }
  
  public static int solve(String first, ArrayList<String> arr) {
    if (arr.size() == 0) {
      return 0;
    }

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < arr.size(); i++) {
      int x = first == null ? 0 : quicks(first, arr.get(i));
      ArrayList<String> list = (ArrayList<String>) arr.clone();
      String f = list.remove(i);
      x += solve(f, list);
      min = Math.min(min, x);
    }
    return min;
  }

  public static int quicks(String a, String b) {
    int tot = 0;
    for (int i = 0; i < a.length(); i++)
      for (int j = 0; j < b.length(); j++)
        if (a.charAt(i) == b.charAt(j))
          tot++;
    return tot;
  }

}
