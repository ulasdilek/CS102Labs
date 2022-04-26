package lab06.analyzers;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSortAnalyzer extends SortAnalyzer{
    
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

        // general case
        int pivotIndex = (int) (Math.random() * list.size());
        Comparable pivot = list.get(pivotIndex);
        ArrayList<Comparable> smaller = new ArrayList<>();
        ArrayList<Comparable> greater = new ArrayList<>();
        // System.out.println("List: " + list);
        for (int i = 0; i < list.size(); i++) {
            Comparable cur = list.get(i);
            // System.out.println("size: " + list.size() + ", i: " + i + ", current: " + cur);
            if (cur != pivot) {
                if (compare(pivot, cur) > 0) {
                    smaller.add(cur);
                }
                else {
                    greater.add(cur);
                }
            }
        }
        // System.out.println("Pivot: " + pivot.toString());
        // System.out.println("Smaller: " + smaller);
        // System.out.println("Greater: " + greater);
        Comparable[] sortedSmaller = quickSort(smaller);
        Comparable[] sortedGreater = quickSort(greater);
        Comparable[] result = new Comparable[list.size()];
        for (int i = 0; i < result.length; i++) {
            if (i == sortedSmaller.length) {
                result[i] = pivot;
            }
            else if (i < sortedSmaller.length) {
                result[i] = sortedSmaller[i];
            }
            else {
                result[i] = sortedGreater[i - sortedSmaller.length - 1];
            }
        }
        // System.out.println("result: " + Arrays.toString(result));
        return result;

    }
    
}
