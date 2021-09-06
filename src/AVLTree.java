/**
 * AVL Tree designed to only work using Strings.
 * 
 * Reference: Hussein Suleman's AVL Tree.
 *
 * @author Thomas Baloyi
 * @version 1
 * 09.03.2020
 */
public class AVLTree {
    
    /** Root node for binary search tree. */
    private Node root;
    
    /** Keeps track of insert comparison operations. */
    private int insertOpCount;
    
    /** Keeps track of find comparison operations. */
    private int findOpCount;
    
    /** Create a new AVLTree. */
    public AVLTree() {
        this.root = null;
        this.insertOpCount = -1; // Negative because no comparison for root.
        this.findOpCount = 0;
    }
    
    /** Returns the height of node. */
    public int height(Node node) {
        if (node != null) {
            return node.height;
        }
        return -1;
    }
    
    /** Returns the balance factor of node. */
    public int balanceFactor(Node node) {
        return height(node.right) - height(node.left);
    }
    
    /** Sets the height of node. */
    public void fixHeight(Node node) {
        node.height = Math.max( height(node.left), height(node.right)) + 1;
    }
    
    /** Right rotation of node. */
    public Node rotateRight(Node p) {
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        fixHeight(p);
        fixHeight(q);
        return q;
    }
    
    /** Left rotation of node. */
    public Node rotateLeft(Node q) {
        Node p = q.right;
        q.right = p.left;
        p.left = q;
        fixHeight(q);
        fixHeight(p);
        return p;
    }
    
    /** Balances subtree rooted at node. */
    public Node balance(Node p) {
        fixHeight(p);
        if (balanceFactor(p) == 2) {
            if (balanceFactor(p.right) < 0) {
                p.right = rotateRight(p.right);
            }
            return rotateLeft(p);
        }
        if (balanceFactor(p) == -2) {
            if (balanceFactor(p.left) > 0) {
                p.left = rotateLeft(p.left);
            }
            return rotateRight(p);
        }
        return p;
    }
    
    /** Adds data into this tree. */
    public void insert(String data) {
        insertOpCount++;
        root = insert(data, root);
    }
    
    /** Adds data into this tree. */
    public Node insert(String data, Node node) {
        if (node == null) {
            return new Node(data);
        }
        if (data.compareTo(node.data) <= 0) {
            node.left = insert(data, node.left);
        }
        else {
            node.right = insert(data, node.right);
        }
        return balance(node);
    }
    
    /** Returns node containing this data item. */
    public Node find(String data) {
        if (root == null) {
            return null;
        }
        else {
            return find(data, root);
        }
    }
    
    /** Returns node containing this data item. */
    public Node find(String data, Node node) {
        if ( data.compareTo( ( (node.data).substring(0,7) ).trim() ) == 0 ) {
            findOpCount++;
            return node;
        }
        else if ( data.compareTo( ( (node.data).substring(0,7) ).trim() ) < 0 ) {
            findOpCount = findOpCount + 2;
            return (node.left == null) ? null : find(data, node.left);
        }
        else {
            findOpCount = findOpCount + 2;
            return (node.right == null) ? null : find(data, node.right);
        }
    }
    
    /** Prints out all data items in this tree using an inorder traversal. */
    public void printInOrder() {
        printInOrder(this.root);
    }
    
    /** Prints out all data items in the subtree rooted at node using an inorder traversal. */
    public void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println( (node.data).substring(7).trim() );
            printInOrder(node.right);
        }
    }
    
    /** Prints out node data matching with given data item. */
    public void printNodeData(String data) {
        Node node = find(data);
        if (node == null) {
            System.out.println("Areas not found");
        }
        else {
            System.out.println( ( (node.data).substring(7) ).trim() );
        }
    }
    
    /** Returns findOpCount. */
    public int getFindOpCount() {
        return (this.findOpCount);
    }
    
    /** Returns insertOpCount. */
    public int getInsertOpCount() {
        return (this.insertOpCount);
    }
    
    /** Returns the size of this tree. */
    public int size() {
        return size(this.root);
    }
    
    /** Returns the size of subtree rooted at node. */
    public int size(Node node) {
        int sizeLeft, sizeRight;
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