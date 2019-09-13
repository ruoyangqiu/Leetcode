package dotProduct;

import java.util.Random;

public class DotProductArray {
	
	
	
	private static int[] generate(int size) throws Exception {
		if(size <= 0) {
			throw new Exception("Wrong Size!");
		}
		int[] nums = new int[size];
		Random rand = new Random();
		int zero;
		int num;
		for(int i = 0; i < size; i++) {
			zero = rand.nextInt(99) + 1;
			if(zero > 75) {
				nums[i] = 1;
			} else {
				nums[i] = 0;
			}
		}
		return nums;
	}
	
	private static int doDot(MatrixArray x, MatrixArray y) {
		int sum = 0;
		MatrixNode temp1 = x.getMatrix().next;
		MatrixNode temp2 = y.getMatrix().next;
		while(temp1.next != null && temp2.next != null) {
			if(temp1.index == temp2.index) {
				sum ++;
				temp1 = temp1.next;
				temp2 = temp2.next;
			} else if(temp1.index < temp2.index) {
				temp1 = temp1.next;
			} else {
				temp2 = temp2.next;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) throws Exception {
		
		int[] num1 = generate(20);
		int[] num2 = generate(20);
		MatrixArray ma1 = new MatrixArray();
		MatrixArray ma2 = new MatrixArray();
		for(int i = 0; i < num1.length; i++) {
			ma1.askforNextX(num1[i], i);
		}
		for(int i = 0; i < num2.length; i++) {
			ma2.askforNextX(num2[i], i);
		}
		ma1.printAll();
		System.out.println();
		ma2.printAll();
		System.out.println();
		int res = doDot(ma1, ma2);
		System.out.println(res);
	}
}
