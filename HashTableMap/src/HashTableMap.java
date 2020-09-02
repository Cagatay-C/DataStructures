import java.security.InvalidKeyException;
import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class HashTableMap<K,V> implements Map<K,V> {
	
	public static class HashEntry<K,V> implements Entry<K,V>{
		
		private K key;
		private V value;
		
		public HashEntry(K k, V v) {
			key = k;
			value = v;
		}
		
		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V v) {
			V oldValue = value; 
			value = v;
			return oldValue;
		}
	}
	
	private Entry<K,V> AVAILABLE =	new HashEntry<K,V>(null,null);
	private int n = 0;
	private int capacity;
	private Entry<K,V>[] bucket;
	private int scale,shift;
	
	public HashTableMap() {
		this(1023);
	}

	public HashTableMap(int cap) {
		capacity = cap;
		bucket = (Entry<K,V>[]) new Entry[capacity];
		Random rand = new Random();
		scale = rand.nextInt(capacity - 1) + 1;
		shift = rand.nextInt(capacity);
	}
	
	private int findEntry(K key) throws InvalidKeyException{
		int avail = -1;
		int i = hashValue(key);
		int j = i;
		
		do {
			Entry<K,V> e = bucket[i];
			if(e == null) {
				if(avail == -1) {
					break; // key is not in table
				}
			}
			
			if(key.equals(e.getKey())) {
				return i; // key found
			}
			
			if(e == AVAILABLE) {
				if(avail < 0) {
					avail = i;
				}
			}
			
			i = (i + 1) % capacity;
			
		}while(i != j);
		
		return -(avail + 1);
	}
	
	private void checkKey(K i) throws InvalidKeyException{
		if(i == null) throw new InvalidKeyException("Invalid key: null.");
	}
	
	public int hashValue(K key) {
		return Math.abs(key.hashCode() * scale + shift) % capacity;
	}
	
	public Iterable<K> keys(){
		PositionList<K> keys = new DNodePositionList<K>();
		for(int i=0; i<capacity; i++) {
			if(bucket[i] != null && bucket[i] != AVAILABLE) {
				keys.addLast(bucket[i].getKey());
			}
		}
		return keys;
	}

	
	@Override
	public void clear() {
		
	}

	@Override
	public boolean containsKey(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	public V getV(K k) throws InvalidKeyException {
		
		int	i = findEntry(k);
		
		if(i < 0) {
			return null;
		}
		return bucket[i].getValue();
	}

	@Override
	public boolean isEmpty() {
		if(n == 0)
			return true;
		return false;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	public V putV(K key, V value) throws InvalidKeyException{
		int i = 0;
			i = findEntry(key);
		if(i >= 0) {
			return (V)bucket[i].setValue(value);
		}
		
		if(n >= capacity/2) {
			rehash();
			i = findEntry(key);
		}
		
		bucket[-i-1] = new HashEntry<K,V>(key, value);
		n++;
		return null;
	}

	private void rehash() throws InvalidKeyException {
		capacity = capacity * 2;
		Entry<K, V>[] old = bucket;
		bucket = (Entry<K, V>[])new Entry[capacity];
		Random rand = new Random();
		scale = rand.nextInt(capacity - 1) + 1;
		shift = rand.nextInt(capacity);
		
		for(int i=0; i<old.length; i++) {
			Entry<K, V> e = old[i];
			if(e != null && e != AVAILABLE) {
				int j = -1-findEntry(e.getKey());
				bucket[j] = e;
			}
		}
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public V removeV(K key) throws InvalidKeyException{
		int i = findEntry(key);
		if(i < 0)
			return null;
		V toReturn = bucket[i].getValue();
		bucket[i] = AVAILABLE;
		n--;
		
		return toReturn;
	}

	@Override
	public int size() {
		return  n;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

}
