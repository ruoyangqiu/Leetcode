package test;

import java.util.*;

public class IsPalindrome {

	public static void main(String[] args) {
		
		int[] a = {1, 1000000000, -1000000000, -1000000000, 1000000000, 1};
		int[] b = {1, 1000000000, -1000000000, -1000000000, 1000000000, 1};
		int c = 1000000000;
		int d = 1000000000;
		
		ListNode<Integer> head = new ListNode<Integer>(1);
		ListNode<Integer> temp = head;
		for(int i = 1; i < a.length; i++) {
			head.next = new ListNode<Integer>(a[i]);
			head = head.next;
			
		}
		boolean r = isListPalindrome(temp);
		System.out.println(r);
		
		// Using LinkedList to test equal and ==
		List<Integer> l1 = new LinkedList<>();
		List<Integer> l2 = new LinkedList<>();
		for(int i = 0; i < a.length; i++) {
			
			l1.add(a[i]);
			l2.add(b[i]);
		}
		System.out.println(l1.get(1).equals(l2.get(4)));
		System.out.println(l1.get(1) == l2.get(1));
	}
	
	/*
	 * Check is a given Listnode is palindrome
	 * */
	static boolean  isListPalindrome(ListNode<Integer> l) {
	    ListNode<Integer> slow = l;
	    ListNode<Integer> fast = l;
	    while(fast!= null && fast.next != null)
	    {
	        fast= fast.next.next;
	        slow = slow.next;
	    }
	    slow = reserve(slow);

	    while(l!= null && slow != null)
	    {
	    	// Compare values using == and equal()
	    	System.out.println(l.value == slow.value);	    	
	    	System.out.println(l.value.equals(slow.value));
	        
	    	if(l.value.equals(slow.value)){
	        	
	        	l = l.next;
		        slow = slow.next;
	        } else {
	        	return false;
	        }
	        
	    }
	    return true;
	}
	
	/*
	 * Reverse the given ListNode
	 */
	private static ListNode<Integer> reserve(ListNode<Integer> l){
	    ListNode<Integer> cur = l;
	    ListNode<Integer> prev = null;
	    ListNode<Integer> next;
	    while(cur != null){
	        next = cur.next;
	        cur.next = prev;
	        prev = cur;
	        cur = next;
	    }
	    return prev;
	}


}
