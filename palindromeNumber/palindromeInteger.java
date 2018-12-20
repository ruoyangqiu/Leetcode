package palindromeNumber;

public class palindromeInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(11));
	}
	
	public static boolean isPalindrome(int x) {
		if(x < 0) return false;
        if(x < 10) return true;
        int len = (int)(Math.log10(x) + 1);
        int[] num = new int[len];
        int id = len - 1;
        int t = x;
        while(t > 0 && id >= 0){
            num[id] = t % 10;
            t = t / 10;
            id--;
        }
        int s = 0;
        int e = len - 1;
        while(s < e) {
            if(num[s] != num[e]){
                return false;
            }
            s++;
            e--;
        }
        return true;
	}

}
