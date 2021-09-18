/**
 * This is Binary Tree Interface.
 * @author laraibpervez
 * @param <T> type Parameter
 */
public interface BinaryTreeInterface<T> {
	/**
	 * Getting the root data.
	 * @return T 
	 */
	public T getRootData();

	/**
	 * Getting root node.
	 * @return BinaryNode
	 */
	public BinaryNode<T> getRootNode();

	/**
	 * This method sets the root node of a tree.
	 * @param rootData rootData
	 */
	public void setRootNode(BinaryNode<T> rootData);

	/**
	 * Getting the height.
	 * @return integer
	 */
	public int getHeight();

	/**
	 * Getting number of nodes.
	 * @return integer
	 */
	public int getNumberOfNodes();

	/**
	 * True, if a tree is empty, false otherwise.
	 * @return boolean
	 */
	public boolean isEmpty();

	/**
	 * Clears a tree.
	 */
	public void clear();

}
