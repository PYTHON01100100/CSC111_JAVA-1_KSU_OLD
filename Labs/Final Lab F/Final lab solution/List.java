public class List {
	// Attributes
	private Node head;

	public List() {
		head = null;
	}

	// Methods
	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		if (isEmpty())
			return 0;
		Node current = head;
		int c = 0;
		while (current != null) {
			c++;
			current = current.getNext();
		}
		return c;
	}

	public void insertAtFront(Bookstore obj) {
		Node newnode = new Node(obj);
		newnode.setNext(head);
		head = newnode;
	}

	public void insertAtBack(Bookstore obj) {
		Node newnode = new Node(obj);
		if (isEmpty())
			head = newnode;
		else {
			Node current = head;
			while (current.getNext() != null)
				current = current.getNext();
			current.setNext(newnode);
		}
	}

	public Bookstore removeFromfront() {
		if (isEmpty())
			return null;
		Node First = head;
		head = head.getNext();
		return First.getData();
	}

	public Bookstore removeFromBack() {
		Node current = head;
		Node pre = null;
		if (isEmpty())
			return null;
		else
			while (current.getNext() != null) {
				pre = current;
				current = current.getNext();
			}
		Bookstore e = current.getData();
		if (current == head)
			head = null;
		else
			pre.setNext(null);
		return e;
	}
} // end class
