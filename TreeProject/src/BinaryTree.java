
public class BinaryTree<E> {
	private Node<E> root;
	
	public BinaryTree() {
		this(null);
	}
	public BinaryTree(Node<E> r) {
		root = r;
	}
	public Node<E> getRoot() {
		return root;
	}
	public void setRoot(Node<E> root) {
		this.root = root;
	}
	
	public void printPreOrder(Node<E> node) {
		if(node == null)
			return;
		System.out.print(node.getElement() + " ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}
	
	public void printInOrder(Node<E> node) {
		if(node == null)
			return;
		printInOrder(node.left);
		System.out.print(node.getElement() + " ");
		printInOrder(node.right);
	}
	
	public void printPostOrder(Node<E> node) {
		if(node == null)
			return;
		
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.getElement() + " ");
	}
}
