/**
 * This is Binary Tree class.
 * 
 * @author laraibpervez
 * @param <T> type parameter
 */
public class BinaryTree<T> implements BinaryTreeInterface<T> {
	/**
	 * Root Node.
	 */
	protected BinaryNode<T> rootNode;

	/**
	 * Constructor initializes root to null.
	 */
	public BinaryTree() {
		rootNode = null;
	}

	/**
	 * Constructor initializes the root node’s data.
	 * 
	 * @param data data
	 */
	public BinaryTree(T data) {
		rootNode = new BinaryNode<T>(data);
	}

	/**
	 * Constructor.
	 * 
	 * @param data      data
	 * @param leftNode  leftNode
	 * @param rightNode rightNode
	 */
	public BinaryTree(T data, BinaryNode<T> leftNode, BinaryNode<T> rightNode) {
		rootNode = new BinaryNode<T>(data, leftNode, rightNode);
	}

	/**
	 * Set Method.
	 * 
	 * @param data      data
	 * @param leftNode  leftNode
	 * @param rightNode rightNode
	 */
	public void setTree(T data, BinaryNode<T> leftNode, BinaryNode<T> rightNode) {
		rootNode.setData(data);
		rootNode.setLeftChild(leftNode);
		rootNode.setRightChild(rightNode);
	}

	/**
	 * In order Traversal.
	 * 
	 * @param node node
	 */
	public void inorderTraversal(BinaryNode<T> node) {
		if (node == null)
			return;

		inorderTraversal(node.getLeftChild());

		System.out.print(node.data + " ");

		inorderTraversal(node.getRightChild());
	}

	/**
	 * his method returns the data stored in the root node of a tree.
	 */
	@Override
	public T getRootData() {
		return rootNode.getData();
	}

	/**
	 * Getting Root Node.
	 * 
	 * @return BinaryNode
	 */
	@Override
	public BinaryNode<T> getRootNode() {
		return rootNode;
	}

	/**
	 * Setting Root Data.
	 * 
	 * @param rootData rootData
	 */
	@Override
	public void setRootNode(BinaryNode<T> rootData) {
		rootNode = rootData;
	}

	/**
	 * Returning the height.
	 * 
	 * @return integer
	 */
	@Override
	public int getHeight() {
		return rootNode.getHeight(rootNode);
	}

	/**
	 * Getting number of Nodes.
	 * 
	 * @return integer
	 */
	@Override
	public int getNumberOfNodes() {
		return rootNode.getNumberOfNodes(rootNode);
	}

	/**
	 * if the tree is empty.
	 */
	@Override
	public boolean isEmpty() {
		return rootNode == null;
	}

	/**
	 * clear everything.
	 */
	@Override
	public void clear() {
		rootNode = null;
	}

}

