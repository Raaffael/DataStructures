import java.util.Scanner;

public class a1main {
	static ArrayBasedList array;

	public static void main(String[] args) {
		initialize();
		run();
		
	}
	public static void run() {
		Boolean keepRunning = true;
		Scanner scan = new Scanner(System.in);
		Scanner intScan = new Scanner(System.in);
		Object eleIN;
		int inteIN;
		while(keepRunning) {
			showOptions();
			System.out.println(" ");
			String choice = null;
			choice = scan.nextLine().toUpperCase();
			if(choice.equals("A")) {
				System.out.println("What would you like to add to the end?");
				eleIN = scan.nextLine();
				array.add(eleIN);
			}
			if(choice.equals("B")) {
				System.out.println("What element would you like to insert?");
				eleIN = scan.nextLine();
				System.out.println("Where would you like to insert the element? (Positions are one-based for your convinince)");
				inteIN = intScan.nextInt()-1;
				array.insert(eleIN, inteIN);
			}
			if(choice.equals("C")) {
				System.out.println("What element would you like to delete? (Positions are one-based for your convinince)");
				inteIN = intScan.nextInt()-1;
				array.delete(inteIN);
			}
			if(choice.equals("D")) {
				System.out.print("Current Array: ");
				array.show();
			}
			if(choice.equals("E")) {
				System.out.println("Total elements: " + array.count());
			}
			if(choice.equals("F")) {
				System.out.println("Clearing array...");
				array.clear();
			}
			if(choice.equals("X")) {
				System.out.println("See Ya!");
				array.show();
				keepRunning=false;
			}
		}
		
	}
	public static <T> void initialize() {
		T[] initial = (T[]) new Object[] {"a", 10.1,"B", 5, "#", 56.3, "R", 1458};
		int actual = initial.length;
		array = new ArrayBasedList(initial, actual);
		array.show();
		System.out.println("An array has been created for you. Would you like to...");
	}
	public static void showOptions() {
		System.out.println(" "
				+ "\n(A) Add an element"
				+ "\n(B) Insert an element"
				+ "\n(C) Delete an element"
				+ "\n(D) Show the array"
				+ "\n(E) Count the elements"
				+ "\n(F) Clear the array"
				+ "\n(X) EXIT the program"
				+ "\nPlease select a letter." );
		
	}
	

}
