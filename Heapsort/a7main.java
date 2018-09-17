
public class a7main {

	public static void main(String[] args) {
		heap(5000); bubble(5000);

		heap(10000); bubble(10000);

		heap(15000); bubble(15000);

		heap(20000); bubble(20000);

		heap(25000); bubble(25000);

		heap(30000); bubble(30000);
	}
	private static void bubble(int size) {
		Bubblesort bub = new Bubblesort(size);
		long start = System.nanoTime();
		bub.bSort();
		long end = System.nanoTime();
		double timeTaken = (double)(end - start)/1000000;
		System.out.println("Bubblesort took " + timeTaken + " milliseconds to sort an array of " + size + " integers");
	}

	public static void heap(int size) {
		Heapsort sort = new Heapsort(size);
		long start = System.nanoTime();
		sort.hSort();
		long end = System.nanoTime();
		double timeTaken = (double)(end - start)/1000000;
		System.out.println("Heapsort took " + timeTaken + " milliseconds to sort an array of " + size + " integers");
		//sort.show();
	}


}
