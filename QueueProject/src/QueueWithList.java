
public class QueueWithList<E> implements Queue{

	protected Node<E> head,tail;
	protected int size;
	
	public QueueWithList() {
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

	@Override
	public Object front() {
		return head.getElement();
	}

	@Override
	public void enqueue(Object element) {
		Node newNode = new Node(element, null);
		if(size == 0)
			head = newNode;
		else 
			tail.setNext(newNode);
		tail = newNode;
		size++;
	}

	@Override
	public Object dequeue() {
		if(size == 0)
			System.out.println("Queue is empty");
		E temp = head.getElement();
		head = head.getNext();
		size--;
		if(size == 0)
			tail = null;
		return temp;
	}
	
	public void print() {
		Node<E> temp = head;
		if(size() == 0)
			System.out.println("List is empty");
		while(temp != null) {
			System.out.println(temp.getElement());
			temp = temp.getNext();
		}
	}
}
