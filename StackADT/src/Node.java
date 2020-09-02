
public class Node<E> {
	private Node<E> next;
	private E element;
	
	public Node(E el, Node<E> n) {
		element = (E)el;
		next = n;
	}
	
	public void setNext(Node<E> n) {
		next = n;
	}
	
	public Node<E> getNext() {
		return next;
	}
	
	public E getElement() {
		return element;
	}
}
