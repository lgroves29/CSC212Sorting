package edu.smith.cs.csc212.sorting;
import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

public class InsertionSort {
	public static ListADT<Integer> sort(ListADT<Integer> input){
		ListADT<Integer> output = new JavaList<>();
		while (input.isEmpty() == false){
			int value = input.removeFront();
			if (output.size() == 0) {
				output.addFront(value);
			}
			else {
				for (int i = 0; i < output.size(); i ++) {
					if (output.getIndex(i) > value) {
						output.addIndex(i, value);
						break;
					}
					if (output.getIndex(i) == output.getBack()) {
						output.addBack(value);
					}
				}	
			}
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
