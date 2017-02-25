import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scan.nextInt();

    System.out.println((new Solution()).maxArea(arr));
  }
  
  public int maxArea(int[] height) {
    int max = convert(height);

//    for (int i = 0; i < height.length; i++) {
//      System.out.print("" + height[i] + " ");
//    }
//    System.out.println();
    
    return solve(height, max);

  }

  public int solve(int[] arr, int hm) {
    int i = 0, j = arr.length - 1;
    for (; i < arr.length && arr[i] != hm; i++);
    for (; j > i && arr[j] != hm; j--);

    int height = hm;
    int max = (j - i) * height;

    while (i >= 0 || j < arr.length) {

      for (; i > 0 && arr[i - 1] == height; i--);
      for (; j < (arr.length -1 ) && arr[j + 1] == height; j++);

  //    System.out.printf("range [%d, %d] and height %d\n", i, j, height);

      max = Math.max(max, (j - i) * height);


      if (i > 0 && j < arr.length - 1) {
        if (arr[i - 1] >= arr[j + 1]) {
          i--;
          height = arr[i];

        } else {
          j++;
          height = arr[j];

        }

      } else if (i > 0) {
        i--;
        height = arr[i];

      } else if (j < arr.length - 1) {
        j++;
        height = arr[j];

      } else {
        break;

      }

    }

    return max;

  }

  public int convert(int[] arr) {
    int count = 0;
    boolean good = false;
    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == max1) {
        good = true;

      } else if (arr[i] > max1) {
        max2 = max1;
        max1 = arr[i];
        good = false;

      } else if (arr[i] > max2) {
        max2 = arr[i];

      }

    }
    int max = good ? max1 : max2;

    int curr = Integer.MIN_VALUE;
    int i = 0;
    for (; i < arr.length; i++) {
      if (arr[i] >= max) {
        arr[i] = max;
        break;

      } else if (arr[i] > curr) {
        curr = arr[i];

      } else if (arr[i] <= curr) {
        arr[i] = curr;

      }

    }

    curr = Integer.MIN_VALUE;
    int j = arr.length - 1;
    for (; j > i; j--) {
      if (arr[j] >= max) {
        arr[j] = max;
        break;

      } else if (arr[j] > curr) {
        curr = arr[j];

      } else if (arr[j] <= curr) {
        arr[j] = curr;

      }

    }

    for (; i != j; i++)
      arr[i] = max;

    return max;

  }

}
