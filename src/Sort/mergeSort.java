package Sort;

public class mergeSort {
    public static void MergeSort(int[] arr, int Left, int Right) {
        if (Right > Left) {
            partitionSort(arr, Left, Right);
        }
    }

    /**
     * 归并排序过程
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void partitionSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        //注意位运算一定要打括号，其优先级比+ 、-、*、/要低。
        int mid = left + ((right - left) >> 1);
        partitionSort(arr, left, mid);//T(N/2)
        partitionSort(arr, mid + 1, right);//T(N/2)
        merge(arr, left, right);//O(N)
        //master公式：T(N)=2T(N/2)+O(N);
        //=> log2 2=1 =>O(NlogN)
    }

    /**
     * 合并排序
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void merge(int[] arr, int left, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int mid = left + ((right - left) >> 1);
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            temp[i++] = arr[p1] > arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= right) {
            temp[i++] = arr[p2++];
        }
        while (i > 0) {
            arr[--p2] = temp[--i];
        }
    }

    public static void main(String[] args) {

        int[] test = new int[10];
        for (int i = 0; i < 10; i++) {
            test[i] = (int) (Math.random() * 100);
        }
        //写的partitionSort和MergeSort其实都是归并，
        // 但MergeSort考虑到了不和谐的左右下标（左比右大）
        // partitionSort(test, 0, test.length - 1);
        MergeSort(test, 0, test.length - 1);
        for (int i : test) {
            System.out.print(i + " ");
        }
    }
}
