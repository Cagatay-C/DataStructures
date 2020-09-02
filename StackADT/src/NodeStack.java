import java.util.EmptyStackException;

public class NodeStack<E> implements Stack<E>{
	protected Node<E> top;
	protected int size;

	public NodeStack(){
		top = null;
		size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0)
			return false;
		return true;
	}

	@Override
	public E top() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException();
		return (E)top.getElement();
	}

	@Override
	public void push(E element) {
		Node<E> newNode = new Node<E>((E)element,top);
		top = newNode;
		size++;
	}

	@Override
	public E pop() {
		E temp = top.getElement();
		top = top.getNext();
		size--;
		return temp;
	}
}
