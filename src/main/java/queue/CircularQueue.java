package queue;

/**
 * 循环队列 作用在于避免数据搬移
 *    关键是  入队 获取下个下标的位置  (tail + 1) % n;
 *           出队 获取下个下标的位置  (head + 1) % n;
 */
public class CircularQueue {
  // 数组：items，数组大小：n
  private String[] items;
  private int n = 0;
  // head表示队头下标，tail表示队尾下标
  private int head = 0;
  private int tail = 0;

  // 申请一个大小为capacity的数组
  public CircularQueue(int capacity) {
    items = new String[capacity];
    n = capacity;
  }

  // 入队
  public boolean enqueue(String item) {
    // 队列满了   当队满时，(tail+1)%n=head
    if ((tail + 1) % n == head) return false;
    items[tail] = item;
    //获取下个下标的位置
    tail = (tail + 1) % n;
    return true;
  }

  // 出队
  public String dequeue() {
    // 如果head == tail 表示队列为空
    if (head == tail) return null;
    String ret = items[head];
    //获取下个下标的位置
    head = (head + 1) % n;
    return ret;
  }

  public void printAll() {
    if (0 == n) return;
    for (int i = head; i % n != tail; i = (i + 1) % n) {
      System.out.print(items[i] + " ");
    }
    System.out.println();
  }
}
