/**
 * MergeSort algorithm.
 * @Author Daniel Wikander
 */
public class MergeSort {

    private static int[] tempArray;

    public static int[] sort(int[] a) {
        tempArray = new int[a.length];
        sort(a, 0, a.length - 1);
        return a;
    }

    public static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {               // if hi < lo the array is already sorted
            return;
        }
        int mid = lo + (hi - lo) / 2; // Sets midpoint
        sort(a, lo, mid);             // Sorts left side of array
        sort(a, mid + 1, hi);     // Sorts right side of array
        merge(a, lo, mid, hi);       // Merge both sides of the array
    }

    public static void merge(int[] a, int lo, int mid, int hi) {
        int i = lo;         // Index for left side of array.
        int j = mid + 1;    // Index for right side of array

        for (int k = lo; k <= hi; k++) { // Copies array
            tempArray[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) { // Traverse lo-hi
            if (i > mid) {               // If left side has been iterated
                a[k] = tempArray[j];     //
                j++;
            } else if (j > hi) {         // If right side has been iterated
                a[k] = tempArray[i];
                i++;
            } else if (tempArray[j] < tempArray[i]) { // If the left value is the greatest
                a[k] = tempArray[j];     // Take value from the right side
                j++;
            } else {                     // If the right value is the greatest
                a[k] = tempArray[i];     // Take the value from the left side.
                i++;
            }
        }
    }
}
