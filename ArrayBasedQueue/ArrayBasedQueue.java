
public class ArrayBasedQueue<T> {
	private int maxSize; private int front;	private int rear; private int actualSize; private T[] array;
	
	ArrayBasedQueue(T[] ar, int size) {
		front = 0; rear = 0; actualSize=0; array = ar; maxSize = size;
	}
	public void add(T data) {
		if(count()<maxSize) {
			array[rear] = data; rear = (rear+1)%maxSize; actualSize++;
			System.out.println("Successfully added: " + data);
		}else {
			System.out.println("Queue is full. Could not add: " + data);
		}
	}
	public T delete() {
		if(count()>0) {
			T data = array[front];
			front = (front+1)%maxSize; actualSize--;
			System.out.println("Successfully removed: " + data);
			return data;
		}else {
			System.out.println("Queue is empty"); return null;
		}
	}
	public void show() {
		System.out.print("Elements: [");
		for(int i = 0; i<actualSize; i++) {
			System.out.print(array[(front + i)%maxSize]+" ");
		}
		System.out.println("]");
	}
	public int count() {
		return actualSize;
	}
	public void clear() {
		front = 0; rear = 0; actualSize = 0;
		
	}
}
