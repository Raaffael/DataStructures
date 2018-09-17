import java.util.Arrays;

public  class ArrayBasedList<T> {
	private static final int SIZE = 10;
	private int actualSize;
	private T[] myArray;
	
	public ArrayBasedList(T[] array, int actual) {
		myArray = array;
		actualSize = actual;
	}
	
	public void add(T el) {
		if(actualSize == myArray.length) {
			T[] newArray = (T[]) new Object[myArray.length +5];
			for(int i =0; i<myArray.length;i++) {
				newArray[i] = myArray[i];
			}
			myArray = newArray;
		}
		myArray[actualSize] = el;
		actualSize++;
	}
	
	public boolean insert(T el, int pos) {
		if (pos<0 || pos>=actualSize) {
			System.out.println("Invalid position!");
			return false;
		}
		if(actualSize == myArray.length) {
			T[] newArray2 = (T[]) new Object[myArray.length +5];
			for(int i =0; i<myArray.length;i++) {
				newArray2[i] = myArray[i];
			}
			myArray = newArray2;
		}
		for(int i= actualSize; i>pos;i--) {
			myArray[i] = myArray[i-1];
		}
		myArray[pos] = el;
		actualSize++;
		return true;
	}
	public boolean delete(int pos) {
		if (pos<0 || pos>=actualSize) {
			System.out.println("Invalid position!");
			return false;
		}
		for(int i= pos; i<actualSize-1;i++) {
			myArray[i] = myArray[i+1];
		}
		myArray[actualSize-1] = null;
		actualSize--;
		return true;
		
	}
	public void clear() {
		myArray = (T[]) new Object[SIZE];
		actualSize = 0;
	}
	public void show() {
		System.out.println(Arrays.toString(myArray));	
	}
	public int count() {
		return actualSize;
		
	}
}
