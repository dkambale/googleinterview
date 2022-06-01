package array;

public class ArrayRotatte {

  public static void main(String[] args) {

    int arr[] = { 1, 2, 3, 4, 5, 6, 7 };

    int d=2;
    for(int i=0;i<d;i++) {
      int tmp=arr[0];
      for(int j=0;j<arr.length-1;j++) {
        arr[j]=arr[j+1];
      }
      arr[arr.length-1]=tmp;
    }

    for(int i=0;i<arr.length;i++) {
      System.out.print(" "+arr[i]);
    }
    int[] tmp=new int[2];
    for(int i=0;i<d;i++) {
      tmp[i]=arr[i];
    }
    int i=0;
    int size=arr.length;
    while(i<(size-d)) {
      arr[i]=arr[i+d];
      i++;
    }
    for(int j=0;j<tmp.length;j++) {
      arr[i]=tmp[j];
      i++;
    }
    System.out.print("==============");
    for(int k=0;k<arr.length;k++) {
      System.out.print(" "+arr[k]);
    }

  }


}
