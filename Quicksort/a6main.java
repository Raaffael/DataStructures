import java.util.Arrays;

public class a6main {

	public static void main(String[] args) {
		//partionDemo();
		//quick();
		bubble();
		
	}
	private static void bubble() {
		Bubblesort bub = new Bubblesort(10);
		bub.showArray();
		bub.bSort();
		bub.showArray();
		
	}
	public static void partionDemo() {
		Partition ay = new Partition(10);
		System.out.println(Arrays.toString(Partition.getArray()));
		ay.partitionArray(25);
		System.out.println(Arrays.toString(Partition.getArray()));
	}
	public static void quick() {
		int arraySize= 500;
		Quicksort sort = new Quicksort(arraySize);
		System.out.println(Arrays.toString(Quicksort.getArray()));
		sort.qSort(0 , arraySize-1);
		System.out.println(Arrays.toString(Quicksort.getArray()));

	}

}
