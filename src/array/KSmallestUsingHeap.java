package array;

public class KSmallestUsingHeap {
// Time complexity: O(n + kLogn).
  public class Heap {
    int val[];
    int size;

    Heap(int val[],int size) {
      this.size=size;
      this.val=val;
      int j=(size-1)/2;

      for(;j>=0;j--) {

        minHefipy(val,j);
      }
      display();

    }

    public  void display() {

      for (int i=0;i<val.length;i++) {
        System.out.print(" "+val[i]);
      }
      System.out.println();
    }

    private void minHefipy(int[] val, int j) {
      int l=this.left(j);
      int r=this.right(j);
      int smallest=j;
      if(l<size && val[l]<val[j]) {
        smallest=l;
      }
      if(r<size && val[r]<val[smallest]) {
        smallest=r;
      }
      if(j!=smallest) {

        int tmp=val[j];
        val[j]=val[smallest];
        val[smallest]=tmp;
        minHefipy(val,smallest);
      }
    }

    public  int extractMin() {
      if(this.size==1) {

        return val[0];
      }
       if(this.size==0) {
         return 0;
       }
       int min=val[0];
       val[0]=val[size-1];
       size--;
       minHefipy(val,0);
       return min;
    }

    public int left(int i) {
      return i*2+1;
    }
    public int right(int i) {
      return i*2+2;
    }
  }

  public static void main(String[] args) {
    int arr[] = { 12, 3, 5, 7, 19 };
    int n = arr.length, k = 2;
    KSmallestUsingHeap gfg = new KSmallestUsingHeap();
    System.out.print("K'th smallest element is " +
        gfg.kthSmallest(arr, n, k));
  }

  private int kthSmallest(int[] arr, int n, int k) {

    Heap heap=new Heap(arr,n);
    for(int i=0;i<k-1;i++) {
      heap.extractMin();
    }


    return heap.extractMin();
  }
}
