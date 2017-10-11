package sorting;

import java.util.Arrays;

public class RadixSort {
    private static int getMax(int[] arr, int n) {
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        return max;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    private static void countingSort(int[] arr, int n, int exp) {
        int output[] = new int[n]; // output array
        int count[] = new int[10];

        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    public static void sort(int[] arr, int n) {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countingSort(arr, n, exp);
        }
    }
}
