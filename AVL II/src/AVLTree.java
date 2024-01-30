public class AVLTree<E extends Comparable<E>> extends BinarySearchTree<E> {
	private AVLNode<E> root;

	public AVLTree() {
		root = null;
	}

	public AVLTree(AVLNode<E> root) {
		this.root = root;
	}

	@Override
	public void insert(E key) {
		root = insertNode(root, key);
	}

	@Override
	public void delete(E key) {
		root = deleteNode(root, key);
	}

	private int height (AVLNode<E> root){
		if (root == null){
			return -1;
		}
		else{
			return root.getHeight();
		}
	}

	private int balanceFactor(AVLNode<E> root){
		if (root == null){
			return 0;
		}

		else{
			return height(root.getRightChild()) - height(root.getLeftChild());
		}
	}

	private void updateHeight(AVLNode<E> root){
		root.setHeight(Math.max(height(root.getRightChild()), height(root.getLeftChild())) + 1);
	}

	private AVLNode<E> rightRotation(AVLNode<E> root){
		AVLNode<E> newRoot = root.getLeftChild();
		root.setLeftChild(newRoot.getRightChild());
		newRoot.setRightChild(root);

		root.setBalanceFactor(0);
		newRoot.setBalanceFactor(0);
		updateHeight(root);
		updateHeight(newRoot);
		return newRoot;
	}

	private AVLNode<E> leftRotation(AVLNode<E> root){
		AVLNode<E> newRoot = root.getRightChild();
		root.setRightChild(newRoot.getLeftChild());
		newRoot.setLeftChild(root);

		root.setBalanceFactor(0);
		newRoot.setBalanceFactor(0);
		updateHeight(root);
		updateHeight(newRoot);
		return newRoot;
	}

	//When rotating (rebalancing) a tree, you have to keep the nodes' order (Left, lesser; Right, greater)
	private AVLNode<E> rebalanceTree(AVLNode<E> root){
		updateHeight(root);

		int balanceFactor = balanceFactor(root);
		root.setBalanceFactor(balanceFactor);

		if (balanceFactor > 1){ //Skewed to the right (Left or Right-Left Rotation)
			if (balanceFactor(root.getRightChild()) < 0){ //Skewed to the left
				//Right-left
				root.setRightChild(rightRotation(root.getRightChild()));
			}
			//Left
			return leftRotation(root);
		}

		else if (balanceFactor < -1) { //Skewed to the left (Right or Left-Right Rotation)
			if (balanceFactor(root.getLeftChild()) > 0){ //Skewed to the right
				//Left-right
				root.setLeftChild(leftRotation(root.getLeftChild()));
			}
			//Right
			return rightRotation(root);
		}
		return root;
	}

	public AVLNode<E> getMinimum (AVLNode <E> root){
		while (root.getLeftChild() != null){
			root = getMinimum(root.getLeftChild());
		}
		return root;
	}

	public AVLNode<E> insertNode (AVLNode<E> root, E key){
		if (root == null){
			return new AVLNode<E>(key);
		}

		else if (key.compareTo(root.getKey()) < 0 ){
			root.setLeftChild(insertNode(root.getLeftChild(), key));

		}

		else if (key.compareTo(root.getKey()) >= 0 ){
			root.setRightChild(insertNode(root.getRightChild(), key));
		}

		else{
			return root;
		}
		return rebalanceTree(root);
	}

	public AVLNode<E> deleteNode (AVLNode<E> root, E key){ //Three cases
		//No child
		if (root == null){
			return null;
		}

		else if (key.compareTo(root.getKey()) < 0){
			root.setLeftChild(deleteNode(root.getLeftChild(), key));
		}

		else if (key.compareTo(root.getKey()) > 0){
			root.setRightChild(deleteNode(root.getRightChild(), key));
		}

		else{
			if (root.getLeftChild() == null && root.getRightChild() == null){
				return null;
			}

			//One child
			else if (root.getLeftChild() == null || root.getRightChild() == null){
				if (root.getLeftChild() == null){
					return rebalanceTree(root.getRightChild());
				}

				else if (root.getRightChild() == null){
					return rebalanceTree(root.getLeftChild());
				}
			}

			//Two children
			else{
				AVLNode<E> successor = getMinimum(root.getRightChild());
				root.setKey(successor.getKey());
				root.setRightChild(deleteNode(successor, successor.getKey()));
			}
		}
		return rebalanceTree(root);
	}


	public String preorder() {
		StringBuilder preorderTraversal = new StringBuilder();
		preorderSupport(root, preorderTraversal);
		return preorderTraversal.toString();
	}

	private void preorderSupport(AVLNode<E> root, StringBuilder preorder) {
		if (root != null) {
			preorder.append(root + " ");
			preorderSupport(root.getLeftChild(), preorder);
			preorderSupport(root.getRightChild(), preorder);
		}
	}

	public String inorder() {
		StringBuilder inorderTraversal = new StringBuilder();
		inorderSupport(root, inorderTraversal);
		return inorderTraversal.toString();
	}

	private void inorderSupport(AVLNode<E> root, StringBuilder inorder) {
		if (root != null) {
			inorderSupport(root.getLeftChild(), inorder);
			inorder.append(root +  " ");
			inorderSupport(root.getRightChild(), inorder);
		}
	}

	public String postorder() {
		StringBuilder postorderTraversal = new StringBuilder();
		postorderSupport(root, postorderTraversal);
		return postorderTraversal.toString();
	}

	private void postorderSupport(AVLNode<E> root, StringBuilder postorder) {
		if (root != null) {
			postorderSupport(root.getLeftChild(), postorder);
			postorderSupport(root.getRightChild(), postorder);
			postorder.append(root + " ");
		}
	}

	public String levelorder() {
		StringBuilder levelOrderTraversal = new StringBuilder();
		int height = getHeight(root);
		for (int i = 1; i <= height; ++i){
			levelOrderSupport(root, levelOrderTraversal, i);
		}
		return levelOrderTraversal.toString();
	}

	public int getHeight(AVLNode<E> root){
		if (root == null){
			return 0;
		}
		else {
			int leftHeight = getHeight(root.getLeftChild());
			int rightHeight = getHeight(root.getRightChild());

			if (leftHeight > rightHeight) {
				return (leftHeight + 1);
			} else {
				return (rightHeight + 1);
			}
		}
	}

	private void levelOrderSupport(AVLNode<E> root, StringBuilder levelorder, int level) {
		if (root != null) {
			if (level == 1) {
				levelorder.append(root + " ");
			}

			else if (level > 1){
				levelOrderSupport(root.getLeftChild(), levelorder, level-1);
				levelOrderSupport(root.getRightChild(), levelorder, level-1);
			}
		}
	}
}


