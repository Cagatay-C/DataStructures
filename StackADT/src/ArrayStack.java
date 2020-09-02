import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E>{

	public static final int CAPACITY = 100;
	protected int capacity;
	protected E[] S;
	protected int top = -1;
	
	public ArrayStack() {
		this(CAPACITY);
	}
	
	public ArrayStack(int cap) {
		capacity = cap;
		S = (E[]) new Object[capacity];
	}
	
	@Override
	public int size() {	
		return top+1;
	}

	@Override
	public boolean isEmpty() {
		if(top == -1)
			return true;
		return false;
	}

	@Override
	public E top(){
		if(top == -1)
			throw new EmptyStackException();
		return S[top];
	}

	@Override
	public void push(E element) {
		if(size() >= capacity) {
			System.out.println("Stack is full");
			return;
		}
		top++;
		S[top] = element;
	}

	@Override
	public E pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		E element = S[top];
		S[top--] = null;
		return element;
	}
	
	public void print() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}
		if(top >= 0)
			System.out.print(S[0]);
		for(int i=1; i<=top; i++)
			System.out.print("-" + S[i]);
	}
}
