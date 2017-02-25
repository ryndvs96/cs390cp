public static class MyScanner {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner scan = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
  }
  BufferedReader br;
  StringTokenizer st;
  public MyScanner() {
    br = new BufferedReader(new InputStreamReader(System.in));
  }
  public boolean hasNext() {
    try {
      boolean a = br.ready();
      return a;
    } catch (IOException e) {
      return false;
    }
  }
  public String next() {
    while (st == null || !st.hasMoreElements()) {
      try {
        st = new StringTokenizer(br.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return st.nextToken();
  }
  public String nextLine() {
    String str = "";
    try {
      str = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return str;
  }
  public int nextInt() { return Integer.parseInt(next()); }
  public long nextLong() { return Long.parseLong(next()); }
  public double nextDouble() { return Double.parseDouble(next()); }
  public char nextChar() { return next().charAt(0); }
}
