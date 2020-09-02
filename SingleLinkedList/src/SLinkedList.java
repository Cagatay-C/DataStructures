
public class SLinkedList {
	protected Node head;
	protected Node tail;
	protected long size;
	
	public SLinkedList() {
		head = null;
		size = 0;
	}
	
	public void addFirst(Node h) {
		h.setNext(head);
		head = h;
		tail = head;
		size++;
	}
	
	public void addLast(Node l) {
		l.setNext(null);
		tail.setNext(l);
		tail = l;
		size++;
	}
	
	public void removeFirst() {
		if(head == null)
			System.out.println("List is already empty");
		Node temp = head;
		head =  temp.getNext();
		temp.setNext(null);
		size--;
	}
	
	public void print() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.getElement());
			temp = temp.getNext();
		}
	}
	
	public void printHead() {
		System.out.println("Head--->" + head.getElement());
	}
	
	public void printTail() {
		System.out.println("Tail--->" + tail.getElement());
	}
}
