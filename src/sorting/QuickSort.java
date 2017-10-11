package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int p = partition(arr, left, right);
            sort(arr, left, p - 1);
            sort(arr, p + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int i = left, j = right;
        int pivot = arr[left];

        // break loop when (i == j)
        while (i < j) {
            while (arr[j] > pivot) {
                j--;
            }

            while (i < j && arr[i] <= pivot) {
                i++;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        arr[left] = arr[i];
        arr[i] = pivot;

        return i;
    }

    public static void main(String[] args) {
        int[] arr = {100, 2, 34, 5, 19, 1, 30, 43, 26, 17};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
