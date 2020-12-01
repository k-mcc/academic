/**
 * Binary Search Tree: Node Class
 *
 * @author Kate McCarthy
 *
 */

public class BinaryTreeNode <T>{

	private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;
    private T data;

    /**
     * Default constructor, sets binary tree node with null data and null children
     */
    public BinaryTreeNode(){
        this(null,null,null);
    }

    /**
     * Constructs a binary tree node with the given data and null children
     *
     * @param theData - The data to store at this node
     */
    public BinaryTreeNode(T theData){
        this(theData,null,null); // calls full Constructor [3] where left and right values are null
    }							 // thus: this.data = theData; this.left = null; this.right = null;


    /**
     * Creates a binary tree node with the given data and child reference pointers
     *
     * @param theData 		- The data to store at this node
     * @param leftChild 	- A reference pointer to the left subtree
     * @param rightChild	- A reference pointer to the right subtree
     */
    public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild){
        this.data = theData;
        this.left = leftChild;
        this.right = rightChild;
    }


    /**
     * Left child accessor
     *
     * @return A reference pointer to the root of the left subtree
     */
    public BinaryTreeNode<T> getLeft() {
        return this.left;
    }

    /**
     * Left child mutator
     *
     * @param left - A reference pointer to the new left subtree's root node
     */
    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    /**
     * Right child accessor
     *
     * @return A reference pointer to the root of the right subtree
     */
    public BinarySearchTreeNode<T> getRight() {
        return this.right;
    }

    /**
     * Right child mutator
     *
     * @param left - A reference pointer to the new right subtree's root node
     */
    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    /**
     * Node value accessor
     *
     * @return The data stored at this node
     */
    public T getData() {
        return this.data;
    }

    /**
     * Node value mutator
     *
     * @param data - The data to be stored at this node
     */
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String retVal = "";
        if (this.left != null)
            retVal += this.left.toString();
        if (this.right != null)
            retVal += this.right.toString();
        retVal += "("+this.data+")";
        return retVal;
    }
}
