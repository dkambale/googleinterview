package array;

public class Permutation {

  public static void main(String[] args) {
    String str = "ABC";
    int n = str.length();
    Permutation permutation = new Permutation();
    permutation.permute(str, 0, n - 1);
  }

  private void permute(String str, int l, int h) {

    if (l == h) {
      System.out.println(str);
    } else {
      for (int i = l; i <= h; i++) {
        str = swap(str, l, i);
        permute(str, l + 1, h);
        str = swap(str, l, i);
      }
    }
  }

  private String swap(String str, int l, int i) {

    char[] chars = str.toCharArray();
    char tmp = chars[l];
    chars[l] = chars[i];
    chars[i] = tmp;
    return String.valueOf(chars);
  }
}
