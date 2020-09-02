import java.util.EmptyStackException;

public class QueueWithArray<E> implements Queue<E>{

	private static final int CAPACITY = 100;
	private int cap;
	private Object[] que;
	private int f,r;
	private int size;
	
	public QueueWithArray() {
		this(CAPACITY);
	}
	
	public QueueWithArray(int cap) {
		que = new Object[cap];
		size = 0;
		f = r = 0;
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
	public E front(){
		if(size() == 0) {
			
		}
		return (E)que[f];
	}

	@Override
	public void enqueue(E element) throws QueueException {
		if(size() >= que.length) {
				throw new QueueException("Queue is full");
		}
		que[r] = element;
		r = (r+1) % que.length;
		size++;
	}

	@Override
	public E dequeue() throws QueueException {
		if(size() == 0)
			throw new QueueException("Queue is empty");
		E temp = (E)que[f];
		f = (f + 1) % que.length;
		return temp;
	}
	
	public void print() {
		for(int i=f; i<que.length; i++)
			System.out.println(que[i]);
		System.out.println("-");
	}
}
