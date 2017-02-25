public class Solution {
  public static void main(String[] args) {
    int x = 1000;
    int[][] adj = new int[][]{
        {0, 2, 2, x},
        {1, 0, x, 2},
        {x, x, 0, x},
        {4, x, 2, 0}
    };

    int n = 4;
    int[][][] dp = new int[n][n][2];
    int t = 0;
    int f = 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) {
          dp[i][j][t] = 0;
          dp[i][j][f] = 0;
        } else {
          dp[i][j][f] = adj[i][j];
          dp[i][j][t] = adj[j][i];
        }
      }
    }
    print(dp);

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (i == j)
            continue;
          dp[i][j][f] = Math.min(
              dp[i][j][f], 
              dp[i][k][f] + dp[k][j][f]
              );
          dp[i][j][t] = Math.min(
              dp[i][j][t],
              Math.min(
                dp[i][j][f],
                Math.min(
                  dp[i][k][t] + dp[k][j][f],
                  dp[i][k][f] + dp[k][j][t]
                  )
                )
              );
        }
      }
      System.out.println("k = " + k);
      print(dp);
    }
    print(dp);
  
  }

  public static void print(int[][][] dp) {
    System.out.println("printing---");
    // print
    int n = 4;
    for (int k = 0; k < 2; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          System.out.printf("%4d ", dp[i][j][k]);
        }
        System.out.println();
      }
      System.out.println();
    }
  }
}
