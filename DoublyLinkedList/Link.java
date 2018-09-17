
public class Link {
	String data;
	Link next;
	Link previous;
	
	public Link(String data, Link prev, Link next) {
		this.data = data;
		this.previous = prev;
		this.next = next;
	}
	
}
