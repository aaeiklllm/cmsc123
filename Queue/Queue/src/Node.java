

public class Node<E> {
	private E key;
	private Node<E> next;
	
	public Node() {
		this(null, null);
	} // end constructor
	
	public Node(E key) {
		this(key, null);
	} // end constructor
	
	
	public Node(E key, Node<E> next) {
		this.key = key;
		this.next = next;
	} // end constructor
	
	public void setKey(E key) {
		this.key = key;
	} // void setKey
	
	public void setNext(Node<E> next) {
		this.next = next;
	} // void setNext
	
	public E getKey() {
		return key;
	} // end getKey
	
	public Node<E> getNext() {
		return next;
	} // end getNext
} // end class
