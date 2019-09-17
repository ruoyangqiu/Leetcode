package dotProduct;

import java.util.*;

public class MatrixArray {
	
	
	private int size;
	private int index_of_feature[];
	private int max_size = 100;
	
	
	public MatrixArray() {
		
		index_of_feature = new int[max_size];
		
		size = 0;
	}
	
	public void askforNextX(int x, int index) {
		if(x != 0) {
			index_of_feature[size] = index;
			size ++;
			if(this.size > max_size * 3 / 4) {
				expandArray();
			}
		}
	}
	
	public int size() {
		return size;
	}
	
	public int[] getArray() {
		return this.index_of_feature;
	}
	
	
	private void expandArray() {
		int[] temp = Arrays.copyOf(index_of_feature, max_size * 2);
		index_of_feature = Arrays.copyOf(temp, temp.length);
		max_size = max_size * 2;
	}
	
	public void printAll() {
		for(int i = 0; i <  size; i ++) {
			System.out.print(this.index_of_feature[i] + " ");
		}
	}
	
}
