import java.util.Iterator;

public class Test {
	public static<E> String toString(PositionList<E> I) {
		Iterator<E> it = I.iterator();
		String s="[";
		while(it.hasNext()) {
			s += it.next();
			if(it.hasNext())
				s += ", ";
		}
		s += "]";
		return s;
	}

	public static void main(String[] args) {
		DNodePositionList<Integer> list = new DNodePositionList<Integer>();
		list.addFirst(1);
		list.addLast(2);
		list.addLast(3);
		System.out.println(toString(list));
	}

}
