import java.util.Scanner;

public class a11main {
	static BinarySearchTree tree = new BinarySearchTree();

	public static void main(String[] args) {
		tree.traverseHelp(tree.root);
		run();
	}
	public static void run() {
		Boolean keepRunning = true;
		Scanner scan = new Scanner(System.in);
		Scanner intScan = new Scanner(System.in);
		int data;
		while(keepRunning) {
			showOptions();
			String choice = null;
			choice = scan.nextLine().toUpperCase();
			if(choice.equals("A")) {
				System.out.println("What number would you like to look for?");
				data = intScan.nextInt();
				tree.find(data);
			}
			if(choice.equals("B")) {
				System.out.println("What number would you like to insert?");
				data = intScan.nextInt();
				tree.insert(data);
			}
			if(choice.equals("C")) {
				System.out.println("What number would you like to delete? ");
				data = intScan.nextInt();
				tree.delete(data);
			}
			if(choice.equals("D")) {
				System.out.println("Deleting tree...");
				tree.deleteTree();
			}
			if(choice.equals("X")) {
				System.out.println("See Ya!");
				keepRunning=false;
			}
			tree.traverseHelp(tree.root);
		}
		scan.close();
	}
	public static void showOptions() {
		System.out.println(" "
				+ "\n(A) Find a number"
				+ "\n(B) Insert a number"
				+ "\n(C) Delete a number"
				+ "\n(D) Delete the tree" 
				+ "\n(X) EXIT the program"
				+ "\nPlease select a letter.\n" );
		
	}

}
