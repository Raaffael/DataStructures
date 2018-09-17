import java.util.Scanner;

public class a2main {
	static ArrayBasedQueue q;

	public static void main(String[] args) {
		initialize();
		run();
	}
	public static void run() {
		Boolean keepRunning = true;
		Scanner scan = new Scanner(System.in);
		Scanner intScan = new Scanner(System.in);
		Object eleIN;
		while(keepRunning) {
			showOptions();
			System.out.println(" ");
			String choice = null;
			choice = scan.nextLine().toUpperCase();
			if(choice.equals("A")) {
				System.out.println("What would you like to add?");
				eleIN = scan.nextLine();
				q.add(eleIN);
			}

			if(choice.equals("B")) {
				q.delete(); //shows confirmation
			}
			if(choice.equals("C")) {
				q.show();
			}
			if(choice.equals("D")) {
				System.out.println("Total elements: " + q.count());
			}
			if(choice.equals("E")) {
				System.out.println("Clearing array...");
				q.clear();
				q.show();
			}
			if(choice.equals("X")) {
				System.out.println("See Ya!");
				q.show();
				keepRunning=false;
			}
		}
		
	}

	public static <T> void initialize() {
		T[] initial = (T[]) new Object[5];
		int length = initial.length;
		q = new ArrayBasedQueue(initial, length);
		q.add("A"); q.add(10); q.add("#"); q.add(11.1);
		q.show();
		System.out.println("A queue has been created for you. Would you like to...");
	}
	public static void showOptions() {
		System.out.println(" "
				+ "\n(A) Add an element to the end"
				+ "\n(B) Delete the first element"
				+ "\n(C) Show the queue"
				+ "\n(D) Count the elements"
				+ "\n(E) Clear the queue"
				+ "\n(X) EXIT the program"
				+ "\nPlease select a letter." );
		
	}

}
