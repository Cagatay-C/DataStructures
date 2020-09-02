
public class Test {
	public static void main(String[] args) {
		DNodeList dlist = new DNodeList();
		DNode node1 = new DNode("cagatay",null,null);
		DNode node2 = new DNode("caglar",null,null);
		DNode node3 = new DNode("cagan",null,null);
		
		System.out.println("is Empty? " + dlist.isEmpty());
		dlist.addFirst(node1);
		dlist.addAfter(node1, node2);
		dlist.addAfter(node1, node3);
		System.out.println("is Empty? " + dlist.isEmpty());
		dlist.remove(node1);
		dlist.print();
	}
}
