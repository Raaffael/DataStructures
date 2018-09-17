

public class Bubblesort {
	private int[] array;
	private int size;
	
	public Bubblesort(int RASize) {
		size = RASize;
		array = new int[size];
		genRandRA();
	}
		
	public void genRandRA() {
		for(int i = 0; i<size; i++) {
			array[i]= (int)(Math.random()*50)+50;
		}
	}

	public void bSort(){
		 for(int i = 0; i <size-1; i++) {
			 for(int j = size-1; j>i; j--) {
				 if(array[j]<array[j-1]) {
					 flip(j, j-1); 
				 }
			 }
		 }
	}

	public void flip(int one, int two) {
		int temp = array[one];
		array[one] = array[two];
		array[two] = temp;
		
	}
	
}

