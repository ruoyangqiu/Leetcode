// Use LinkedList to implent Stack.

import java.util.EmptyStackException;

public class ListStack implements DStack {
	private int size; // I am not sure if the size is necessary here? 
	private ListStackNode node; // Store the data of stack
	
	// Constructor
	public ListStack(){
		node = null;
		size = 0;
	}
	
	// Boolean if the stack is empty
	public boolean isEmpty(){
		return node == null;
	}
	
	//inseart the new data into the stack
	public void push(double d){
		ListStackNode last = new ListStackNode(d);
		last.next = node;
		node = last;
		size ++;
	}
	
	// remove the last added element, and return it
	// threw EmptyStackExpection if the stack is empty
	public double pop(){
		if(this.isEmpty()){
			throw new EmptyStackException();
		}
		double data = node.data;
		node = node.next;
		size --;
		return data;
	}
	
	// return the last added element
	public double peek(){
		if(this.isEmpty()){
			throw new EmptyStackException();
		}
		return node.data;
	}
}
