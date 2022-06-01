package LinkedList;

public class LinkedListDemo {

  LinkNode head;

  public class LinkNode {

    int data;
    LinkNode next;

    public LinkNode(int data) {
      this.data = data;
      this.next = null;
    }
  }


  public LinkNode setAtFirst(int data) {
    LinkNode dataNode=new LinkNode(data);
    if(head==null) {
      head=dataNode;
      return head;
    }

    dataNode.next=head;
    this.head=dataNode;
    return head;
  }

  public void printList()
  {
    LinkNode tnode = head;
    while (tnode != null) {
      System.out.print(tnode.data + " ");
      tnode = tnode.next;
    }
  }

  // Driver code
  public static void main(String[] args)
  {
    LinkedListDemo llist = new LinkedListDemo();

    llist.setAtFirst(7);
    llist.setAtFirst(1);
    llist.setAtFirst(3);
    llist.setAtFirst(2);
    llist.printList();
  }
}
