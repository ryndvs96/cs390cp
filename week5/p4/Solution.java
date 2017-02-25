import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int w = scan.nextInt();
    int l = scan.nextInt();
    char[][] arr = new char[l][w];
    for (int i = 0; i < l; i++) {
      //for (int j = 0; j < w; j++) {
        arr[i] = scan.next().trim().toCharArray();
      //}
    }
    solve(w, l, arr);
    for (int i = 0; i < l; i++) {
      System.out.println(new String(arr[i]));
    }
  }

  public static void solve(int w, int l, char[][] arr) {
    int si = 0;
    int sj = 0;
    for (int i = 0; i < l; i++) {
      for (int j = 0; j < w; j++) {
        if (arr[i][j] == '*') {
          si = i;
          sj = j;
          break;
        }
      }
    }

    if (si == 0)
      moveD(si, sj, arr);
    else if (si == arr.length - 1)
      moveU(si, sj, arr);
    else if (sj == 0)
      moveR(si, sj, arr);
    else if (sj == arr[0].length - 1)
      moveL(si, sj, arr);
    return;
  }

  public static void moveL(int pi, int pj, char[][] arr) {
    for (int j = pj - 1; j >= 0; j--) {
      if (arr[pi][j] == '/') {
        moveD(pi, j, arr);
        return;
      } else if (arr[pi][j] == '\\') {
        moveU(pi, j, arr);
        return;
      } else if (arr[pi][j] == 'x') {
        arr[pi][j] = '&';
        return;
      }
    }
    return;
  }
  public static void moveR(int pi, int pj, char[][] arr) {
    for (int j = pj + 1; j < arr[0].length; j++) {
      if (arr[pi][j] == '/') {
        moveU(pi, j, arr);
        return;
      } else if (arr[pi][j] == '\\') {
        moveD(pi, j, arr);
        return;
      } else if (arr[pi][j] == 'x') {
        arr[pi][j] = '&';
        return;
      }
    }
    return;
  }
  public static void moveU(int pi, int pj, char[][] arr) {
    for (int i = pi - 1; i >= 0; i--) {
      if (arr[i][pj] == '/') {
        moveR(i, pj, arr);
        return;
      } else if (arr[i][pj] == '\\') {
        moveL(i, pj, arr);
        return;
      } else if (arr[i][pj] == 'x') {
        arr[i][pj] = '&';
        return;
      }
    }
    return;
  }
  public static void moveD(int pi, int pj, char[][] arr) {
    for (int i = pi + 1; i < arr.length; i++) {
      if (arr[i][pj] == '/') {
        moveL(i, pj, arr);
        return;
      } else if (arr[i][pj] == '\\') {
        moveR(i, pj, arr);
        return;
      } else if (arr[i][pj] == 'x') {
        arr[i][pj] = '&';
        return;
      }
    }
    return;
  }
}
