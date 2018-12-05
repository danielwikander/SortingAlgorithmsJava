public class QuickSort2b {

    static int[] sort(int[] a) {
        MyInsertionTest.shuffle(a, 0, a.length - 1); // Shuffle array
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);
        return a;
    }

    static int[] sort(int[] a, int lo, int hi) {
        if (lo < hi) { // Om lo > hi så är a redan sorterad
            quicksort(a, lo, hi);
        }
        return a;
    }

    static void quicksort(int[] a, int lo, int hi) {
        int pivot = a[lo]; // Fastställer pivotpunkten
        int i = lo;
        int j = hi;
        while (i <= j) {   // Räkna upp i och räkna ner j tills de möts

            while (i < hi && a[i] < pivot) { // Iterera tills a[i] är större än pivot
                i++;
            }

            while (a[j] > pivot) {           // Iterera tills a[j] är mindre än pivot
                j--;
            }

            if (i <= j) {  // Byt plats på a[i] och a[j] om i är mindre än j.
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        sort(a, lo, j); // Sortera vänstra sidan av pivotpunkten rekursivt
        sort(a, i, hi); // Sortera högra sidan av pivotpunkten rekursivt
    }
}

