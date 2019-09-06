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
				nums[i] = zero - 75;
			} else {
				nums[i] = 0;
			}
		}
		return nums;
	}
	
	
	public static void main(String[] args) throws Exception {
		MatrixArray ma = new MatrixArray();
		int[] num1 = generate(20);
		int[] num2 = generate(20);
		int res = ma.dotArray(num1, num2);
		System.out.println(res);
	}
}
