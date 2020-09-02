import java.util.Comparator;

public class DefaultComparator<K> implements Comparator<K> {
	@Override
	public int compare(K o1, K o2) throws ClassCastException{
		return ((Comparable<K>) o1).compareTo(o2);
	}
}
