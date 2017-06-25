import java.util.EmptyStackException;

public class ListStack implements DStack {
	private int size;
	private ListStackNode node;
	
	public ListStack(){
		node = null;
		size = 0;
	}
	
	public boolean isEmpty(){
		return node == null;
	}
	
	public void push(double d){
		ListStackNode last = new ListStackNode(d);
		last.next = node;
		node = last;
		size ++;
	}
	
	public double pop(){
		if(this.isEmpty()){
			throw new EmptyStackException();
		}
		double data = node.data;
		node = node.next;
		size --;
		return data;
	}
	
	public double peek(){
		if(this.isEmpty()){
			throw new EmptyStackException();
		}
		return node.data;
	}
}
