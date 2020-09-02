
public class DNodeList {
	protected DNode header,trailer;
	protected int size;
	
	public DNodeList() {
		size = 0;
		header = new DNode(null,null,null); // try with trailer
		trailer = new DNode(null,header,null);
		header.setNext(trailer);
	}
	
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}
	
	public DNode getLast() throws IllegalStateException{
		if(isEmpty())
			throw new IllegalStateException("List is empty");
		return trailer.getPrev();
	}
	
	public void addAfter(DNode f, DNode s) {
		DNode temp = f.getNext();
		f.setNext(s);
		s.setNext(temp);
		s.setPrev(f);
		temp.setPrev(s);
		size++;
	}
	
	public void addFirst(DNode newNode) throws IllegalStateException{
		if(isEmpty()) {
			addAfter(header,newNode);
			return;
		}
		throw new IllegalStateException("List already has its header");
	}
	
	public void remove(DNode node) {
		DNode tempNext = node.getNext();
		DNode tempPrev = node.getPrev();
		tempPrev.setNext(tempNext);
		tempNext.setPrev(tempPrev);
		node.setPrev(null);
		node.setNext(null);
		size--;
	}
	
	public void print() {
		if(isEmpty())
			System.out.println("List is Empty");
		DNode temp = header.getNext();
		while(temp != trailer) {
			System.out.println(temp.getElement());
			temp = temp.getNext();
		}	
	}
}
