
public class Node<E> {
	private E element;
	Node<E> right,left;
	
	public Node(E el, Node<E> r, Node<E> l) {
		element = el;
		right = r;
		left = l;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public Node<E> getRight() {
		return right;
	}
	public Node<E> getLeft() {
		return left;
	}

}
