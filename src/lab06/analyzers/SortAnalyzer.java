package lab06.analyzers;

public abstract class SortAnalyzer {
    
    private int numberOfComparisons;
    protected int k;

    public int getNumberOfComparisons() {
        return numberOfComparisons;
    }
    
    protected int compare(Comparable o1, Comparable o2) {
        numberOfComparisons++;
        if (o1 instanceof Integer && o2 instanceof Integer) {
            Integer i1 = (Integer) o1;
            Integer i2 = (Integer) o2;
            return compareInts(i1, i2);
        }
        return o1.compareTo(o2);
    }

    // I had to do this since the implementation of compareTo() in Integer only returns -1, 0 or 1 and not the difference between values
    private int compareInts(Integer i1, Integer i2) {
        return i1 - i2;
    }

    public boolean isSorted(Comparable[] arr) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 1; i < arr.length && (decreasing || increasing); i++) {
            int c = compare(arr[i-1], arr[i]);
            if (c < 0) {
                decreasing = false;
            }
            else if (c > 0) {
                increasing = false;
            }
        }
        return decreasing || increasing;
    }

    public abstract Comparable[] sort(Comparable[] arr);
    
}
