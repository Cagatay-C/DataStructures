import java.util.Iterator;

public class DNodePositionList<E> implements PositionList<E>{
	private DNode<E> header,trailer;
	private int size;
	
	public DNodePositionList() {
		header = new DNode<E>(null,null,null);
		trailer = new DNode<E>(null,header,null);
		header.setNext(trailer);
		size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}
	
	private DNode<E> checkPosition(Position<E> p) throws InvalidPositionException{
		if(p == null)
			throw new InvalidPositionException("Null position passed to NodeList");
		if(p == header)
			throw new InvalidPositionException("The header is not a valid position");
		if(p == trailer)
			throw new InvalidPositionException("The trailer is not a valid position");
		
		try {
			DNode<E> n = (DNode<E>) p;
			if(n.getPrev() == null && n.getNext() == null)
				throw new InvalidPositionException("Position does not belong to a valid NodeList");
			return n;
		} catch (ClassCastException e) {
			throw new InvalidPositionException("Position is of wrong type for this list");
		}
	}

	@Override
	public Position<E> first(){
		Position<E> firstPos = (Position<E>)header.getNext();
		return firstPos;
	}

	@Override
	public Position<E> last() {
		Position<E> lastPos = (Position<E>)trailer.getPrev();
		return lastPos;
	}

	@Override
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNode<E> temp = checkPosition(p);		
		return (Position<E>)temp.getNext();
	}

	@Override
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNode<E> temp = checkPosition(p);
		return (Position<E>)temp.getPrev();
	}

	@Override
	public void addFirst(E e) {
		DNode<E> newNode = new DNode<E>(e,header,header.getNext());
		header.getNext().setPrev(newNode);
		header.setNext(newNode);
		size++;
	}

	@Override
	public void addLast(E e) {
		DNode<E> newNode = new DNode<E>(e,trailer.getPrev(),trailer);
		trailer.getPrev().setNext(newNode);
		trailer.setPrev(newNode);
		size++;
	}

	@Override
	public void addAfter(Position<E> p, E e) throws InvalidPositionException {
		DNode<E> prevNode = checkPosition(p);
		DNode<E> newNode = new DNode<E>(e,prevNode,prevNode.getNext());
		prevNode.setNext(newNode);
		size++;
	}

	@Override
	public void addBefore(Position<E> p, E e) throws InvalidPositionException {
		DNode<E> nextNode = checkPosition(p);
		DNode<E> newNode = new DNode<E>(e,nextNode.getPrev(),nextNode);
		nextNode.setPrev(newNode);
		size++;
	}

	@Override
	public E remove(Position<E> p) throws InvalidPositionException {
		DNode<E> oldNode = checkPosition(p);
		oldNode.getPrev().setNext(oldNode.getNext());
		oldNode.getNext().setPrev(oldNode.getPrev());
		oldNode.setNext(null);
		oldNode.setPrev(null);
		size--;
		return oldNode.element();
	}

	@Override
	public E set(Position<E> p, E e) throws InvalidPositionException {
		DNode<E> node = checkPosition(p);
		E oldEl = node.element();
		node.setElement(e);
		return oldEl;
	}

	@Override
	public Iterator<E> iterator(){
		return new ElementIterator<E>(this);
	}

	@Override
	public Iterable<Position<E>> positions() throws InvalidPositionException, BoundaryViolationException, EmptyListException {
		PositionList<Position<E>> P = new DNodePositionList<Position<E>>();
		if(!isEmpty()) {
			Position<E> p = first();
			while(true) {
				P.addLast(p);
				if(p == last()) {
					break;
				}
				p = next(p);
			}
		}
		
		return P;
	}
}
