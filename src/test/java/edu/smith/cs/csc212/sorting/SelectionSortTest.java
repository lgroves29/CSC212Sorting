package edu.smith.cs.csc212.sorting;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class SelectionSortTest {
	SortTestingHelpers sortHelper = new SortTestingHelpers();
	@Test
	public void testSelectionSort() {
		ListADT<Integer> selectionSort = sortHelper.getData();
		ListADT<Integer> bubbleSort = sortHelper.getData();
		int size = selectionSort.size();
		ListADT<Integer>selected = SelectionSort.sort(selectionSort);
		BubbleSort.sort(bubbleSort);
		sortHelper.checkSorted(selected, size);
		Assert.assertEquals(bubbleSort, selected);
		
	}

}
