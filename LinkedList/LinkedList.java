
public class LinkedList {
	Link firstLink; Link currentLink;
	
	public LinkedList() {firstLink = null;}
	
	public void insertBegin(String data) {
		currentLink = new Link(data);
		currentLink.next= firstLink;
		firstLink = currentLink;
	}
	public void insertAlpha(String data) {
		if(firstLink==null) {
			firstLink = new Link(data);
			return;
		}
		if(notAlphabetized(firstLink.data, data)) {
			currentLink = firstLink;
			firstLink = new Link(data);
			firstLink.next = currentLink;
			return;
		}
		currentLink = firstLink;
		while(currentLink.next!=null) {
			if(notAlphabetized(currentLink.next.data, data)){
				Link next = currentLink.next;
				currentLink.next = new Link(data);
				currentLink.next.next = next;
				return;
			}else {
				currentLink = currentLink.next;
			}	
		}
		currentLink.next = new Link(data);
	}
	public void delete(String data) {
		if(firstLink==null) {
			System.out.println("Cannot delete from an empty list!");
			return;
		}
		if(firstLink.data.equals(data)) {
			firstLink = firstLink.next;
			return;
		}
		currentLink = firstLink;
		while(currentLink.next != null) {
			if(currentLink.next.data.equals(data)) {
				currentLink.next=currentLink.next.next;
				return;
			}else {currentLink = currentLink.next;}
		}
	}
	public void clear() {
		firstLink = null;
	}
	public int count() {
		currentLink = firstLink;
		int count=0;
		while(currentLink!=null) {
			count++;
			currentLink = currentLink.next;
		}
		return count;
	}
	public void show() {
		currentLink = firstLink;
		if(currentLink==null) {
			System.out.println("The list is empty!");
			return;
		}
		System.out.print("["+firstLink.data);
		currentLink = currentLink.next;
		while(currentLink!=null) {
			System.out.print("---> " + currentLink.data);
			currentLink = currentLink.next;
		}
		System.out.println("]");
	}
	public int charValueAt(String data, int i) {
		return (int)data.toUpperCase().charAt(i);
	}
	public boolean notAlphabetized(String current, String input) {
		int i = 0;
		if(charValueAt(current, 0)<charValueAt(input, 0)) return false;
		if(charValueAt(current, 0)>charValueAt(input, 0)) return true;
		while(charValueAt(current, i)==charValueAt(input, i)) {
			if(current.length()==i+1) {System.out.println("a"); return false;}
			if(input.length()==i+1) {System.out.println("b"); return true;}
			i++;
			if(charValueAt(current, i)<charValueAt(input, i)) {
				return false;
			}
			if(charValueAt(current, i)>charValueAt(input, i)) {
				return true;
			}
			if(current.length()==i) {System.out.println("a"); return false;}
			if(input.length()==i) {System.out.println("b"); return true;}
				
		}
		return true;
	}
}
