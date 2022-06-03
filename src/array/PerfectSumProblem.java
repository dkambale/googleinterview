package array;

public class PerfectSumProblem {

  // time complexcity 2^n
  private static int count;
  private static int n;
  private static int sum;

  public static void main(String[] args) {
    // expected output 3 i.e. {2,3,5} {2,8} {10}

    count = 0;
    n = 6;
    sum = 10;
    int[] pat = {2, 3, 5, 6, 8, 10};

    print(pat, 0, 0, 0);

    System.out.println(count);
  }

  private static void print(int[] pat, int c, int s, int i) {

    if (s == sum) {
      count++;
    } else {
      if (s < sum && i < n) {
        print(pat, c, s + pat[i], i + 1);
        print(pat, c, s, i + 1);
      }
    }
  }
}
