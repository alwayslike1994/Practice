package Sort;

import static Sort.quickSort.QuickSort;

/**
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，
 * 要求时间复杂度O(N)，且要求不能用非基于比较的排序。
 */
public class MaxGap {
    public static int maxGap(int[] arr) {
        int maxgap = -1;
        int length = arr.length;
        boolean[] notEmpty = new boolean[length + 1];
        int[] min = new int[length + 1];
        int[] max = new int[length + 1];
        notEmpty[0] = notEmpty[length] = true;
        min[0] = Integer.MAX_VALUE;
        max[length] = Integer.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            min[0] = Math.min(arr[i], min[0]);
            max[length] = Math.max(arr[i], max[length]);
        }

        for (int i = 0; i < arr.length; i++) {
            int index = (arr[i] - min[0]) * (length) / (max[length] - min[0]);
            min[index] = notEmpty[index] ? Math.min(min[index], arr[i]) : arr[i];
            max[index] = notEmpty[index] ? Math.max(max[index], arr[i]) : arr[i];
            notEmpty[index] = true;
        }

        int lastMax = max[0];
        for (int i = 1; i < length; i++) {
            if (notEmpty[i]) {
                maxgap = Math.max(maxgap, min[i] - lastMax);
                lastMax = max[i];
            }
        }
        return maxgap;
    }

    public static void main(String[] args) {
        int[] test = new int[10];
        for (int i = 0; i < 10; i++) {
            test[i] = (int) (Math.random() * 100);
            System.out.print(test[i] + ",");
        }
        System.out.println();
        System.out.println("======================================");
        System.out.println(maxGap(test));
        QuickSort(test, 0, 9);
        for (int i = 0; i < 10; i++) {
            System.out.print(test[i] + ",");
        }
    }
}
