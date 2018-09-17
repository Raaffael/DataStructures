import java.util.Arrays;

public class Heapsort {
	private int[] array;
	private int maxSize;
	private int numOfItems;
	
	public Heapsort(int RASize){
		array = new int[RASize];
		maxSize = RASize;
		numOfItems=RASize;
		genRandomArray();
	}
	
	public int removeMax() {
		if(numOfItems>0) {	
			int root = array[0];
			array[0] = array[--numOfItems];
			buildHeap(0);
			return root;
		}
		return 0;
	}
	public void buildHeap(int pos) {
		
		int largestChildPos;
		int root = array[pos];
		while(pos < numOfItems /2) {
			int leftChildPos = 2 * pos +1;
			int rightChildPos = leftChildPos +1;
			if(rightChildPos < numOfItems && array[leftChildPos] < array[rightChildPos] ) {
				largestChildPos = rightChildPos;
			}else {
				largestChildPos = leftChildPos;
			}
			if(root >= array[largestChildPos])break;
			array[pos] = array[largestChildPos];
			pos = largestChildPos;
		}
		array[pos] = root;
	
		
	}
	public void hSort() {
		for(int j = maxSize/2-1; j>=0;j--) {
			buildHeap(j);
		}
		for(int i = maxSize-1; i >= 0; i--) {
			int largestValue = removeMax();
			array[i]=largestValue;
		}
	}
	
	public void show() {
		System.out.println(Arrays.toString(array));
	}
	public void genRandomArray() {
		for(int i = 0; i<numOfItems; i++) {
			array[i] = (int) (Math.random()*50) +10;
		}	
	}
//	public int[] returnArray() {
//		return array;
//	}

}
