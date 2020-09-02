
public class Test {

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>(new Node<Integer>(3,null,null));
		tree.getRoot().right = new Node<Integer>(4,null,null);
		tree.getRoot().left = new Node<Integer>(1,null,null);
//		tree.printInOrder(tree.getRoot());
//		tree.printPreOrder(tree.getRoot());
//		tree.printPostOrder(tree.getRoot());

	}

}
