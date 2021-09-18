/**
 * This is Binary Node Class.
 * 
 * @author laraibpervez
 * @param <T> type parameter
 */
public class BinaryNode<T> {
	/**
	 * T data.
	 */
	protected T data;
	/**
	 * Left Node.
	 */
	private BinaryNode<T> leftChild;
	/**
	 * Right Node.
	 */
	protected BinaryNode<T> rightChild;

	/**
	 * Constructor.
	 */
	public BinaryNode() {
		data = null;
		leftChild = null;
		rightChild = null;

	}

	/**
	 * constructor.
	 * 
	 * @param data data
	 */
	public BinaryNode(T data) {
		this.data = data;
		leftChild = null;
		rightChild = null;

	}

	/**
	 * Constructor.
	 * 
	 * @param data      data
	 * @param leftNode  leftNode
	 * @param rightNode righttNode
	 */
	public BinaryNode(T data, BinaryNode<T> leftNode, BinaryNode<T> rightNode) {
		this.data = data;
		this.leftChild = leftNode;
		this.rightChild = rightNode;
	}

	/**
	 * Set Data.
	 * 
	 * @param data data
	 */
	public void setData(T data) {
		this.data = data;

	}

	/**
	 * Get Method.
	 * 
	 * @return data
	 */
	public T getData() {
		return data;
	}

	/**
	 * Set method.
	 * 
	 * @param leftChild leftChild
	 */
	public void setLeftChild(BinaryNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * Get Method.
	 * 
	 * @return leftChild
	 */
	public BinaryNode<T> getLeftChild() {
		return leftChild;
	}

	/**
	 * Set method.
	 * 
	 * @param rightChild rightChild
	 */
	public void setRightChild(BinaryNode<T> rightChild) {
		this.rightChild = rightChild;
	}

	/**
	 * Get Method.
	 * 
	 * @return rightChild
	 */
	public BinaryNode<T> getRightChild() {
		return rightChild;
	}

	/**
	 * If the method contains left child.
	 * 
	 * @return boolean
	 */
	public boolean hasLeftChild() {
		return leftChild != null;
	}

	/**
	 * If the method contains right child.
	 * 
	 * @return boolean
	 */
	public boolean hasRightChild() {
		return rightChild != null;
	}

	/**
	 * Returns true, if a node is a leaf, false otherwise.
	 * 
	 * @return boolean
	 */
	public boolean isLeaf() {
		return ((leftChild == null && rightChild == null)
				|| (leftChild.getData().equals("null") && rightChild.getData().equals("null")));
	}

	/**
	 * Getting the height of a tree rooted at the node.
	 * 
	 * @param node node
	 * @return integer
	 */
	public int getHeight(BinaryNode<T> node) {
		if (node == null) {
			return -1;
		} else {
			return 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
		}
	}

	/**
	 * This method returns the number of nodes in a tree rooted at the node.
	 * 
	 * @param node node
	 * @return integer
	 */
	public int getNumberOfNodes(BinaryNode<T> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + getNumberOfNodes(node.getLeftChild()) + getNumberOfNodes(node.getRightChild());
		}
	}

	/**
	 * copy the subtree rooted at a node and returns the root of the copied subtree.
	 * 
	 * @return BinaryNode
	 */
	public BinaryNode<T> copy() {
		BinaryNode<T> newRoot = new BinaryNode<T>(data);
		newRoot.setLeftChild(leftChild);
		newRoot.setRightChild(rightChild);

		return newRoot;
	}
}
