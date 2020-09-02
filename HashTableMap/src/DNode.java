
public class DNode<E> implements Position<E>{
	private E element;
	private DNode<E> prev, next;
	
	public DNode(E el, DNode<E> p, DNode<E> n) {
		element = el;
		next = n;
		prev = p;
	}
	
	public DNode<E> getPrev() {
		return prev;
	}
	
	public DNode<E> getNext() {
		return next;
	}
	
	public void setElement(E newElement) {
		element = newElement;
	}
	
	public void setPrev(DNode<E> p) {
		prev = p;
	}
	
	public void setNext(DNode<E> n) {
		next = n;
	}

	@Override
	public E element() throws InvalidPositionException{
		if(prev == null && next == null)
			throw new InvalidPositionException("Position is not in a list!");
		
		return (E) element;
	}
}
