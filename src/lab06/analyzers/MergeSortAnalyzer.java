package lab06.analyzers;

import java.util.Arrays;

public class MergeSortAnalyzer extends SortAnalyzer{
    
    @Override
    public Comparable[] sort(Comparable[] arr) {
        return mergeSort(arr, arr.length);
    }
    
    private Comparable[] mergeSort(Comparable[] arr, int size) {
        //base case
        if (size <= 1) {
            return arr;
        }

        int center = size / 2;
        Comparable[] firstHalf  = mergeSort(Arrays.copyOfRange(arr,      0, center), center       );
        Comparable[] secondHalf = mergeSort(Arrays.copyOfRange(arr, center, size  ), size - center);
        Comparable[] result = new Comparable[size];
        int j = 0;
        int m = 0;
        for (int i = 0; i < size; i++) {
            // These two block are to avoid indexOutOfBoundsException
            if (j == firstHalf.length) {
                result[i] = secondHalf[m++];
            }
            else if (m == secondHalf.length) {
                result[i] = firstHalf[j++];
            }

            else if (compare(firstHalf[j], secondHalf[m]) < 0) {
                result[i] = firstHalf[j++];
            }
            else {
                result[i] = secondHalf[m++];
            }
        }
        return result;
    }
    
}
