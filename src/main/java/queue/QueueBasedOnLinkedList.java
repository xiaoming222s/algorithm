package queue;

/**
 * 基于链表实现的队列  链式队列    先出先出 后进后出   入队从队尾入队  出队从队首出队
 */
public class QueueBasedOnLinkedList {

    // 队列的队首和队尾
    private Node head = null;
    private Node tail = null;

    //  入队时，tail->next= new_node, tail = tail->next；
    public void enqueue(String value) {
        if (tail == null) {
            Node newNode = new Node(value, null);
            head = newNode;
            tail = newNode;
        } else {
            //下标指向新的
            tail.next = new Node(value, null);
            //更改队尾标记
            tail = tail.next;
        }
    }

    //   出队时，head = head->next。
    public String dequeue() {
        if (head == null) return null;
        //获取数据
        String value = head.data;
        //更改队首
        head = head.next;
        //置空队首
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
        QueueBasedOnLinkedList QueueBasedOnLinkedList = new QueueBasedOnLinkedList();
//        QueueBasedOnLinkedList.enqueue("1111");
//        QueueBasedOnLinkedList.enqueue("2222");
//        QueueBasedOnLinkedList.enqueue("3333");
//        QueueBasedOnLinkedList.enqueue("4444");
//        QueueBasedOnLinkedList.enqueue("5555");
//        QueueBasedOnLinkedList.enqueue("6666");
//        QueueBasedOnLinkedList.enqueue("7777");
//        QueueBasedOnLinkedList.enqueue("8888");
//        QueueBasedOnLinkedList.enqueue("9999");
//        QueueBasedOnLinkedList.dequeue();
//        QueueBasedOnLinkedList.dequeue();
//        QueueBasedOnLinkedList.dequeue();
//        QueueBasedOnLinkedList.dequeue();
//        QueueBasedOnLinkedList.dequeue();
        //头不等于null
        Node p = QueueBasedOnLinkedList.head;
        p.data="1111";
        p.next=new Node("8888",null);
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
    }

}
