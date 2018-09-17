import java.util.Arrays;

public class Partition {
	private static int[] array;
	private int size;
	
	public Partition(int RASize) {
		size = RASize;
		array = new int[size];
		genRandomArray();
		array[9]=25;
	}
	public void genRandomArray() {
		for(int i = 0; i<size; i++) {
			array[i] = (int) (Math.random()* 50)+10;
		}	
	}
	public void partitionArray(int pivot){
		int leftPointer = -1;
		int rightPointer = size;
		
		while(true) {
			while(array[++leftPointer] < pivot) {System.out.println(array[leftPointer] + " is in the right spot!");}
			System.out.println(array[leftPointer] + " in index " + leftPointer + 
					" is bigger than the pivot value " + pivot);
			while(rightPointer > 0 && array[--rightPointer] >= pivot){System.out.println(array[rightPointer] + " is in the right spot!");}
			System.out.println(array[rightPointer] + " in index " + rightPointer + 
					" is smaller than the pivot value " + pivot);
			if(leftPointer >= rightPointer) break;
			else {
				flip(leftPointer, rightPointer);
				System.out.println("\n" + Arrays.toString(array));
				System.out.println(array[leftPointer] + " was swapped for " + array[rightPointer]);
			}
		}
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
