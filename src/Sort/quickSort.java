package Sort;

/**
 * 结合了三数取中加荷兰旗解决思路
 * 实现了随机快排和大量重复相等数据的高效快排
 */
public class quickSort {
    public static void swap(int[] arr, int i, int j) {
        //自己异或自己会导致为0。
        if (i != j) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }

    /**
     * 三数取中值，其中中值放在倒数第二个。
     * A.....B......C变成1........23。
     *
     * @param arr
     */
    public static void dealPivot(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        if (arr[left] > arr[mid]) {
            swap(arr, left, mid);
        }
        if (arr[mid] > arr[right]) {
            swap(arr, mid, right);
        }
        if (arr[left] > arr[mid]) {
            swap(arr, left, mid);
        }
        swap(arr, mid, right - 1);
    }

    public static int[] Sort(int[] arr, int left, int right) {

        int less = left - 1;
        int cur = left;
        int more = right - 1;
        dealPivot(arr,left,right);
        int Pivot = arr[more];
        while (cur < more) {
            if (arr[cur] < Pivot) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] == Pivot) {
                cur++;
            } else {
                swap(arr, --more, cur);
            }
        }
        //交换，此时more的范围减一，因为移出的是Pivot，所以是减少一个more区域。
        swap(arr, more++, right - 1);
        //返回less区域结束位置和more区域开始位置。
        return new int[]{less, more};
    }

    /**
     * @param arr
     * @param left   数组起始下标
     * @param right   数组结束下标
     */
    public static void QuickSort(int[] arr, int left, int right) {
//        int i = r - l;
//        swap(arr, (int) (Math.random() * i), i);
        if (left < right) {
            int[] ll = Sort(arr, left, right);
            QuickSort(arr, left, ll[0]);
            QuickSort(arr, ll[1], right);
        }
    }

    public static void main(String[] args) {
        int[] test = new int[10];
        for (int i = 0; i < 10; i++) {
            test[i] = (int) (Math.random() * 100);
        }
        QuickSort(test, 0, test.length - 1);
        for (int i : test) {
            System.out.println(i);
        }
    }
}
