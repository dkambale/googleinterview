package array;

public class FindInSortedAndSortedArray {
  // time complexity O(log n)
  public static void main(String[] args) {
    int a[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
    int key=11;
    int pivot=0;
    for(int i=0;i<a.length-1;i++) {
      if(a[i]>a[i+1]) {
        pivot=i;
        break;
      }
    }
    int found=-1;
    if(a[pivot]==key) {
      System.out.print("found");
      found=pivot;
    } else {
      if(a[pivot]>key) {
       found= binarySearch(a,0,pivot,key);
      } else {
        found=binarySearch(a,pivot+1,a.length-1,key);
      }
    }
    System.out.print("found:"+found);

  }

  public static int binarySearch(int a[],int start,int end,int key) {

    if(start>end) {
      return -1;
    }
    int mid=(start+end)/2;
    if(a[mid]==key) {
      return mid;
    }
    if(a[mid]>key) {
     return binarySearch(a,start,mid,key);
    } else {
      return binarySearch(a,mid+1,end,key);
    }
  }
}
