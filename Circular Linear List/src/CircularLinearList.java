public class CircularLinearList<E> {
	private Node<E> list;

	public CircularLinearList(){
		list = null;
	}
	public CircularLinearList(Node<E> list){
		this.list = list;
	}

	//this method should print the elements of the list from left to right
	public String toString() {
		StringBuilder listString = new StringBuilder("( ");

		Node<E> current = list;

		boolean first = true;

		if (current != null) {
			do {
				current = current.getNext();
				if (first) {
					listString.append(current.getKey());
					first = false;
				} // end if
				else {

					listString.append(", " + current.getKey());
				} //end else

			} while (current != list);
		}

		listString.append(" )");
		return listString.toString();
	}

	public void leftInsert(E key) {
		Node<E> current = new Node<E>(key);

		if (list == null){
			current.setNext(current);
			list = current;
		} else{
			current.setNext(list.getNext());
			list.setNext(current);
		}
	}

	public void rightInsert(E key) {
		leftInsert(key);
		list = list.getNext();
	}

	public E deleteLeft(){
		Node<E> current = list;
		E keyToBeDeleted = null;

		if (list == null){
			System.out.println("Circular Linear List is Empty!");
		} else{
			current = list.getNext();
			keyToBeDeleted = current.getKey();
			list.setNext(current.getNext());
		}

		if (current == list){
			list = null;
		}

		return keyToBeDeleted;
	}

	public E deleteRight(){
		Node<E> current = list;
		Node<E> previous = null;
		E keyToBeDeleted = null;

		if (list == null){
			System.out.println("Circular Linear List is Empty!");
		}

		else if (current.getNext() == current){
			keyToBeDeleted = list.getKey();
			list = null;
		}

		else {
			while (current.getNext() != list) {
				previous = current;
				current = current.getNext();
			}
			keyToBeDeleted = list.getKey();
			current.setNext(list.getNext());
			list = current;
		}

		return keyToBeDeleted;
	}

	public static void main(String[] args){

		CircularLinearList<String> list = new CircularLinearList<String>();
		list.leftInsert("Hello");
		list.rightInsert("World");

		System.out.println(list);
		//Should print : (Hello, World)

		list.leftInsert("Computer");
		list.rightInsert("Science");

		System.out.println(list.deleteLeft());
		//Should print : Computer

		System.out.println(list.deleteRight());
		//Should print : Science
	}
}
