package lab06.analyzers;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GeneralizedMergeSortAnalyzer extends SortAnalyzer {

    public GeneralizedMergeSortAnalyzer(int k) {
        this.k = k;
    }
    
    @Override
    public Comparable[] sort(Comparable[] arr) {
        return mergeSort(arr, arr.length);
    }
    
    private Comparable[] mergeSort(Comparable[] arr, int size) {
        //base case
        if (size == 1) {
            return arr;
        }

        if (size < k) {
            GeneralizedMergeSortAnalyzer gmsa = new GeneralizedMergeSortAnalyzer(size);
            return gmsa.mergeSort(arr, size);
        }

        Comparable[][] arrays = new Comparable[k][];
        int divisionSize = size / k;
        int divider = 0;
        for (int count = 0; count < k - 1; count++) {
            arrays[count] = mergeSort(Arrays.copyOfRange(arr, divider, divider += divisionSize), divisionSize);
        }
        arrays[k - 1] = mergeSort(Arrays.copyOfRange(arr, divider, size), size - divider); // this ensures to get all arrays
        Comparable[] result = new Comparable[size];
        int[] indexes = new int[k];
        int start = 0;
        for (int i = 0; i < size; i++) {
            if (indexes[start] == arrays[start].length) {
                start++;
                i--;
            }
            else {
                int[] comparisons = new int[k];
                for (int j = start; j < k; j++) {
                    if (indexes[j] == arrays[j].length) {
                        comparisons[j] = Integer.MIN_VALUE;
                    }
                    else {
                        comparisons[j] = compare(arrays[start][indexes[start]], arrays[j][indexes[j]]);
                    }
                }
                int index = indexOfMax(comparisons, start);
                result[i] = arrays[index][indexes[index]];
                indexes[index]++;
            }           
        }
        return result;
    }

    private int indexOfMax(int[] arr, int start) {
        int maxIndex = start;
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex])
                maxIndex = i;
        }
        return maxIndex;
    }
    
}
