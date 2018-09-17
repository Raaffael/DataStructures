import java.util.Arrays;

public class Quicksort {
	private static int[] array;
	private int size;
	
	public Quicksort(int RASize) {
		size = RASize;
		array = new int[size];
		genRandomArray();
	}
	public void genRandomArray() {
		for(int i = 0; i<size; i++) {
			array[i] = (int) (Math.random()*50) +10;
		}	
	}
	
	public void qSort(int left, int right) {
		if((right - left) <= 0) {
			return;
		}else {
			int pivot = array[right];
			int pivotLocation = partitionArray(pivot, left, right);
			qSort(left, pivotLocation -1);
			qSort(pivotLocation +1, right);
		}
	}
	
	public int partitionArray(int pivot, int left, int right) {
		int leftPointer = left-1;
		int rightPointer = right;
		
		while(true) {
			while(array[++leftPointer] < pivot) {System.out.println(array[leftPointer] + " is in the right spot!");}
			System.out.println(array[leftPointer] + " in index " + leftPointer + 
					" is bigger than the pivot value " + pivot);
			while(rightPointer > 0 && array[--rightPointer] > pivot){System.out.println(array[rightPointer] + " is in the right spot!");}
			System.out.println(array[rightPointer] + " in index " + rightPointer + 
					" is smaller than the pivot value " + pivot);
			if(leftPointer >= rightPointer)break;
			flip(leftPointer, rightPointer);
			System.out.println("\n" + Arrays.toString(array));
			System.out.println(array[leftPointer] + " was swapped for " + array[rightPointer]);
			
		}
		flip(leftPointer, right);
		return leftPointer;
	}
	public void flip(int one, int two) {
		int temp = array[one];
		array[one] = array[two];
		array[two] = temp;
		
	}
	public static int[] getArray() {
		return array;
	}

}
