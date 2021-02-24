package queue;

/**
 * 基于链表实现的队列  链式队列
 *
 */
public class QueueBasedOnLinkedList {

  // 队列的队首和队尾
  private Node head = null;
  private Node tail = null;

  // 入队
  public void enqueue(String value) {
    if (tail == null) {
      Node newNode = new Node(value, null);
      head = newNode;
      tail = newNode;
    } else {
      tail.next = new Node(value, null);
      tail = tail.next;
    }
  }

  // 出队
  public String dequeue() {
    if (head == null) return null;

    String value = head.data;
    head = head.next;
    if (head == null) {
      tail = null;
    }
    return value;
  }


  private static class Node {
    //数据
    private String data;
    //节点 指针
    private Node next;

    public Node(String data, Node next) {
      this.data = data;
      this.next = next;
    }

    public String getData() {
      return data;
    }
  }



  public static void main(String[] args) {
    QueueBasedOnLinkedList QueueBasedOnLinkedList=new QueueBasedOnLinkedList();
    QueueBasedOnLinkedList.enqueue("1111");
    QueueBasedOnLinkedList.enqueue("2222");
    QueueBasedOnLinkedList.enqueue("3333");
//    QueueBasedOnLinkedList.enqueue("4444");
//    QueueBasedOnLinkedList.enqueue("5555");
//    QueueBasedOnLinkedList.enqueue("6666");
//    QueueBasedOnLinkedList.enqueue("7777");
//    QueueBasedOnLinkedList.enqueue("8888");
//    QueueBasedOnLinkedList.enqueue("9999");
    QueueBasedOnLinkedList.dequeue();
    QueueBasedOnLinkedList.dequeue();
    QueueBasedOnLinkedList.dequeue();
    QueueBasedOnLinkedList.dequeue();
    QueueBasedOnLinkedList.dequeue();
    Node p = QueueBasedOnLinkedList.head;
    while (p != null) {
      System.out.print(p.data + " ");
      p = p.next;
    }
  }

}
