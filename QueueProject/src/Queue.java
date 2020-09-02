
public interface Queue<E> {
	public int size();
	public boolean isEmpty();
	public E front();
	public void enqueue(E element) throws QueueException;
	public E dequeue() throws QueueException;
}
