package sorts;

/**
 *
 * 归并排序
 *
 * 我们申请一个临时数组 tmp，大小与 A[p…r] 相同。
 * 我们用两个游标 i 和 j，分别指向 A[p…q] 和 A[q+1…r] 的第一个元素。
 * 比较这两个元素 A[i] 和 A[j]，如果 A[i]<=A[j]，我们就把 A[i] 放入到临时数组 tmp，
 * 并且 i 后移一位，否则将 A[j] 放入到数组tmp，j 后移一位。
 * 继续上述比较过程，直到其中一个子数组中的所有数据都放入临时数组中，再把另一个数组
 * 中的数据依次加入到临时数组的末尾，这个时候，临时数组中存储的就是两个子数组合并之
 * 后的结果了。最后再把临时数组 tmp 中的数据拷贝到原数组 A[p…r] 中。
 * 我们
 *
 *
 */
public class MergeSort {

  // 归并排序算法, a是数组，n表示数组大小
  public static void mergeSort(int[] a, int n) {
    mergeSortInternally(a, 0, n-1);
  }

    /**
     * 递归调用函数
     *  p 起始点
     *  r 终止点
    */
  private static void mergeSortInternally(int[] a, int p, int r) {
    // 递归终止条件
    if (p >= r) return;

    // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
    int q = p + (r - p)/2;
    // 分治递归
    mergeSortInternally(a, p, q);
    mergeSortInternally(a, q+1, r);

    // 将A[p...q]和A[q+1...r]合并为A[p...r]
    merge(a, p, q, r);
  }

  private static void merge(int[] a, int p, int q, int r) {
    // 初始化变量i, j, k  ; 我们用两个游标 i 和 j，分别指向 A[p…q] 和 A[q+1…r] 的第一个元素。
    int i = p;
    int j = q+1;
    int k = 0;
    // 申请一个大小跟a[p...r]一样的临时数组
    int[] tmp = new int[r-p+1];
    //直到其中一个子数组中的所有数据都放入临时数组中
    while (i<=q && j<=r) {
      if (a[i] <= a[j]) {
        tmp[k++] = a[i++]; // i++等于i:=i+1
      } else {
        tmp[k++] = a[j++];
      }
    }

    // 判断哪个子数组中有剩余的数据   i q是前面的数组   j r是后面的数组
    int start = i;
    int end = q;
    if (j <= r) {
      start = j;
      end = r;
    }

    // 将剩余的数据拷贝到临时数组tmp
    while (start <= end) {
      tmp[k++] = a[start++];
    }

    // 将tmp中的数组拷贝回a[p...r]
    for (i = 0; i <= r-p; ++i) {
      a[p+i] = tmp[i];
    }
  }

  /**
   * 合并(哨兵)
   *
   * @param arr
   * @param p
   * @param q
   * @param r
   */
  private static void mergeBySentry(int[] arr, int p, int q, int r) {
    int[] leftArr = new int[q - p + 2];
    int[] rightArr = new int[r - q + 1];

    for (int i = 0; i <= q - p; i++) {
      leftArr[i] = arr[p + i];
    }
    // 第一个数组添加哨兵（最大值）
    leftArr[q - p + 1] = Integer.MAX_VALUE;

    for (int i = 0; i < r - q; i++) {
      rightArr[i] = arr[q + 1 + i];
    }
    // 第二个数组添加哨兵（最大值）
    rightArr[r-q] = Integer.MAX_VALUE;

    int i = 0;
    int j = 0;
    int k = p;
    while (k <= r) {
      // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
      if (leftArr[i] <= rightArr[j]) {
        arr[k++] = leftArr[i++];
      } else {
        arr[k++] = rightArr[j++];
      }
    }
  }

    /**
     */
    public static class KthSmallest {

        public static int kthSmallest(int[] arr, int k) {
            if (arr == null || arr.length < k) {
                return -1;
            }

            int partition = partition(arr, 0, arr.length - 1);
            while (partition + 1 != k) {
                if (partition + 1 < k) {
                    partition = partition(arr, partition + 1, arr.length - 1);
                } else {
                    partition = partition(arr, 0, partition - 1);
                }
            }

            return arr[partition];
        }

        private static int partition(int[] arr, int p, int r) {
            int pivot = arr[r];

            int i = p;
            for (int j = p; j < r; j++) {
                // 这里要是 <= ，不然会出现死循环，比如查找数组 [1,1,2] 的第二小的元素
                if (arr[j] <= pivot) {
                    swap(arr, i, j);
                    i++;
                }
            }

            swap(arr, i, r);

            return i;
        }

        private static void swap(int[] arr, int i, int j) {
            if (i == j) {
                return;
            }

            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
