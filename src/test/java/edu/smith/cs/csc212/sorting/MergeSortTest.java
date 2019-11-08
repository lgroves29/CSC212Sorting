package edu.smith.cs.csc212.sorting;
import java.util.Random;

import org.junit.Test;
import edu.smith.cs.csc212.sorting.MergeSort;

import static org.junit.Assert.assertEquals;
import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class MergeSortTest {
	
	public ListADT<Integer> MakeUnsortedList() {
		Random rand = new Random();
		ListADT<Integer> unsorted = new JavaList<>();
		for (int i = 0; i <5; i++) {
			unsorted.addBack(rand.nextInt());
		}
		return unsorted;
	}
	public ListADT<Integer> MakeSortedList() {
		ListADT<Integer> sorted = new JavaList<>();
		for (int i = 0; i <11; i++) {
			sorted.addBack(i);
		}
		return sorted;
	}

	

	@Test
	public void testCombine() {
		ListADT<Integer> list1 = MakeSortedList();
		ListADT<Integer> list2 = MakeSortedList();
		int size1 = list1.size();
		int size2 = list2.size();
		ListADT<Integer> sorted = MergeSort.combine(list1, list2);
		for (int i = 1; i < sorted.size(); i ++) {
			assertEquals(true, sorted.getIndex(i) >= sorted.getIndex(i -1));
		}
		assertEquals(true, sorted.size() == size1 + size2);
		
		
	}
	@Test 
	public void testRecursiveMerge() {
		ListADT<Integer> unsorted = MakeUnsortedList();
		ListADT<Integer> bubble = new JavaList<Integer>();
		bubble.addAll(unsorted);
		ListADT<Integer> mergeSorted = MergeSort.recursiveMerge(unsorted);
		for (int i = 1; i < mergeSorted.size(); i ++) {
			assertEquals(true, mergeSorted.getIndex(i) >= mergeSorted.getIndex(i -1));
		}
		BubbleSort.sort(bubble);
		System.out.println(mergeSorted);
		System.out.println(bubble);
		assertEquals(mergeSorted, bubble);
		
		
	}
	
	@Test
	public void testIterativeMerge() {
		ListADT<Integer> unsorted = MakeUnsortedList();
		ListADT<Integer> bubble = new JavaList<Integer>();
		bubble.addAll(unsorted);
		ListADT<Integer> sorted = new JavaList<>();
		sorted = MergeSort.iterativeMerge(unsorted);
		for (int i = 1; i < sorted.size(); i ++) {
			assertEquals(true, sorted.getIndex(i) >= sorted.getIndex(i -1));
		}
		BubbleSort.sort(bubble);
		assertEquals(bubble, sorted);
	}
	
}
