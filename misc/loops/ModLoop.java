public class ModLoop {
  public static void main(String[] args) {
    int N = 20;
    int M = 10;
    int tot = 0;
    for (int i = 2; i < M; i++) {
      for (int j = 1; j < N; j++) {
        int sum = 0;
        for (int k = 0; k < (j % i); k++) {
          sum++;
        }
        tot += sum;
        System.out.printf("i = %d\tj = %d\tsum = %d\ttot = %d\n", i,j,sum,tot);
      }
    }
  }
}
