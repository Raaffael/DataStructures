import java.util.Scanner;

public class a10main {
	static DoublyLinkedList dllist = new DoublyLinkedList();

	public static void main(String[] args) {
		run();
	}
	public static void showOptions() {
		System.out.println(" "
				+ "\n(A) Insert a word(Alphabetically)"
				+ "\n(B) Insert a word(Beginning)"
				+ "\n(C) Count the words"
				+ "\n(D) Delete a word" 
				+ "\n(E) Clear the list"
				+ "\n(X) EXIT the program"
				+ "\nPlease select a letter.\n" );
		
	}
	public static void run() {
		Boolean keepRunning = true;
		Scanner scan = new Scanner(System.in);
		String data;
		while(keepRunning) {
			showOptions();
			String choice = null;
			choice = scan.nextLine().toUpperCase();
			if(choice.equals("A")) {
				System.out.println("What would you like to insert?(ALPHABETICALLY)");
				data = scan.nextLine();
				dllist.insertAlpha(data);
			}
			if(choice.equals("B")) {
				System.out.println("What would you like to insert?(BEGINNING)");
				data = scan.nextLine();
				dllist.insertBegin(data);
			}
			if(choice.equals("D")) {
				System.out.println("What would you like to delete? (Enter a word)");
				data = scan.nextLine();
				dllist.delete(data);
			}
			if(choice.equals("C")) {
				System.out.println("Total words: " + dllist.count());
			}
			if(choice.equals("E")) {
				System.out.println("Clearing list...");
				dllist.clear();
			}
			if(choice.equals("X")) {
				System.out.println("See Ya!");
				keepRunning=false;
			}
			dllist.show();
			dllist.showPrev();
		}
		scan.close();
		
	}

}
