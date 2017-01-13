import java.util.Arrays;

// Ruoyang Qiu
// 1133074
// CSE 143 B Section BE
// Homework 1 LetterInventory
// In this class, I construct an inventory that can store the content of the input string
// Additionally, this program can also compute how many letters are in this inventory.
// It ignores the case of the letters and ignores anything that is not an alphabetic character 
// (e.g., it ignores punctuation characters, digits and anything else that is not a letter).

public class LetterInventory {
	private int[] counts; // array store the letters in the inventory
	private String input; // the input without non-alphabetic characters
	private  int size; // the total counts
	
	// constructor of the inventory with a specific input string data 
	public LetterInventory(String data) {
		input = "";
		counts = new int[26]; // the location of each character is the NO. of it in alphabet
		build(data); // delete the non-alphabetic characters
		size = countTotal();
	}
	
	// count how many given letters are in the inventory
	public int get(char letter){
		letter = Character.toLowerCase(letter);
		if(letter < 'a' || letter > 'z'){
			// throw an IllegalArgumentException if the given letter is non-alphabetic
			throw new IllegalArgumentException();	
		} else {
			return counts[letter - 'a'];
		}
	}
	
	public void set(char letter, int value){
		letter = Character.toLowerCase(letter);
		if(letter < 'a' || letter > 'z'){
			// throw an IllegalArgumentException if the given letter is non-alphabetic
			throw new IllegalArgumentException();	
		} else if (value < 0){
			// throw an IllegalArgumentException if the given value is negative
			throw new IllegalArgumentException();
		} else {
			int index = letter - 'a';  // the location of the letter in counts[]
				counts[index] = value;
				size = countTotal();
		}
	}
	
	// the total counts of letter in the inventory
	public int size(){
		return size;
	}
	
	// check if the inventory is empty
	public boolean isEmpty(){
		return size == 0;
	}
	
	// convert the inventory into string, for example "apple"
	// should have a form of [aelpp]
	public String toString(){
		String str = "[";
		for (int i = 0; i < counts.length; i++){
			for (int j = 0; j < counts[i]; j++){
				str += (char)('a'+i);
			}
		}
		str += "]";
		return str;
	}
	
	// add another inventory to this inventory
	public LetterInventory add(LetterInventory other){
		String data = input + other.toString();
		LetterInventory result = new LetterInventory(data);
		return result;
	}
	
	// subtract another inventory to this inventory
	public LetterInventory subtract(LetterInventory other) {
		String str = other.toString();
		LetterInventory result = new LetterInventory(input); // Initialize the result inventory
		for (int i = 1; i < str.length() - 1; i++){
			char letter = str.charAt(i);
			if(result.get(letter) == 0){ 
				// return null if the given letter in the original inventory is less than other inventory
				return null;
			} else {
				result.set(letter, result.get(letter)-1);
			}
		}
		return result;
	}
	
	// build the array to store the data
	// get the input without the non-alphabetic characters and convert the input into lowercase
	// for example, the input string is "How are you?", this method will convert it into
	// "howareyou".
	private  void build(String data){
		data = data.toLowerCase();
		int it = 0; // iteration
		while(it < data.length()){
			if(data.charAt(it) >= 'a' && data.charAt(it) <= 'z'){
				counts[data.charAt(it) - 'a']++;
				input += data.charAt(it);
			} 
			it++;
		}
	}
	
	// count the size of the inventory
	private int countTotal(){
		int total = 0;
		for (int i = 0; i < counts.length; i++){
			total += counts[i];
		}
		return total;
	}
}
