/**
 * Binary Search Tree implementation designed for the String data type.
 *
 * Reference: Hussein Suleman
 *
 * @author Thomas Baloyi
 * @version 1
 * 1 March 2020
 */
public class BinarySearchTree {
    
    /** Root node for binary search tree. */
    private Node root;
    
    /** Keeps track of insert comparison operations. */
    private int insertOpCount;
    
    /** Keeps track of find comparison operations. */
    private int findOpCount;
    
    /** Creates an empty Binary Search Tree. */
    public BinarySearchTree() {
        this.root = null;
        this.insertOpCount = 0;
        this.findOpCount = 0;
    } 
    
    /** Inserts new data item into this BST. */
    public void insert(String data) {
        if (this.root == null) {
            this.root = new Node(data);
        }
        else {
            insertOpCount++;
            insert(data, root);
        }
    }
    
    /** Inserts new data item into this BST. */
    public void insert(String data, Node node) {
        if (data.compareTo(node.data) <= 0) {
            if (node.left == null) {
                node.left = new Node(data);
            }
            else {
                insert(data, node.left);
            }
        }
        else {
            if (node.right == null) {
                node.right = new Node(data);
            }
            else {
                insert(data, node.right);
            }
        }
    }
    
    /** Returns node containing data matching with given data. */
    public Node find(String data) {
        if (root == null) {
            return null;
        }
        else {
            return find(data, root);
        }
    }   
    
    /** Returns node containing data matching with given data. */
    public Node find(String data, Node node) {
        if (data.compareTo( ( (node.data).substring(0,7) ).trim() ) == 0) {
            findOpCount++;
            return node;
        }
        else if (data.compareTo( ( (node.data).substring(0,7) ).trim() ) < 0) {
            findOpCount = findOpCount + 2;
            return (node.left == null) ? null : find(data, node.left);
        }
        else {
            findOpCount = findOpCount + 2;
            return (node.right == null) ? null : find(data, node.right);
        }
    }
    
    /** Prints out all data items using an in order traversal. */     
    public void printInOrder() {
        printInOrder(this.root);
    }
    
    /** Prints out all data items using an in order traversal. */
    public void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println( (node.data).substring(7).trim() );
            printInOrder(node.right);
        }
    }
    
    /** Prints out data from nodes that match with given param */
    public void printNodeData(String data) {
        Node node = find(data);
        if (node == null) {
            System.out.println("Areas not found");
        }
        else {
            System.out.println( ( (node.data).substring(7) ).trim() );
        }   
    }
    
    /** Returns the number of comparison operations done to find a data item. */
    public int getFindOpCount() {
        return (this.findOpCount);
    }
    
    /** Returns the number of comparison operations done to insert a data item. */
    public int getInsertOpCount() {
        return (this.insertOpCount);
    }
    
    /** Returns the size of the tree rooted at node. */
    public int size() {
        return size(this.root);
    }
    
    /** Returns the size of the tee rotted at node. */
    public int size(Node node) {
        int sizeRight, sizeLeft;
        sizeRight = 0; sizeLeft = 0;
        if (node.left != null) {
            sizeLeft = size(node.left);
        }
        if (node.right != null) {
            sizeRight = size(node.right);
        }
        return (1 + sizeLeft + sizeRight);
    }
}