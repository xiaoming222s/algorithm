package queue;

import org.junit.Test;

/**
 *
 *当 tail 移动到最右边，即使数组中还有空闲空间，也无法继续往队列中添加数据了。
 */
// 用数组实现的队列  顺序队列
public class ArrayQueue {
    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队
    public boolean enqueue(String item) {
        // 如果tail == n 表示队列已经满了
        if (tail == n) return false;
        items[tail] = item;
        ++tail;
        return true;
    }

    // 出队
    public String dequeue() {
        // 如果head == tail 表示队列为空
        if (head == tail) return null;
        // 为了让其他语言的同学看的更加明确，把--操作放到单独一行来写了
        String ret = items[head];
        ++head;
        return ret;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue("1111");
        arrayQueue.enqueue("2222");
        arrayQueue.enqueue("3333");
        arrayQueue.enqueue("4444");
        arrayQueue.enqueue("5555");
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.enqueue("6666");
        arrayQueue.enqueue("7777");
        arrayQueue.enqueue("8888");
        arrayQueue.enqueue("9999");
        for (int i = arrayQueue.head; i < arrayQueue.tail; ++i) {
            System.out.print(arrayQueue.items[i] + " ");
        }
    }

}
