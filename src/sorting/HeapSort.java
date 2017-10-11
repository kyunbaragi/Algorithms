package sorting;

import structure.heap.MaxHeap;

import java.util.Arrays;

public class HeapSort {
    public static void sort(int[] arr) {
        int size = arr.length;
        MaxHeap maxHeap = new MaxHeap(size);

        for (int i = 0; i < size; i++) {
            maxHeap.insert(arr[i]);
        }

        for (int i = size - 1; i >= 0; i--) {
            arr[i] = maxHeap.remove();
        }
    }

    public static void main(String[] args) {
        int[] arr = {100, 2, 34, 5, 19, 1, 30, 43, 26, 17};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
