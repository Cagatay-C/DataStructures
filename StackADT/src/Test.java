
public class Test {
	
	public static <E> void reverse(E[] a) {
		Stack<E> S = new ArrayStack<E>();
		for(int i=0; i<a.length; i++)
			S.push(a[i]);
		for(int i=0; i<a.length; i++)
			a[i] = S.pop();
	}

	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<Integer>();
		stack.print();
		stack.push(1);
		stack.push(2);
		stack.push(10);
		stack.print();
		stack.pop();
		stack.print();
	}
}
