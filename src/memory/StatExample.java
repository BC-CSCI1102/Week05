public class StatExample {

  public static int g(int k) {
    return k * 2;
  }

  public static int f(int j, int k) {
    return j * g(k);
  }

  public static void main(String[] args) {
    int result = f(2, 3);
    System.out.format("The answer is %d.\n", result);
  }
}


