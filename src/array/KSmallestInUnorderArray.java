package array;

public class KSmallestInUnorderArray {

  // time complexity nlogn
  public static void main(String[] args) {
    Integer arr[] = new Integer[] { 12, 3, 5, 7, 19 };
    int k = 2;
    System.out.println("K'th smallest element is " + kthSmallest(arr, k));
    for(int i=0;i<arr.length;i++) {
      System.out.print(" "+arr[i]);
    }
  }

  private static int kthSmallest(Integer[] arr, int k) {

    sortArrayUsingMerge(arr,0,arr.length-1);
    return arr[k];
  }

  private static void sortArrayUsingMerge(Integer[] arr,int s,int e) {

    if(s<e) {
     int mid=s+(e-s)/2;
     sortArrayUsingMerge(arr,s,mid);
     sortArrayUsingMerge(arr,mid+1,e);
     merge(arr,s,mid,e);

    }
  }

  private static void merge(Integer[] arr, int s, int mid, int e) {
    int n1=mid-s+1;
    int n2=e-mid;
    int a1[]=new int[n1];
    int a2[]=new int[n2];
    for(int i=0;i<n1;i++) {
      a1[i]=arr[s+i];
    }
    for(int j=0;j<n2;j++) {
      a2[j]=arr[mid+j+1];
    }

    int k=s;
    int i=0;
    int j=0;
    while(i<n1 && j<n2) {

      if( a1[i]<=a2[j] ) {
        arr[k]=a1[i];
        i++;
      } else {
        arr[k]=a2[j];
        j++;
      }
      k++;
    }
    if(i<n1) {
      for(;i<n1;i++) {
        arr[k]=a1[i];
        k++;
      }
    }
    if(j<n2) {
      for(;j<n2;j++) {
        arr[k]=a2[j];
        k++;
      }
    }

  }
}
