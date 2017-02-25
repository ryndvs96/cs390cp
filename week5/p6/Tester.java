public class Tester {
  public static void main(String[] args) {
    int n = 1000;
    int m = 1000;
    int q = 100000;
    System.out.printf("%d %d %d\n", n, m, q);
    for (int i = 0; i < q; i++) {
      int c = (int)(4d * Math.random()) + 1;
      int x, y;
      switch (c) {
        case 1:
          x = (int)(((double) n) * Math.random()) + 1;
          y = (int)(((double) m) * Math.random()) + 1;
          System.out.printf("1 %d %d\n", x, y); break;
        case 2:
          x = (int)(((double) n) * Math.random()) + 1;
          y = (int)(((double) m) * Math.random()) + 1;
          System.out.printf("2 %d %d\n", x, y); break;
        case 3:
          x = (int)(((double) n) * Math.random()) + 1;
          System.out.printf("3 %d\n", x); break;
        case 4:
          x = (int)(((double) (i - 1)) * Math.random()) + 1;
          System.out.printf("4 %d\n", x); break;
      }
    }
  }
}
