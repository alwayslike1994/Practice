package Sort;


public class heapSort {
    /**
     * 构建大根堆
     *
     * @param arr
     * @param index 插入的位置
     */
    public static void heapInsert(int[] arr, int index) {
        //插入的元素比父节点大，向上交换，且（index-1）/2考虑了index=0时的情况。
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        //用位运算比较快，相比temp交换方式。两个数互相异或两次就是交换。
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 下沉
     *
     * @param arr
     * @param index    数值改变的地方的数组下标
     * @param heapSize 堆的边界下标
     */
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            //如果有右孩子，且右孩子比较大，最大的为右孩子，记录其下标。否则是其左孩子。
            int largest = left + 1 <= heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            if (arr[largest] > arr[index]) {
                swap(arr, index, largest);
                index = largest;
                left = index * 2 + 1;
            } else {
                break;//如果largest下标比index下标的数还小，或者一样大，那么跳出循环。
            }
        }
    }

    public static void HeapSort(int[] arr) {
        if (arr == null) {
            return;
        }
        //构建大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length - 1;
        //那么当前arr[0]是最大的。
        while (heapSize >= 0) {
            swap(arr, 0, heapSize--);//把最大的放在最后，且heapSize减1
            heapify(arr, 0, heapSize);
        }
    }

    public static void main(String[] args) {

        int[] test = new int[10];
        for (int i = 0; i < 10; i++) {
            test[i] = (int) (Math.random() * 100);
        }
        HeapSort(test);
        for (int i : test) {
            System.out.println(i);
        }
    }

}
