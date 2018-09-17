import java.util.Arrays;

public class ArithmeticPostfix {
	private int maxSize;
	private int top;
	private char[] array;
	ArithmeticPostfix(char[] mine, int size){
		maxSize=size;
		top=0;
		array = mine;
	}
	public void push(char data) {
		if(top==maxSize) {
			System.out.println("Stack is full");
		}else {
			array[top++] = data;
		}	
	}
	public char pop() {
		if(top==0) {
			System.out.println("Stack is empty!");
			return (Character) null;
		}else {
			return array[--top];
		}	
	}
	public void show() {
		System.out.println(Arrays.toString(array));
		System.out.print("Elements: [");
		for(int i = 0; i<top; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println("]");
	}
	public boolean isEmpty() {
		if(top==0) {
			return true;
		}else {
			return false;
		}
	}
}
