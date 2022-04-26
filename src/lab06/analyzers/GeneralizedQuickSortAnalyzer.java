package lab06.analyzers;

import java.util.ArrayList;
import java.util.Arrays;

public class GeneralizedQuickSortAnalyzer extends SortAnalyzer {

    public GeneralizedQuickSortAnalyzer (int k) {
        this.k = k;
    }
    
    @Override
    public Comparable[] sort(Comparable[] arr) {
        ArrayList<Comparable> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return quickSort(list);
    }

    private Comparable[] quickSort(ArrayList<Comparable> list) {
        // base case
        if (list.size() < 2) {
            Comparable[] result = new Comparable[list.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = list.get(i);
            }
            return result;
        }

        else if (list.size() < k) {
            GeneralizedQuickSortAnalyzer gqsa = new GeneralizedQuickSortAnalyzer(list.size());
            return gqsa.quickSort(list);
        }

        // general case
        int[] pivotIndexes = new int[k - 1];
        setArray(pivotIndexes, -1);
        for (int i = 0; i < pivotIndexes.length; i++) {
            int rnd = (int) (Math.random() * list.size());
            if (contains(pivotIndexes, rnd)) {
                i--;
            }
            else {
                pivotIndexes[i] = rnd;
            }
        }

        Comparable[] pivots = new Comparable[k - 1];
        for (int j = 0; j < pivots.length; j++) {
            pivots[j] = list.get(pivotIndexes[j]);
        }
        pivots = sort(pivots);

        ArrayList<Comparable>[] sublists = new ArrayList[k];
        for (int i = 0; i < sublists.length; i++) {
            sublists[i] = new ArrayList<>();
        }

        for (int i = 0; i < list.size(); i++) {
            Comparable cur = list.get(i);
            int j = indexOf(pivots, cur);
            if (j == -1) {
                int m = 0;
                while (m < k - 1 && compare(cur, pivots[m]) > 0) {
                    m++;
                }
                sublists[m].add(cur);
            }
        }

        Comparable[][] sortedSublists = new Comparable[k][];
        for (int i = 0; i < sortedSublists.length; i++) {
            sortedSublists[i] = quickSort(sublists[i]);
        }

        Comparable[] result = new Comparable[list.size()];
        int index = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < sortedSublists[i].length; j++) {
                result[index++] = sortedSublists[i][j];
            }
            if (i != pivots.length) {
                result[index++] = pivots[i];
            }
        }

        return result;

    }

    private boolean contains(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return true;
            }
        }
        return false;
    }

    private int indexOf(Comparable[] arr, Comparable val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }

    private void setArray(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = val;
        }
    }
    
}
