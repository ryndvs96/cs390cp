import java.io.*;
import java.util.*;

public class Solution {

  public static void insertionSortPart2(int[] arr)
  {       
    if (arr.length == 1) {
      printArray(arr);
      return;
    }
    for (int i = 1; i < arr.length; i++) {
      
      int c = arr[i];
//      System.out.printf("range: (0 : %d)\n", i - 1);
  //    System.out.printf("searching %d\n", c);

      // find where it belongs
      int j = i;
      for (j = i; j > 0 && c < arr[j - 1]; j--);
    //  System.out.printf("found spot %d\n", j);

      // readjust
      for (; j <= i; j++) {
        int temp = arr[j];
        arr[j] = c;
        c = temp;

      }
      printArray(arr);

    }
  }  



  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();
    int[] ar = new int[s];
    for(int i=0;i<s;i++){
      ar[i]=in.nextInt(); 

    }
    insertionSortPart2(ar);    


  }    
  private static void printArray(int[] ar) {
    for(int n: ar){
      System.out.print(n+" ");

    }
    System.out.println("");

  }

}

