/**
 * Node for an AVL tree
 *
 * @author Richard Bryann Chua
 *
 * @param <E> Data type that is to be stored in the AVL node
 */
public class AVLNode<E extends Comparable<E>> extends BSTNode<E> {
	private E key;
	private AVLNode<E> lChild;
	private AVLNode<E> rChild;
	private AVLNode<E> parent;
	private int bf;			// balance factor of the AVL node
	int height = 0;


	public AVLNode() {
		key = null;
		lChild = null;
		rChild = null;
		parent = null;
		bf = 0;
	}

	public AVLNode(E key) {
		this.key = key;
		lChild = null;
		rChild = null;
		parent = null;
		bf = 0;
	}

	public AVLNode(E key, AVLNode<E> parent, AVLNode<E> lChild, AVLNode<E> rChild) {
		this.key = key;
		this.lChild = lChild;
		this.rChild = rChild;
		this.parent = parent;
		bf = 0;
	}

	public E getKey(){
		return key;
	}

	public AVLNode<E> getLeftChild(){
		return lChild;
	}

	public AVLNode<E> getRightChild(){
		return rChild;
	}

	public AVLNode<E> getParent(){
		return parent;
	}

	public int getHeight(){
		return height;
	}

	public void setKey(E key) {
		this.key = key;
	}

	public void setLeftChild(AVLNode<E> lChild) {
		this.lChild = lChild;
	}

	public void setRightChild(AVLNode<E> rChild) {
		this.rChild = rChild;
	}
	public void setParent(AVLNode<E> parent) {
		this.parent = parent;
	}
	public void setHeight(int height){
		this.height = height;
	}

	/**
	 * Sets the balance factor of the AVL node
	 *
	 * @param bf new balance factor of the AVL node
	 */
	public void setBalanceFactor(int bf) {
		this.bf = bf;
	} // end setBalanceFactor

	/**
	 * Returns the balance factor of the AVL node
	 *
	 * @return balance factor of the AVL node
	 */
	public int getBalanceFactor() {
		return bf;
	} // end getBalanceFactor

	@Override
	public String toString() {
		return "(key = " + getKey() + " BF = " + getBalanceFactor() + ")";
	}
} // end class
