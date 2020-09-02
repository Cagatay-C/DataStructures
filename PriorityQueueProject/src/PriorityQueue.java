import java.security.InvalidKeyException;

public interface PriorityQueue<K,V> {
	public int size();
	public boolean isEmpty();
	public Entry<K,V> min() throws EmptyPriorityQueueException, InvalidPositionException;
	public Entry<K,V> insert(K key, V value) throws InvalidKeyException, InvalidPositionException, BoundaryViolationException;
	public Entry<K,V> removeMin() throws EmptyPriorityQueueException, InvalidPositionException;
}
