
public class DoublyLinkedList {
	public Link firstLink;
	public Link lastLink;
	public Link current;
	DoublyLinkedList(){
		firstLink = lastLink = null;
	}
	public Link delete(String data) {
		if(firstLink==null) {
			System.out.println("Cannot delete from an empty list!");
			return null;
		}
		if(firstLink.data.equals(data)) {
			firstLink = firstLink.next;
			firstLink.previous = null;
			return firstLink;
		}
		current = firstLink;
		while(current.next!=null) {
			if(current.data.equals(data)) {
				current.previous.next = current.next;
				current.next.previous = current.previous;
				return current;
			}
			current = current.next;
		}
		System.out.println("Could not delete " + data + "!");
		return null;
	}
	public void insertBegin(String data) {
		if(firstLink==null) {
			firstLink = new Link(data, null, null);
			lastLink = firstLink;
		}else {
			current = firstLink;
			firstLink = new Link(data, null, current);
			current.previous = firstLink;
		}
	}
	public void insertAlpha(String data) {
		if(firstLink==null) {
			firstLink = new Link(data,null,null);
			lastLink = firstLink;
			return;
		}
		if(notAlphabetized(firstLink.data, data)) {
			current = firstLink;
			firstLink = new Link(data, null, current);
			current.previous = firstLink;
			return;
		}else {
			current = firstLink;
			while(current!=null) {
				if(notAlphabetized(current.data, data)) {
					Link next = current;
					current = new Link(data, next.previous, next);
					next.previous = current;
					current.previous.next= current;
					return;
				}else {
					current = current.next;
				}
			}
			Link prevTail = lastLink;
			lastLink = new Link(data, prevTail, null);
			prevTail.next = lastLink;
		}
	}
	public int count() {
		current = firstLink;
		int count = 0;
		while(current!=null) {
			count++;
			current = current.next;
		}
		return count;
	}
	public void clear() {
		firstLink = null;
		lastLink=null;
	}
	public void show() {
		current = firstLink;
		if(current==null) {
			System.out.println("The list is empty!");
			return;
		}
		System.out.print("USING .NEXT ["+current.data);
		current = current.next;
		while(current!=null) {
			System.out.print("---> " + current.data);
			current = current.next;
		}
		System.out.println("]");
	}
	public void showPrev() {
		current = lastLink;
		if(current==null) {
			System.out.println("The list is empty!");
			return;
		}
		System.out.print("USING .PREV ["+lastLink.data);
		current = current.previous;
		while(current!=null) {
			System.out.print("---> " + current.data);
			current = current.previous;
		}
		System.out.println("]");
	}
	public boolean notAlphabetized(String current, String input) {
		int i = 0;
		if(charValueAt(current, 0)<charValueAt(input, 0)) return false;
		if(charValueAt(current, 0)>charValueAt(input, 0)) return true;
		while(charValueAt(current, i)==charValueAt(input, i)) {
			if(current.length()==i+1)  {return false;}
			if(input.length()==i+1)  {return true;}
			i++;
			if(charValueAt(current, i)<charValueAt(input, i)) {
				return false;
			}
			if(charValueAt(current, i)>charValueAt(input, i)) {
				return true;
			}
			if(current.length()==i)  {return false;}
			if(input.length()==i) {return true;}
				
		}
		return true;
	}
	public int charValueAt(String data, int i) {
		return (int)data.toUpperCase().charAt(i);
	}
}
