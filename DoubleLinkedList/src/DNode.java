
public class DNode {
	protected String element;
	protected DNode prev, next;
	
	public DNode(String el, DNode p, DNode n) {
		element = el;
		next = n;
		prev = p;
	}
	
	public String getElement() {
		return element;
	}
	
	public DNode getPrev() {
		return prev;
	}
	
	public DNode getNext() {
		return next;
	}
	
	public void setElement(String newElement) {
		element = newElement;
	}
	
	public void setPrev(DNode p) {
		prev = p;
	}
	
	public void setNext(DNode n) {
		next = n;
	}
}
