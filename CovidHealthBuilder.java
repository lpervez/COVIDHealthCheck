import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is CovidHealthBuilder class.
 * 
 * @author laraibpervez
 * @param <T> type parameter
 */
public class CovidHealthBuilder<T> {

	/**
	 * Health tree.
	 */
	DecisionTreeInterface<T> healthTree;

	/**
	 * Binary Tree.
	 * 
	 */
	BinaryTree<T> binaryTree;

	/**
	 * Constructor.
	 */
	public CovidHealthBuilder() {
		healthTree = null;
		binaryTree = null;
	}

	/**
	 * Overloaded Constructor.
	 * 
	 * @param fileName filename
	 */
	public CovidHealthBuilder(String fileName) {
		ArrayList<T> data = readData(fileName);
		binaryTree = new BinaryTree<T>();
		binaryTree.setRootNode(buildTree(data, binaryTree.getRootNode(), 0));
		healthTree = new DecisionTree<T>(binaryTree.getRootNode());
	}

	/**
	 * Reading the data files.
	 * 
	 * @param fileName filename
	 * @return ArrayList
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<T> readData(String fileName) {
		ArrayList<T> arrayList = new ArrayList<T>();
		try (Scanner s = new Scanner(new File(fileName)).useDelimiter("\\n|,")) {
			while (s.hasNext()) {
				arrayList.add((T) s.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return arrayList;
	}

	/**
	 * Building the tree.
	 * 
	 * @param data  data
	 * @param node  node
	 * @param index index
	 * @return node
	 */
	public BinaryNode<T> buildTree(ArrayList<T> data, BinaryNode<T> node, int index) {

		if (index < data.size()) {
			BinaryNode<T> temp = new BinaryNode<T>(data.get(index));
			node = temp;

			node.setLeftChild(buildTree(data, node.getLeftChild(), 2 * index + 1));

			node.setRightChild(buildTree(data, node.getRightChild(), 2 * index + 2));
		}
		return node;
	}

	/**
	 * Taking the decision.
	 */
	public void decide() {
		if (binaryTree.isEmpty()) {
			throw new EmptyTreeException("Empty Binary tree.");
		}

		healthTree.resetCurrentNode();
		while (!healthTree.isAnswer()) {
			System.out.println(healthTree.getCurrentData());

			if (isUserResponseYes()) {
				healthTree.moveToYes();
			} else {
				healthTree.moveToNo();
			}
		}

		System.out.println(healthTree.getCurrentData());
		System.out.println("Satisfied by my intelligence?");
		if (isUserResponseYes() == false) {
			learn();
		}
	}

	/**
	 * checking if the user is satisfied or not.
	 */
	public void learn() {

		System.out.println("What should be the answer?");

		String correctAnswer = getUserResponse();
		System.out.println("Give me a question whose answer is yes for " + correctAnswer + " but no for "
				+ healthTree.getCurrentData());
		String newQuestion = getUserResponse();

		updateTree(newQuestion, (String) healthTree.getCurrentData(), correctAnswer);

	}

	/**
	 * Updating the tree.
	 * 
	 * @param question  question
	 * @param noAnswer  noAnswer
	 * @param yesAnswer yesAnswer
	 */
	@SuppressWarnings("unchecked")
	public void updateTree(String question, String noAnswer, String yesAnswer) {
		healthTree.getCurrentNode().setData((T) question);
		healthTree.setResponses((T) noAnswer, (T) yesAnswer);
	}

	/**
	 * Getting health tree.
	 * 
	 * @return healthTree
	 */
	public DecisionTreeInterface<T> getHealthTree() {
		return healthTree;
	}

	/**
	 * Getting the user response.
	 * 
	 * @return response
	 */
	@SuppressWarnings("resource")
	public static String getUserResponse() {
		Scanner keyboard = new Scanner(System.in);
		String response = keyboard.nextLine();

		return response;
	} // endgetUserResponse

	/**
	 * If the user response is yes.
	 * 
	 * @return boolean
	 */
	public static boolean isUserResponseYes() {
		String answer = getUserResponse();
		if (answer.toLowerCase().equals("yes"))
			return true;
		else
			return false;
	} // end isUserResponseYes

	/**
	 * Main Method.
	 * 
	 * @param args args
	 */
	public static void main(String[] args) {
		CovidHealthBuilder<String> build = new CovidHealthBuilder<String>("data.txt");

		String response;
		do {
			build.decide();
			System.out.print("Try again? ");
			response = getUserResponse();
		} while (response.toLowerCase().equals("yes"));
		System.out.println("Have a nice day!");
	}

}
