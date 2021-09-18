/**
 * This is Decision Tree class.
 * 
 * @author laraibpervez
 * @param <T> type parameter
 */
public class DecisionTree<T> extends BinaryTree<T> implements DecisionTreeInterface<T> {
	/**
	 * Attributes.
	 */
	protected BinaryNode<T> currentNode;
	/**
	 * Attribute.
	 */
	protected BinaryNode<T> rootNode;

	/**
	 * initializes the attributes to null.
	 */
	public DecisionTree() {
		currentNode = null;
		rootNode = null;
	}

	/**
	 * initializes the root node’s data and the other attribute to null.
	 * 
	 * @param node node
	 */
	public DecisionTree(BinaryNode<T> node) {
		currentNode = node;
		rootNode = node;
	}

	/**
	 * if current node is leaf note that means its an answer.
	 */
	@Override
	public boolean isAnswer() {
		// if current node is leaf note that means its an answer
		return currentNode.isLeaf();
	}

	/**
	 * Moving to No.
	 */
	@Override
	public void moveToNo() {
		// TODO Auto-generated method stub
		if (currentNode.hasLeftChild()) {
			currentNode = currentNode.getLeftChild();
		}
	}

	/**
	 * Moving to yes.
	 */
	@Override
	public void moveToYes() {
		// TODO Auto-generated method stub
		if (currentNode.hasRightChild()) {
			currentNode = currentNode.getRightChild();
		}
	}

	/**
	 * Resetting the current Node.
	 */
	@Override
	public void resetCurrentNode() {
		// TODO Auto-generated method stub
		currentNode = rootNode;

	}

	/**
	 * Getting the current node.
	 * 
	 * @return currentNode
	 */
	@Override
	public BinaryNode<T> getCurrentNode() {
		// TODO Auto-generated method stub
		return currentNode;
	}

	/**
	 * Getting current Data.
	 */
	@Override
	public T getCurrentData() {
		// TODO Auto-generated method stub
		return currentNode.getData();
	}

	/**
	 * Setting the responses.
	 * 
	 * @param responseForNo  responseForNo
	 * @param responseForYes responseForYes
	 */
	@Override
	public void setResponses(T responseForNo, T responseForYes) {
		// TODO Auto-generated method stub
		BinaryNode<T> leftNode = new BinaryNode<T>(responseForNo);
		BinaryNode<T> rightNode = new BinaryNode<T>(responseForYes);

		currentNode.setLeftChild(leftNode);
		currentNode.setRightChild(rightNode);
	}
}

