
public class Test {

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		
		SLinkedList list = new SLinkedList();
		list.addFirst(node1);
		list.addLast(node2);
		list.addLast(node3);
		list.print();
		System.out.println("-----");
		list.removeFirst();
		System.out.println("after remove head---> head is ");
		list.printHead();
		System.out.println("---------");
		list.print();
	}

}
