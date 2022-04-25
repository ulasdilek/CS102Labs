package lab06;

import java.util.Arrays;

import lab06.analyzers.*;
import lab06.generators.*;

public class Tester {
    
    public static void main(String[] args) {
        RandomArrayGenerator rag = new RandomArrayGenerator();
        IncreasingArrayGenerator iag = new IncreasingArrayGenerator();
        DecreasingArrayGenerator dag = new DecreasingArrayGenerator();
        Integer[] random = rag.generate(1000);
        Integer[] increasing = iag.generate(1000);
        Integer[] decreasing = dag.generate(1000);
        GeneralizedMergeSortAnalyzer msa1 = new GeneralizedMergeSortAnalyzer(7);
        GeneralizedMergeSortAnalyzer msa2 = new GeneralizedMergeSortAnalyzer(7);
        GeneralizedMergeSortAnalyzer msa3 = new GeneralizedMergeSortAnalyzer(7);
        Comparable[] randomSorted = msa1.sort(random);
        Comparable[] increasingSorted = msa2.sort(increasing);
        Comparable[] decreasingSorted = msa3.sort(decreasing);
        System.out.println();
        System.out.println(Arrays.toString(randomSorted));
        System.out.println(msa1.isSorted(randomSorted));
        System.out.println(msa1.getNumberOfComparisons());
        System.out.println();
        System.out.println(Arrays.toString(increasingSorted));
        System.out.println(msa2.isSorted(increasingSorted));
        System.out.println(msa2.getNumberOfComparisons());
        System.out.println();
        System.out.println(Arrays.toString(decreasingSorted));
        System.out.println(msa3.isSorted(decreasingSorted));
        System.out.println(msa3.getNumberOfComparisons());
    }
    
}
