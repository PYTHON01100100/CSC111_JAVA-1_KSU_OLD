// Class Node implementation
public class Node {
	// Attributes
	private Bookstore data;
	private Node next;

	// Methods
	public Node(Bookstore obj) {
		data = obj;
		next = null;
	}

	public void setNext(Node nextPtr) {
		next = nextPtr;
	}

	public Node getNext() {
		return next;
	}

	public void setData(Bookstore obj) {
		data = obj;
	}

	public Bookstore getData() {
		return data;
	}

	public String toString() {
		return data.toString();
	}
} // end class
