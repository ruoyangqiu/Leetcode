import java.util.*;

public class Hotel {

	
	
	public static void main(String[] args) {
		// ["+1A", "+3E", "-1A", "+4F", "+1A", "-3E"]
				String[] books1 = { "+1A", "+3E", "-1A", "+4F", "+1A", "-3E" };
				String[] books2 = {"+1A","+3F","+2B"};
				String[] books3 = {"+1E", "-1E", "+1E", "-1E", "+1E", "-1E", "+1E", "-1E","+2A", "-2A", "+2A", "-2A", "+2A", "-2A", "+2A", 
						"-2A","+2B", "-2B", "+2B", "-2B", "+2B", "-2B", "+2B", "-2B"};
				System.out.println(solution(books1));
				System.out.println(solution(books2));
				System.out.println(solution(books3));

	}
	
	
	static class Room implements Comparable<Room>{
		public String no;
		public int book;
		public Room(String no) {
			this.no = no;
			
		}
		@Override
		public int compareTo(Room o) {
			if (this.book < o.book) {
				return -1;
			} else if (this.book > o.book) {
				return 1;
				
			} else {
				return -this.no.compareTo(o.no);
			}
		}
	}
	private static String solution(String[] A) {
		Room[] res = new Room[260];
		for(int i = 0 ; i < res.length; i++) {
			char[] ch = new char[2];
			char f = (char)(i/26 + '0');
			char n  = (char)(i%26 + 'A');
			ch[0] = f;
			ch[1] = n;
			res[i] = new Room(new String(ch));
		}
		for(String str : A) {
			if(str.charAt(0) == '+') {
				int floor = str.charAt(1) - '0';
				int cell = (str.charAt(2) - 'A');
				int id = floor * 26 + cell;
				res[id].book += 1;
			}
		}
		Arrays.sort(res);
		return res[res.length - 1].no;
	}


}
