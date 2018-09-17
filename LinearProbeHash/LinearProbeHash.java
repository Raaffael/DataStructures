import java.util.Arrays;

public class LinearProbeHash {
	static String[] array;
	static int size;
	
	public LinearProbeHash(int newSize) {
		size = newSize;
		array = new String[size];
	}
	public static int stringToHashKey(String stringToConvert) {
		int hashValue =0;
		for(int i =0; i<stringToConvert.length(); i++) {
			int charCode= stringToConvert.charAt(i)+1;
			hashValue = Math.abs((hashValue * 27 + charCode));
		}
		//System.out.println(stringToConvert + " turns into hashvalue : " + hashValue);
		return hashValue;
	}
	public void hashDelete(String toDelete) {
		int tombstone = hashFind(toDelete);
		if(tombstone!=-1) {
			array[tombstone]="-1";
			System.out.println("\tDeleted : " + toDelete); 
		}else {
			System.out.println("We couldn't delete : " + toDelete); 
		}
		showArray();
	}
	public String hashInsert(String toInsert) {
		if(isFull()) {
			System.out.println("The hash table is full! Cannot insert " + toInsert);
			return null;
		}
		int pos = stringToHashKey(toInsert)%size;
		System.out.println("Attempting to insert " + toInsert + " into position : " + pos);
		
		while(array[pos]!= null&&!"-1".equals(array[pos])) {
			int prev = pos;
			pos=(pos+1)%size;
			System.out.println("\tPosition " + prev + " is taken!");
		}
		
		array[pos]=toInsert;
		System.out.println("\t\tInserted " + toInsert +  " into position " + pos);
		showArray();
		return toInsert;
		
	}
	public static int hashFind(String toFind) {
		int pos = stringToHashKey(toFind)%size;
		int j=size;
		if(toFind.equals(array[pos])) {
			System.out.println("WE FOUND " + toFind +" at position : " + pos);
			return pos;
		}
		else {
			while(!toFind.equals(array[pos])&&j>0) {
				pos=(pos+1)%size;
				//System.out.println("Trying next position..." + pos);
				if(toFind.equals(array[pos])) {
					System.out.println("We found " + toFind +" at position : " + pos);
					return pos;
				}else {
					j--;		
				}	
			}
			System.out.println("We couldn't find : "+ toFind);

		}
		return -1;
	}
	public void showArray() {
		System.out.println(Arrays.toString(array)+"\n");
	}
	public static boolean isFull() {
		for(int i=0; i<size; i++) {
			if(array[i]==null||"-1".equals(array[i])) {
				return false;
			}
		}
		return true;
	}

}
