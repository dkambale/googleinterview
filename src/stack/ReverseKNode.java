package stack;

public class ReverseKNode {

  LinkedNode head;

  public class LinkedNode {

    int data;
    LinkedNode next;

    public int getData() {
      return data;
    }

    public void setData(int data) {
      this.data = data;
    }

    public LinkedNode getNext() {
      return next;
    }

    public void setNext(LinkedNode next) {
      this.next = next;
    }
  }

  public void addAtFirst(int data) {
    LinkedNode dataNode = new LinkedNode();
    dataNode.setData(data);
    dataNode.next = head;
    head = dataNode;
  }

  public void printList() {
    LinkedNode cur = head;
    while (cur != null) {
      System.out.print("  " + cur.data);
      cur = cur.next;
    }
  }

  // 1 2 3 4 5 6
  // 3 2 1 6 5 4
  public LinkedNode reversekNode(LinkedNode head, int k) {

    LinkedNode curr = head;
    int i = 0;
    LinkedNode prev = null, next;
    while (curr != null && i < k) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
      i++;
    }
    if(curr!=null) {
      head.setNext(reversekNode(curr,k));
    }
    return prev;

  }

  public static void main(String[] args) {
    ReverseKNode ss=new ReverseKNode();
    for(int i=10;i>0;i--) {
      ss.addAtFirst(i);
    }
    ss.printList();
    System.out.println();
   ss.head= ss.reversekNode(ss.head,3);
    ss.printList();
  }

}
