/**
 * Binary Search Tree: Tree Class
 *
 * @author Kate McCarthy
 *
 */

public class BinaryTree <T>{
	private BinaryTreeNode<T> root;


	public BinaryTree() {
		this(null);
	}


	public BinaryTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}


	public BinaryTreeNode<T> getRoot() {
		return this.root;
	}


	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}


	@Override
	public String toString() {
	    if (this.root != null)
	        return this.root.toString();
	    return "Empty tree";
	}

}
