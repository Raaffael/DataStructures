

public class ArithmeticPostfix {
	private int maxSize;
	private int top;
	private int[] array;
	ArithmeticPostfix(int[] mine, int size){
		maxSize=size;
		top=0;
		array = mine;
	}
	public void push(int i) {
		if(top==maxSize) {
			System.out.println("Stack is full");
		}else {
			array[top++] = i;
		}	
	}
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty!");
			return 0;
		}else {
			return array[--top];
		}	
	}
	public boolean isEmpty() {
		if(top==0) {
			return true;
		}else {
			return false;
		}
	}
}
