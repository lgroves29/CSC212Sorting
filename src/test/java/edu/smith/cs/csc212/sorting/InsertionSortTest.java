package edu.smith.cs.csc212.sorting;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class InsertionSortTest {
	SortTestingHelpers sortHelper = new SortTestingHelpers();
	@Test
	public void testInsertionSort() {
		ListADT<Integer> insertionSort = sortHelper.getData();
		ListADT<Integer> bubbleSort = sortHelper.getData();
		int size = insertionSort.size();
		ListADT<Integer>sorted = SelectionSort.sort(insertionSort);
		BubbleSort.sort(bubbleSort);
		sortHelper.checkSorted(sorted, size);
		Assert.assertEquals(bubbleSort, sorted);
		insertionSort.shuffle();
		size = insertionSort.size();
		bubbleSort = insertionSort;
		sorted = SelectionSort.sort(insertionSort);
		BubbleSort.sort(bubbleSort);
		sortHelper.checkSorted(sorted, size);
		Assert.assertEquals(bubbleSort, sorted);
		
	}

}
