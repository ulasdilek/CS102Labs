package lab06.analyzers;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSortAnalyzer extends SortAnalyzer{
    
    @Override
    public Comparable[] sort(Comparable[] arr) {
        Comparable[] result = Arrays.copyOf(arr, arr.length);
        quickSort(result, 0, result.length);
        return result;
    }
    
    private void quickSort(Comparable[] list, int start, int end) {
        // base case
        if (end - start <= 1) {
            return;
        }

        // general case
        Comparable temp = list[start];
        int index = start;
        byte fromEnd = 1; // I treat 1 as true and -1 as false, this lets me use it in numerical operations
        int size = end - start - 1;
        while (size > 0) {
            int j = index + (fromEnd * size);

            if (fromEnd * compare(list[j], temp) < 0) {
                swap(list, index, j);
                index = j;
                fromEnd *= -1; // changes state each time there is a swap
            }
            size--;
        }

        quickSort(list, start, index);
        quickSort(list, index + 1, end);

    }

    private void swap(Comparable[] list, int x, int y) {
        Comparable temp = list[x];
        list[x] = list[y];
        list[y] = temp;
    }
    
}
