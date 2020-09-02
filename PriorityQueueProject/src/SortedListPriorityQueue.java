import java.security.InvalidKeyException;
import java.util.Comparator;

public class SortedListPriorityQueue<K,V> implements PriorityQueue<K, V>{
	protected PositionList<Entry<K,V>> entries;
	protected Comparator<K> c;
	protected Position<Entry<K,V>> actionPos;
	
	protected static class MyEntry<K,V> implements Entry<K, V>{
		protected K k;
		protected V v;
		
		public MyEntry(K key, V value) {
			k = key;
			v = value;
		}
		@Override
		public K getKey() {
			return k;
		}

		@Override
		public V getValue() {
			return v;
		}	
	}
	
	public SortedListPriorityQueue() {
		entries = new DNodePositionList<Entry<K,V>>();
		c = new DefaultComparator<K>();
	}
	public SortedListPriorityQueue(Comparator<K> comp){
		entries = new DNodePositionList<Entry<K,V>>();
		c = comp;
	}
	
	@Override
	public int size() {
		return entries.size();
	}

	@Override
	public boolean isEmpty() {
		if(entries.isEmpty())
			return true;
		return false;
	}

	@Override
	public Entry<K, V> min() throws EmptyPriorityQueueException,InvalidPositionException{
		if(entries.isEmpty())
			throw new EmptyPriorityQueueException("Priority queue is empty");
		return entries.first().element();
	}

	@Override
	public Entry<K, V> insert(K key, V value) throws InvalidKeyException,InvalidPositionException,BoundaryViolationException {
		// checkkey() to check the entry by aux method
		Entry<K,V> entry = new MyEntry<K,V>(key,value);
		insertEntry(entry);
		return entry;
	}
	
	public void insertEntry(Entry<K,V> e) throws InvalidPositionException,BoundaryViolationException{
		if(entries.isEmpty()) {
			entries.addFirst(e);
			actionPos = entries.first();
		}
		
		else if(c.compare(e.getKey(), entries.last().element().getKey()) > 0) {
			entries.addLast(e);
			actionPos = entries.last();
		}
		
		else {
			Position<Entry<K,V>> curr = entries.first();
			while(c.compare(e.getKey(), curr.element().getKey())>0) {
				curr = entries.next(curr);
			}
			entries.addBefore(curr, e);
			actionPos = entries.prev(curr);
		}
	}

	@Override
	public Entry<K, V> removeMin() throws EmptyPriorityQueueException,InvalidPositionException {
		if(entries.isEmpty())
			throw new EmptyPriorityQueueException("Priority queue is empty");
		return entries.remove(entries.first());
	}
}
