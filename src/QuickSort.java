public class QuickSort {

    static int[] sort(int[] a) {
        // Shuffles array
        MyInsertionTest.shuffle(a, 0, a.length -1);
        int lo = 0;
        int hi = a.length -1;
        sort(a, lo, hi);
        return a;
    }

    static int[] sort(int[] a, int lo, int hi) {
        // If lo > hi then a is already sorted
        if (lo < hi) {
            int p = a[lo];
            int i = lo;
            int j = hi+1;


            while(i < hi && a[i] < p) {
                i++;

            }
        }
        return a;
    }

    static void merge(int[]a, int lo, int mid, int hi) {

        // Copies lo - hi to new array
        int[] middleManArray = new int[a.length];
        for (int i = lo; i < hi; i++) {
            middleManArray[i] = a[i];
        }

        int i = lo;
        int j = mid + 1;
        int k = lo;
        // Merges by taking the lowest value of i or j (left or right side)
        // and places in k
        while (i <= mid && j <= hi) {
            if (middleManArray[i] <= middleManArray[j]) {
                a[k] = middleManArray[i];
                i++;
            } else {
                a[k] = middleManArray[j];
                j++;
            }
            k++;
        }
        // TODO: Comment?
        // Copy the rest of the left side of the array into the target array
        while (i <= mid) {
            a[k] = middleManArray[i];
            k++;
            i++;
        }
        // TODO: Comment?
        // Since we are sorting in-place any leftover elements from the right side
        // are already at the right position.


        // TODO: Varför fungerar inte nedanstående kod, men koden ovan funkar?
        // Sorts by taking the lowest value of i or j and places in k
       /* for (int k = lo, i = lo, j = mid + 1; k < hi; k++) {
            if (i > mid) {
                a[k] = middleManArray[j];
                j++;
            } else if (j > hi) {
                a[k] = middleManArray[i];
                i++;
            } else if (a[j] < a[i]) {
                a[k] = middleManArray[j];
                j++;
            } else {
                a[k] = middleManArray[i];
                i++;
            }
        } */
    }
}

