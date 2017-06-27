// Use Array to implent Stack.

import java.util.EmptyStackException;

public class ArrayStack implements DStack {
	private double[] stackArray; // Store the element of stack
	private int size;	      // the size of the stack
	private static final int Initial_Size = 10; //the initial size of the array when stack initialized
	
	public ArrayStack(){
		stackArray = new double[Initial_Size];
		size = 0;
	}
	
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	// inseart the new data into the stack
	// if the element reach the maximum size of the arra, double the array size
	public void push(double d){
		if(stackArray.length == size){
			double[] temp = new double[2*stackArray.length];
			stackArray = temp;
		}
		stackArray[size] = d;
		size ++;
	}
	
	// remove the last added element, and return it
	// threw EmptyStackExpection if the stack is empty 
	public double pop(){
		if(size == 0){
			throw new EmptyStackException();
		}
		size --;
		return stackArray[size];
	}
	
	// return the last added element
	public double peek(){
		if(size == 0){
			throw new EmptyStackException();
		}
		return stackArray[size - 1];
	}
}
