package sorting;

public class CountingSort {
    public static void sort(int[] arr) {
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }

        int[] range = new int[max + 1];
        for(int i = 0; i < arr.length; i++) {
            range[arr[i]]++;
        }

        for(int i = 1; i < range.length; i++) {
            range[i] += range[i - 1];
        }

        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            result[range[arr[i]] - 1] = arr[i];
            range[arr[i]]--;
        }
    }
}
