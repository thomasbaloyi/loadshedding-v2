/**
 * A node is a mechanism used by  a group of data structures to store data.
 *
 * @author Thomas Baloyi
 * @version 01.04.2020
 */
public class Node {
    
    /** Data stored within node. */
    String data;
    
    /** Left child of this node. */
    Node left;
    
    /** Right child of this node. */
    Node right;
    
    /** The height of this node. */
    int height;
    
    /** Creates an empty node. */
    public Node() {
        this.data = null;
        this.left = null;
        this.right = null;
        this.height = 0;
    }
    
    /** Creates a node with data item. */
    public Node(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 0;
    }
    
    /** Returns the left child of this node. */
    public Node getLeft() {
        return this.left;
    }
    
    /** Returns the right child of this node. */
    public Node getRight() {
        return this.right;
    }
    
    /** Returns this node's data. */
    public String getData() {
        return this.data;
    }
    
    /** Returns the height of this node. */
    public int getHeight() {
        return this.height;
    }
}