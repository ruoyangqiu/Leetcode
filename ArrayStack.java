import java.util.EmptyStackException;

public class ArrayStack implements DStack {
	private double[] stackArray;
	private int size;
	private static final int Initial_Size = 10;
	
	public ArrayStack(){
		stackArray = new double[Initial_Size];
		size = 0;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public void push(double d){
		if(stackArray.length == size){
			double[] temp = new double[2*stackArray.length];
			stackArray = temp;
		}
		stackArray[size] = d;
		size ++;
	}
	
	public double pop(){
		if(size == 0){
			throw new EmptyStackException();
		}
		size --;
		return stackArray[size];
	}
	
	public double peek(){
		if(size == 0){
			throw new EmptyStackException();
		}
		return stackArray[size - 1];
	}
}
