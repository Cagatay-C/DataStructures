
public class Node {
	private Node next;
	private int element;
	
	public Node(int el) {
		element = el;
	}
	
	public void setNext(Node n) {
		next = n;
	}
	
	public Node getNext() {
		return next;
	}
	
	public int getElement() {
		return element;
	}
}
