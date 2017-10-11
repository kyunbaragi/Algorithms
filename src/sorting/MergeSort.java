package sorting;

public class MergeSort {
    public static void sort(int[] arr, int low, int high) {
        int[] copy = new int[arr.length];

        if (low < high) {
            int middle = (low + high) / 2;
            sort(arr, low, middle);
            sort(arr, middle + 1, high);
            merge(arr, copy, low, middle, high);
        }
    }

    private static void merge(int[] arr, int[] copy, int low, int middle, int high) {
        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            copy[i] = arr[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (copy[i] <= copy[j]) {
                arr[k] = copy[i];
                i++;
            } else {
                arr[k] = copy[j];
                j++;
            }

            k++;
        }

        // Copy the rest of the left side of the array into the target array
        /*if (i <= middle) {
            System.out.println("Left");
        } else if (j <= high) {
            System.out.println("Right");
        }*/

        while (i <= middle) {
            arr[k] = copy[i];
            k++;
            i++;
        }

        while (j <= high) {
            arr[k] = copy[j];
            k++;
            j++;
        }

        // Since we are sorting in-place any leftover elements from the right side
        // are already at the right position.
    }
}
