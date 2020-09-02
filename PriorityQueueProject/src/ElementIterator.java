import java.util.Iterator;
import java.util.NoSuchElementException;

public class ElementIterator<E> implements Iterator<E> {
	protected PositionList<E> list;
	protected Position<E> cursor;
	
	public ElementIterator(PositionList<E> L) {
		list = L;
		cursor = (list.isEmpty())? null:list.first();
	}
	
	@Override
	public boolean hasNext() {
		return (cursor!=null);
	}

	@Override
	public E next() throws NoSuchElementException{
		E toReturn = null;
		if(cursor == null)
			throw new NoSuchElementException("No next element");
		try {
			toReturn = cursor.element();
		} catch (InvalidPositionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			cursor = (cursor == list.last())? null:list.next(cursor);
		} catch (InvalidPositionException | BoundaryViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toReturn;
	}
}
