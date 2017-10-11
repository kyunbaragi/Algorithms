package structure.heap;

import java.util.Arrays;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    private static final int FRONT = 1;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[this.maxSize + 1];
        heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos) {
        return (pos / 2);
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }

        return false;
    }

    private void swap(int pos1, int pos2) {
        int tmp;
        tmp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = tmp;
    }

    private void maxHeapify(int pos) {
        if (!isLeaf(pos)) {
            // TODO: Must check whether the right child exists.
            if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
                if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element) {
        heap[++size] = element;
        int current = size;

        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print("PARENT : " + heap[i]);

            if(rightChild(i) <= size) {
                System.out.print(" LEFT CHILD : " + heap[2 * i] + " RIGHT CHILD :" + heap[2 * i + 1]);
            } else {
                System.out.print(" LEFT CHILD : " + heap[2 * i]);
            }

            System.out.println();
        }
    }

    public void maxHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            maxHeapify(pos);
        }
    }

    public int remove() {
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        maxHeapify(FRONT);
        return popped;
    }
}
