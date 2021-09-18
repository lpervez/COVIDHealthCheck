/**
 * This is Decision Tree Interface.
 * 
 * @author laraibpervez
 *
 * @param <T> type Parameter
 */
public interface DecisionTreeInterface<T> {
	/**
	 * Returning an answer.
	 * 
	 * @return boolean
	 */
	boolean isAnswer();

	/**
	 * Set the current node to its left child. Note that the current node should not
	 * be null.
	 */
	void moveToNo();

	/**
	 * Set the current node to its right child. Note that the current node should
	 * not be null.
	 */
	void moveToYes();

	/**
	 * Set the current node to the root.
	 */
	void resetCurrentNode();

	/**
	 * Getting the current node.
	 * 
	 * @return the reference to the current node
	 */
	BinaryNode<T> getCurrentNode();

	/**
	 * Getting the current data.
	 * 
	 * @return the data portion of the current node.
	 */
	T getCurrentData();

	/**
	 * Sets the data in the children (left and right) of the current node.
	 * 
	 * @param responseForNo  responseForNo
	 * @param responseForYes responseForYes
	 */
	void setResponses(T responseForNo, T responseForYes);

}
