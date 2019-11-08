package edu.smith.cs.csc212.sorting;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class SelectionSort {
	public static ListADT<Integer> sort(ListADT<Integer> input) {
		ListADT<Integer> output = new JavaList<>();
		
		while (input.isEmpty() == false) {
			int minIndex = 0;
			for (int i = 0; i < input.size(); i ++) {
				if (input.getIndex(i)< input.getIndex(minIndex)) {
					minIndex = i;
				}
			}
			output.addBack(input.removeIndex(minIndex));
		}
		return output;
	}


	public static void main(String[] args) {
		ListADT<Integer> input = new JavaList<>();
		input.addBack(15);
		input.addBack(2);
		input.addBack(3);
		input.addBack(4);
		input.addBack(10);
		System.out.println(input);
		System.out.println(sort(input));
	
	}

}
