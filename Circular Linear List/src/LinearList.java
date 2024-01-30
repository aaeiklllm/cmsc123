public class LinearList<E> {
	private Node<E> list;
	
	public LinearList() {
		list = null;
	} // end constructor
	
	public LinearList(Node<E> list) {
		this.list = list;
	}
	
	public String toString() {
		StringBuilder listString = new StringBuilder("( ");
		
		Node<E> current = list;
		
		boolean first = true;
		while (current != null) {
			if (first) {
				listString.append(current.getKey());	
				first = false;
			} // end if
			else {
				listString.append(", " + current.getKey());
			} //end else
			
			current = current.getNext();
		}
		listString.append(" )");
		
		return listString.toString();
	} // end toString
	
	/**
	 * Inserts <code>newKey</code> before the position of <code>relativeKey</code>
	 * in the list
	 * 
	 * @param newKey new key to be inserted
	 * @param relativeKey new key will be inserted before this key in the list
	 */
	public void insert(E newKey, E relativeKey) {
		Node<E> newNode = new Node<E>(newKey);
		
		Node<E> current = list;
		Node<E> previous = null;
		while(true) {
			if ((current == null) || current.getKey().equals(relativeKey)) {
				if (current == list) {
					list = newNode;
				} // end if
				else {
					previous.setNext(newNode);
				} // end else
				newNode.setNext(current);
				return;
			} // end if
			else {
				previous = current;
				current = current.getNext();
			} // end else
		} // end while
	} // end insert
	
	/**
	 * Deletes <code>key</code> from the list and returns it
	 * 
	 * @param key key to be deleted
	 * @return the deleted key. If <code>key</code> is not in the list
	 * null is returned.
	 */
	public E delete(E key) {
		Node<E> current = list;
		Node<E> previous = null;
		while(current != null) {
			if (current.getKey().equals(key)) {
				if (current == list) {
					list = list.getNext();
				} // end if
				else {
					previous.setNext(current.getNext());
				} // end else
				E keyToReturn = current.getKey();
				current = null;
				return keyToReturn;
			} // end if
			else {
				previous = current;
				current = current.getNext();
			} // end else
		} // end while
		
		return null;
	} // end delete
	
	public static void main(String[] args) {		
		LinearList<Integer> list = new LinearList<Integer>();
		
		list.insert(1, null);
		list.insert(2, null);
		list.insert(3, null);
		System.out.println("Before insert: " + list);
		
		list.insert(4, 1);
		list.insert(5, 2);
		list.insert(6, 3);
		list.insert(7, 8);		
		System.out.println("After insert: " + list);
		
		list.delete(1);
		list.delete(6);
		list.delete(4);
		list.delete(7);
		System.out.println("After delete: " + list);
	} // end main
} // end class
