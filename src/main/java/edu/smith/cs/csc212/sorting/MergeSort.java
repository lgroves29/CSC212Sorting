package edu.smith.cs.csc212.sorting;



import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;



public class MergeSort {
	public static ListADT<Integer> combine(ListADT<Integer> sorted1, ListADT<Integer> sorted2) {
		ListADT<Integer> output = new JavaList<>();
		while (!sorted1.isEmpty() && !sorted2.isEmpty()) {
			if (sorted1.getFront() < sorted2.getFront()) {
				output.addBack(sorted1.removeFront());
			}
			else {
				output.addBack(sorted2.removeFront());
			}
		}
		if (sorted1.isEmpty()) {
			output.addAll(sorted2);
		}
		else if (sorted2.isEmpty()) {
			output.addAll(sorted1);
		}
		
		return output;
	}
	
	public static ListADT<Integer> recursiveMerge(ListADT<Integer> unsorted) {
		ListADT<Integer> output = new JavaList<>();
		if (unsorted.size() > 1) {
			ListADT<Integer> list1 = unsorted.slice(0, unsorted.size()/2);
			ListADT<Integer> list2 = unsorted.slice(unsorted.size()/2, unsorted.size());
			output = combine(recursiveMerge(list1), recursiveMerge(list2));
			
			
		}
		else {
			output.addBack(unsorted.getFront());
		}
		return output;
	}
	
	public static ListADT<Integer> iterativeMerge (ListADT<Integer> unsorted){
		ListADT<Integer> output = new JavaList<>();
		ListADT<ListADT> workQueue = new DoublyLinkedList<ListADT>();
		for (int entry: unsorted) {
			ListADT<Integer> subset = new JavaList<>();
			subset.addFront(entry);
			workQueue.addBack(subset);
		}
		while (workQueue.size() >= 2) {
			ListADT<Integer> mergedSubset = combine(workQueue.getFront(), workQueue.getIndex(1));
			workQueue.addBack(mergedSubset);
			workQueue.removeFront();
			workQueue.removeFront();
			
		}
		output.addAll(workQueue.getFront());
		return output;
	}
	
	public static void main(String[] args) {
		ListADT<Integer> sorted1 = new JavaList<>();
		sorted1.addBack(1);
		sorted1.addBack(2);
		sorted1.addBack(5);
		ListADT<Integer> unsorted = new JavaList<>();
		unsorted.addBack(2);
		unsorted.addBack(1);
		unsorted.addBack(6);
		unsorted.addBack(10);
		unsorted.addBack(3);
		unsorted.addBack(2);
		ListADT<Integer> list1 = new JavaList<>();
		list1.addBack(1);
		list1.addBack(2);
		list1.addBack(3);
		list1.addBack(4);
		list1.addBack(5);
		list1.addBack(6);
		list1.addBack(7);
		list1.addBack(8);
		list1.addBack(9);
		list1.addBack(10);
		ListADT<Integer> list2 = new JavaList<>();
		list2.addBack(0);
		list2.addBack(2);
		list2.addBack(3);
		list2.addBack(4);
		list2.addBack(5);
		list2.addBack(6);
		list2.addBack(7);
		list2.addBack(8);
		list2.addBack(9);
		list2.addBack(10);
		//System.out.println(list1);
		//System.out.println(list2);
		
		//System.out.println(combine(list1, list2));
		//System.out.println(sorted1);
		//System.out.println( unsorted);
		//System.out.println(iterativeMerge(unsorted));
	
	}
	}


