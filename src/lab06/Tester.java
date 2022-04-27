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

        // MergeSortAnalyzer msa1 = new MergeSortAnalyzer();
        // MergeSortAnalyzer msa2 = new MergeSortAnalyzer();
        // MergeSortAnalyzer msa3 = new MergeSortAnalyzer();
        // Comparable[] randomSorted = msa1.sort(random);
        // Comparable[] increasingSorted = msa2.sort(increasing);
        // Comparable[] decreasingSorted = msa3.sort(decreasing);
        // System.out.println();
        // System.out.println(Arrays.toString(randomSorted));
        // System.out.println(msa1.isSorted(randomSorted));
        // System.out.println(msa1.getNumberOfComparisons());
        // System.out.println();
        // System.out.println(Arrays.toString(increasingSorted));
        // System.out.println(msa2.isSorted(increasingSorted));
        // System.out.println(msa2.getNumberOfComparisons());
        // System.out.println();
        // System.out.println(Arrays.toString(decreasingSorted));
        // System.out.println(msa3.isSorted(decreasingSorted));
        // System.out.println(msa3.getNumberOfComparisons());
        
        // GeneralizedMergeSortAnalyzer gmsa1 = new GeneralizedMergeSortAnalyzer(7);
        // GeneralizedMergeSortAnalyzer gmsa2 = new GeneralizedMergeSortAnalyzer(7);
        // GeneralizedMergeSortAnalyzer gmsa3 = new GeneralizedMergeSortAnalyzer(7);
        // Comparable[] randomSorted = gmsa1.sort(random);
        // Comparable[] increasingSorted = gmsa2.sort(increasing);
        // Comparable[] decreasingSorted = gmsa3.sort(decreasing);
        // System.out.println();
        // System.out.println(Arrays.toString(randomSorted));
        // System.out.println(gmsa1.isSorted(randomSorted));
        // System.out.println(gmsa1.getNumberOfComparisons());
        // System.out.println();
        // System.out.println(Arrays.toString(increasingSorted));
        // System.out.println(gmsa2.isSorted(increasingSorted));
        // System.out.println(gmsa2.getNumberOfComparisons());
        // System.out.println();
        // System.out.println(Arrays.toString(decreasingSorted));
        // System.out.println(gmsa3.isSorted(decreasingSorted));
        // System.out.println(gmsa3.getNumberOfComparisons());

        QuickSortAnalyzer qsa1 = new QuickSortAnalyzer();
        QuickSortAnalyzer qsa2 = new QuickSortAnalyzer();
        QuickSortAnalyzer qsa3 = new QuickSortAnalyzer();
        Comparable[] randomSorted = qsa1.sort(random);
        Comparable[] increasingSorted = qsa2.sort(increasing);
        Comparable[] decreasingSorted = qsa3.sort(decreasing);
        System.out.println();
        System.out.println(Arrays.toString(randomSorted));
        System.out.println(qsa1.isSorted(randomSorted));
        System.out.println(qsa1.getNumberOfComparisons());
        System.out.println();
        System.out.println(Arrays.toString(increasingSorted));
        System.out.println(qsa2.isSorted(increasingSorted));
        System.out.println(qsa2.getNumberOfComparisons());
        System.out.println();
        System.out.println(Arrays.toString(decreasingSorted));
        System.out.println(qsa3.isSorted(decreasingSorted));
        System.out.println(qsa3.getNumberOfComparisons());

        // GeneralizedQuickSortAnalyzer gqsa1 = new GeneralizedQuickSortAnalyzer(11);
        // GeneralizedQuickSortAnalyzer gqsa2 = new GeneralizedQuickSortAnalyzer(11);
        // GeneralizedQuickSortAnalyzer gqsa3 = new GeneralizedQuickSortAnalyzer(11);
        // Comparable[] randomSorted = gqsa1.sort(random);
        // Comparable[] increasingSorted = gqsa2.sort(increasing);
        // Comparable[] decreasingSorted = gqsa3.sort(decreasing);
        // System.out.println();
        // System.out.println(Arrays.toString(randomSorted));
        // System.out.println(gqsa1.isSorted(randomSorted));
        // System.out.println(gqsa1.getNumberOfComparisons());
        // System.out.println();
        // System.out.println(Arrays.toString(increasingSorted));
        // System.out.println(gqsa2.isSorted(increasingSorted));
        // System.out.println(gqsa2.getNumberOfComparisons());
        // System.out.println();
        // System.out.println(Arrays.toString(decreasingSorted));
        // System.out.println(gqsa3.isSorted(decreasingSorted));
        // System.out.println(gqsa3.getNumberOfComparisons());
    }
    
}
