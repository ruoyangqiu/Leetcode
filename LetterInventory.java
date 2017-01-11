import java.util.Arrays;

//Ruoyang Qiu
//1133074
//CSE 143 B Section BE
//Homework 1 LetterInventory

public class LetterInventory {
	private char[] inventory; //array store the character of the inventory in alphabetic order
	private int[] counts; //count how many counts of the character are in the inventory
	private String input; //the input letters of the inventory
	private  int size; //the total counts
	
	//constructor of the inventory with a specific input string data 
	public LetterInventory(String data) {
		size = 0;
		counts = new int[Character.MAX_VALUE]; //the location of each character is the NO. of it in total character
		input = ignore(data); //delete the non-alphabetic characters
		inventory = toChar(); //store the letters into the array and sort them in alphabetic order
	}
	
	//count how many given letters are in the inventory
	public int get(char letter){
		letter = Character.toLowerCase(letter);
		if(letter < 'a' || letter > 'z'){
			//throw an IllegalArgumentException if the given letter is non-alphabetic
			throw new IllegalArgumentException();	
		} else {
			return counts[letter];
		}
	}
	
	public void set(char letter, int value){
		letter = Character.toLowerCase(letter);
		if(letter < 'a' || letter > 'z'){
			//throw an IllegalArgumentException if the given letter is non-alphabetic
			throw new IllegalArgumentException();	
		} else if (value < 0){
			throw new IllegalArgumentException();
		} else {
			if (value == counts[letter]){
				counts[letter] = value;
			} else if(value < counts[letter]){
				size = size - counts[letter] + value;
				counts[letter] = value;
				String sub = "" + letter;
				input = input.replace(sub, "");
				for( int i = 0; i < value; i++){
					input += letter;
				}
				inventory = toChar();
			} else {
				int difference = value - counts[letter];
				size = size + difference;
				counts[letter] = value;
				for( int i = 0; i < difference; i++){
					input += letter;
				}
				inventory = toChar();
			}
		}
	}
	
	//the total counts of letter in the inventory
	public int size(){
		return size;
	}
	
	//check if the inventory is empty
	public boolean isEmpty(){
		return size == 0;
	}
	
	//convert the inventory into string, for example "apple"
	//should have a form of [aelpp]
	public String toString(){
		String str = "[";
		for (int i = 0; i < inventory.length; i++){
			str += inventory[i];
		}
		str += "]";
		return str;
	}
	
	//add another inventory to thid inventory
	public LetterInventory add(LetterInventory other){
		String data = input + other.toString();
		LetterInventory result = new LetterInventory(data);
		return result;
	}
	
	//subtract another inventory to thid inventory
	public LetterInventory subtract(LetterInventory other) {
		String str1 = input;
		String str2 = other.toString();
		str2=str2.replace("[","");
		str2=str2.replace("]","");
		LetterInventory result = new LetterInventory(str1);
		for (int i = 0; i < str2.length(); i++){
			char letter = str2.charAt(i);
			if(result.get(letter) == 0){
				return null;
			} else {
				result.set(letter, result.get(letter)-1);
			}
		}
		return result;
	}
	
	//delete the non-alphabetic characters
	private  String ignore(String data){
		data = data.toLowerCase();
		int it = 0;
		while(size < data.length()){
			if(data.charAt(it) >= 'a' && data.charAt(it) <= 'z'){
				counts[data.charAt(it)]++;
				size ++;
				it++;
			} else {
				String ch = ""+data.charAt(it);
				data = data.replace(ch,"" );
			}
		}
		return data;
	}
	//convert String to a sorted char array 
	private  char[] toChar() {
		char[] letter = new char[size]; 
		for(int i = 0; i < size; i++){
			letter[i] = input.charAt(i);
		}
		Arrays.sort(letter);
		return letter;
	}

}
