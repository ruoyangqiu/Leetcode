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
		if(y.size() >= x.size()) {
			sum = sumMatrix(x.getArray(), y.getArray(), x.size(), y.size());
		} else {
			sum = sumMatrix(y.getArray(), x.getArray(), y.size(), x.size());
		}
		
		return sum;
	}
	
	private static int sumMatrix(int[] x, int[] y, int sizeX, int sizeY) {
		int sum = 0;
		for(int i = 0 ; i < sizeX; i ++) {
			if(findIndex(0, sizeY - 1, y, x[i])) {
				sum ++;
			}
		}
		return sum;
	}
	
	private static boolean findIndex(int s, int e, int[] num, int target) {
		if(s > e) {
			return false;
		} else {
			int mid = (s + e) / 2;
			if(num[mid] == target) {
				return true;
			} else if(num[mid] > target) {
				return findIndex(s, mid - 1, num, target);
			} else {
				return findIndex(mid + 1, e, num, target);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		int[] num1 = generate(50000);
		int[] num2 = generate(5000000);
		MatrixArray ma1 = new MatrixArray();
		MatrixArray ma2 = new MatrixArray();
		for(int i = 0; i < num1.length; i++) {
			ma1.askforNextX(num1[i], i);
		}
		for(int i = 0; i < num2.length; i++) {
			ma2.askforNextX(num2[i], i);
		}
		//ma1.printAll();
		//System.out.println();
		//ma2.printAll();
		//System.out.println();
		int res = doDot(ma1, ma2);
		System.out.println(res);
	}
}
