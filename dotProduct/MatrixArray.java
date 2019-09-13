package dotProduct;

import java.util.*;

public class MatrixArray {
	
	private MatrixNode matrix;
	private MatrixNode tail;
	private int size;
	
	
	public MatrixArray() {
		matrix = new MatrixNode();
		tail = new MatrixNode();
		tail.previous = matrix;
		matrix.next = tail;
		size = 0;
	}
	
	public void askforNextX(int x, int index) {
		if(x != 0) {
			addMatrixNodeX(x, index);
			size ++;
		}
	}
	
	public int size() {
		return size;
	}
	
	public MatrixNode getMatrix() {
		return matrix;
	}
	
	private void addMatrixNodeX(int x, int index) {
		MatrixNode temp = new MatrixNode();
		temp.previous = tail.previous;
		temp.next = tail;
		tail.previous.next = temp;
		tail.previous = temp;
		temp.index = index;
		temp.valueX = x;
	}
	
	public void printAll() {
		MatrixNode temp = matrix.next;
		while(temp.next != null) {
			System.out.print(temp.index + ": " + temp.valueX + " " );
			temp = temp.next;
		}
	}
	
}
