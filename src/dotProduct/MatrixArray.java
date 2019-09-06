package dotProduct;

import java.util.*;

public class MatrixArray {
	//private int[] num1;
	//private int[] num2;
	
	private ArrayList<Integer> index;
	private int dot;
	
	public MatrixArray() {
		index = new ArrayList<>();
		dot = 0;
	}
	
	public int dotArray(int[] num1, int[] num2) {
		if(num1.length == 0 || num1.length != num2.length) {
			return -1;
		}
		if(num1.length == 1) return num1[0] * num2[0];
		for(int i = 0; i < num1.length; i++) {
			if(num1[i] != 0) {
				index.add(i);
			}
		}
		int sum = 0;
		for(int i : index) {
			if(num2[i] != 0) {
				sum += num2[i] * num1[i];
			}
		}
		return sum;
	}
	
}
