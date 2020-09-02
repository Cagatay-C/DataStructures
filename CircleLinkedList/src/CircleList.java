
public class CircleList {
	protected Node cursor;
	protected int size;
	
	public CircleList() {
		cursor = null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public Node getCursor() {
		return cursor;
	}
	
	public void advance() {
		cursor = cursor.getNext();
	}
	
	public void add(Node newNode) {
		if(cursor == null) {
			newNode.setNext(newNode);
			cursor = newNode;	
		}
		else {
			newNode.setNext(cursor.getNext()); // ???????
			cursor.setNext(newNode);
		}
		size++;
	}
	
	public Node remove() {
		Node oldNode = cursor.getNext();
		if(cursor == oldNode)
			cursor = null;
		else {
			cursor.setNext(oldNode.getNext());
			oldNode.setNext(null);
		}
		size--;
		return oldNode;
	}
	
	public void print() {
		if(cursor == null) {
			System.out.println("List is empty");
			return;
		}
			
		Node temp = cursor;
		System.out.println("first temp value--->" + temp.getElement());
		advance();
		do {
			
			System.out.println(cursor.getElement());
			advance();
		}while(temp != cursor);
		
	}
}
