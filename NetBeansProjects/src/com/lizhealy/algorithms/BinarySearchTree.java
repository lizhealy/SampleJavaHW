/**
 * The purpose of this program is to print a Binary Search Tree in pre-order, 
 * post-order, and level-order.  Also, a queue will be implemeted to
 * to print the tree in level-order.
 * @author Weiss updated by Liz Healy
 */
// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// boolean contains( x )  --> Return true if x is present
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// ******************ERRORS********************************
// Throws UnderflowException as appropriate
import csci230.DoublyLinkedQueue;
/**
 * Implements an unbalanced binary search tree.
 * Note that all "matching" is based on the compareTo method.
 * 
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
{

    


    
       // Basic node stored in unbalanced binary search trees
    private static class BinaryNode<AnyType>
    {
            // Constructors
        BinaryNode( AnyType theElement )
        {
            this( theElement, null, null );
        }

        BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
        }

        AnyType element;            // The data in the node
        BinaryNode<AnyType> left;   // Left child
        BinaryNode<AnyType> right;  // Right child
    }


      /** The tree root. */
    private BinaryNode<AnyType> root;



    /**
     * Construct the tree.
     */
    public BinarySearchTree( )
    {
        root = null;
    }

    /**
     * Insert into the tree; duplicates are ignored.
     * @param x the item to insert.
     */
    public void insert( AnyType x )
    {
        root = insert( x, root );
    }

    /**
     * Remove from the tree. Nothing is done if x is not found.
     * @param x the item to remove.
     */
    public void remove( AnyType x )
    {
        root = remove( x, root );
    }

    /**
     * Find the smallest item in the tree.
     * @return smallest item or null if empty.
     */
    public AnyType findMin( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( );
        return findMin( root ).element;
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item of null if empty.
     */
    public AnyType findMax( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( );
        return findMax( root ).element;
    }

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return true if not found.
     */
    public boolean contains( AnyType x )
    {
        return contains( x, root );
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty( )
    {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return root == null;
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree( )
    {
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printTree( root );
    }

    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return new BinaryNode<>( x, null, null );
        
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = insert( x, t.left );
        else if( compareResult > 0 )
            t.right = insert( x, t.right );
        else
            ;  // Duplicate; do nothing
        return t;
    }

    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return t;   // Item not found; do nothing
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = remove( x, t.left );
        else if( compareResult > 0 )
            t.right = remove( x, t.right );
        else if( t.left != null && t.right != null ) // Two children
        {
            t.element = findMin( t.right ).element;
            t.right = remove( t.element, t.right );
        }
        else
            t = ( t.left != null ) ? t.left : t.right;
        return t;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<AnyType> findMin( BinaryNode<AnyType> t )
    {
        if( t == null )
            return null;
        else if( t.left == null )
            return t;
        return findMin( t.left );
    }

    /**
     * Internal method to find the largest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t )
    {
        if( t != null )
            while( t.right != null )
                t = t.right;

        return t;
    }

    /**
     * Internal method to find an item in a subtree.
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return node containing the matched item.
     */
    private boolean contains( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return false;
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            return contains( x, t.left );
        else if( compareResult > 0 )
            return contains( x, t.right );
        else
            return true;    // Match
    }

    /**
     * Internal method to print a subtree in sorted order.
     * @param t the node that roots the subtree.
     */
    private void printTree( BinaryNode<AnyType> t )
    {
        if( t != null )
        {
            printTree( t.left );
            System.out.println( t.element );
            printTree( t.right );
        }
    }
    

    /**
    * printTreePre prints the Binary Search Tree in pre-order
    * @param t the node that roots the subtree.
    * 
    */

    private void printTreePre(BinaryNode<AnyType> t )
    {
        if( t != null )
        {
            System.out.println( t.element );
            printTree( t.left );
            printTree( t.right );
        }
    }

    /**
    * printTreePost prints the Binary Search Tree in post-order
    * @param t the node that roots the subtree.
    * 
    */

    private void printTreePost(BinaryNode<AnyType> t )
    {
        if( t != null )
        {
            printTree( t.left );
            printTree( t.right );
            System.out.println( t.element );
        }
    }

    /**
    * printTreeLevel prints the Binary Search Tree in level-order
    * @param t the node that roots the subtree.
    * 
    */
        private void printTreeLevel(BinaryNode<AnyType> t )
    {
        DoublyLinkedQueue<Integer> q = new DoublyLinkedQueue<>();
        if( t != null )
        {
            enqueue( t.element );
            while(q != isEmpty()) {
                dequeue(t.element);
                System.out.println( t.element );
                if(t.left != isEmpty()){
                    enqueue(t.left);
                }
                else if(t.right != isEmpty()){
                    enqueue(t.right);
                }
            }
        }
    }



    /**
     * Internal method to compute height of a subtree.
     * @param t the node that roots the subtree.
     */
    private int height( BinaryNode<AnyType> t )
    {
        if( t == null )
            return -1;
        else
            return 1 + Math.max( height( t.left ), height( t.right ) );    
    }
    
    
    
    
 
        // Test program
    public static void main( String [ ] args )
    {
        //Length of 20 with random integers from 1-100.
        BinarySearchTree<Integer> t = new BinarySearchTree<>( );
        for (int i = 0; i < 20; i++){
            t.insert((int)Math.random()*100);
            System.out.println("Pre-order: " + printTreePre(t));
            System.out.println("Post-order: " + printTreePost(t));
            System.out.println("Level-order: " + printTreeLevel(t));
        }
        
        //Length of 100 with random integers from 1-100.
        BinarySearchTree<Integer> t3 = new BinarySearchTree<>( );
        for (int i = 0; i < 100; i++){
            t3.insert((int)Math.random()*100);
            System.out.println("Pre-order: " + printTreePre(t3));
            System.out.println("Post-order: " + printTreePost(t3));
            System.out.println("Level-order: " + printTreeLevel(t3));
        }
        
        //Empty tree
        BinarySearchTree<Integer> t2 = new BinarySearchTree<>( );
        for (int i = 0; i < 0; i++){
            
            System.out.println("Pre-order for an empty tree: " + printTreePre(t2));
            System.out.println("Post-order for an empty tree: " + printTreePost(t2));
            System.out.println("Level-order for an empty tree: " + printTreeLevel(t2));
        }
    }
           
}
