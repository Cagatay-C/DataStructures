
public class Test {

	public static void main(String[] args) throws QueueException {
		QueueWithArray<Integer> list = new QueueWithArray<Integer>(4);
		list.enqueue(1);
		list.enqueue(2);
		list.enqueue(3);
		list.enqueue(4);
		list.print();
		list.dequeue();
		list.dequeue();
		list.print();	
	}
}
