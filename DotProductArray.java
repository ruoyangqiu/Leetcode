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
	
	private static int doDot(int[] num1, int[] num2) {
		if(num1.length == 0 || num1.length != num2.length) {
			return -1;
		}
		if(num1.length == 1) return num1[0] * num2[0];
		int sum = 0;
		for(int i = 0 ; i < num1.length; i ++) {
			if(num1[i] != 0) {
				if(num2[i] != 0) {
					sum += num1[i] * num2[i];
				}
			}
		}
		return sum;
	}
	
	public static void main(String[] args) throws Exception {
		
		int[] num1 = generate(20);
		int[] num2 = generate(20);
		int res = doDot(num1, num2);
		System.out.println(res);
	}
}
