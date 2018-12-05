public class MergeSort {

    private static int[] tempArray;

    public static int[] sort(int[] a) {
        tempArray = new int[a.length];
        sort(a, 0, a.length - 1);
        return a;
    }

    public static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) { // Om hi inte är större än lo så är arrayen redan sorterad.
            return;
        }
        int mid = lo + (hi - lo) / 2; // Sätter mittpunkten
        sort(a, lo, mid);             // Sortera vänstra sidan av arrayen.
        sort(a, mid + 1, hi);     // Sortera högra sidan av arrayen.
        merge(a, lo, mid, hi);       // Mergea ihop sidorna.
    }

    public static void merge(int[] a, int lo, int mid, int hi) {
        int i = lo;         // Index för vänstra sidan av arrayen.
        int j = mid + 1;    // Index för högra sidan av arrayen.

        for (int k = lo; k <= hi; k++) { // Kopiera array
            tempArray[k] = a[k];
        }

        // Iterera lo - hi och jämför de två sidorna av arrayen.
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {           // Om hela vänstra delen har itererats
                a[k] = tempArray[j];
                j++;
            } else if (j > hi) {     // Om hela högra delen har itererats
                a[k] = tempArray[i];
                i++;
            } else if (tempArray[j] < tempArray[i]) { // Om det vänstra värdet är störst
                a[k] = tempArray[j];
                j++;
            } else {                 // Om det högra värdet är störst
                a[k] = tempArray[i];
                i++;
            }
        }
    }
}
