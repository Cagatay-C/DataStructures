
public class Test {

	public static void main(String[] args) {
		CircleList list = new CircleList();
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		
		list.add(node1);
		list.add(node2);
		list.add(node3);
		list.add(node4);
		list.add(node5);	
		list.add(node6);	
		list.remove();
		list.remove();
		list.remove();
		list.remove();
		list.remove();
		list.remove();
		list.print();
	}

}
