package stack;

/**
 * 基于链表实现的栈。
 * <p>
 * Author: Zheng
 */
public class StackBasedOnLinkedList {
    private Node top = null;
    /* 入栈
     */
    public void push(int value) {
        Node newNode = new Node(value, null);
        // 判断是否栈空
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    /**
     * 我用-1表示栈中没有数据。  出栈
     */
    public int pop() {
        if (top == null) return -1;
        int value = top.data;
        top = top.next;
        return value;
    }




    //节点
    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }


    public static void main(String[] args) {
        StackBasedOnLinkedList stackbasedonlinkedlist=new StackBasedOnLinkedList();
        stackbasedonlinkedlist.push(1);
        stackbasedonlinkedlist.push(2);
        stackbasedonlinkedlist.push(3);
        stackbasedonlinkedlist.push(4);
        stackbasedonlinkedlist.push(5);
        Node p=  stackbasedonlinkedlist.top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }


}
