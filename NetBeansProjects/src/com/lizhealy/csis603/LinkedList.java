
package com.lizhealy.csis603;

/**
 *
 * @author lizhealy
 */



import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * This class implements a List by means of a linked data structure.
 * A List (also known as a <i>sequence</i>) is an ordered collection.
 * Elements in the list can be accessed by their integer index.  The
 * index of the first element in the list is zero.
 */
public class LinkedList<E> implements Iterable<E>
  {
    private Node<E> head;
    private int size;


    /**
     * A list node contains the data value and a link to the next
     * node in the linked list.
     */
    private static class Node<E>
      {
        private E data;
        private Node<E> next;


        /**
         * Construct a node with the specified data value and link.
         */
        public Node(E data, Node<E> next)
          {
            this.data = data;
            this.next = next;
          }


        /**
         * Construct a node with the given data value
         */
        public Node(E data)
          {
            this(data, null);
          }
      }


    /**
     *  An iterator for this singly-linked list.
     */
    private static class LinkedListIterator<E> implements Iterator<E>
      {
        private Node<E> nextElement;


        /**
         * Construct an iterator initialized to the first element in the list.
         */
        public LinkedListIterator(Node<E> head)
          {
            nextElement = head;
          }


        /**
         * Returns true if the iteration has more elements.
         */
        @Override
        public boolean hasNext()
          {
            return nextElement != null;
          }


        /**
         * Returns the next element in the list.
         *
         * throws NoSuchElementException if the iteration has no next element.
         */
        @Override
        public E next() throws NoSuchElementException
          {
            if (nextElement == null) throw new NoSuchElementException();
            
            else
           {
              E nextData = nextElement.data;
              nextElement = nextElement.next;
              return nextData;
           }

        // Note: Do not have to implement other methods in interface
        // Iterator since they have default implementations.
      }

    }
    /**
     * Helper method: Find the node at a specified index.
     *
     * @return a reference to the node at the specified index
     *
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    private Node<E> getNode(int index) throws IndexOutOfBoundsException
      {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(Integer.toString(index));

        Node<E> node = head;

        for (int i = 0;  i < index;  ++i)
            node = node.next;

        return node;
      }


    /**
     * Constructs an empty list.
     */
    public LinkedList()
      {
        clear();
      }


    /**
     * Appends the specified element to the end of the list.
     * @param element to be added
     */
    public void add(E element)
      {
        if (isEmpty())
            head = new Node<E>(element);
        else
          {
            Node<E> lastNode = getNode(size - 1);
            lastNode.next = new Node<E>(element);
          }

        ++size;
      }


    /**
     * Inserts the specified element at the specified position in the list.
     *
     * @param index at which element should be added
     * @param element to be added
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt; size()</tt>)
     */
    public void add(int index, E element)
      {
        if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("" + index);
		}
        else if (index == size){
            add(element);
        }

        else if (index == 0)
            {
                Node<E> newNode = new Node<E>(element, head);
                head = newNode;
                size++;
            }
        else
            {
                Node<E> prev = head;
                for (int i = 0; i < index - 1; i++)
                    {
                        prev = prev.next;
                    }
                
                // get reference to node after insertion
                Node<E> after = prev.next;

                // make new node
                Node<E> newNode = new Node<E>(element, after);
                
                // link before to new node
                prev.next = newNode;

                size++;
            }
      }


    /**
     * Removes all of the elements from this list.
     */
    public void clear()
      {
        while (head != null)
          {
             Node<E> temp = head;
             head = head.next;

             temp.data = null;
             temp.next = null;
          }

        size = 0;
      }


    /**
     * Returns the element at the specified position in this list.
     *
     * @param index of data to return
     * @return returns the data at given index
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    public E get(int index)
      {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(Integer.toString(index));

        Node<E> node = getNode(index);
        return node.data;
      }


    /**
     * Replaces the element at the specified position in this list
     * with the specified element.
     *
     * @param index for which newValue is to be set to
     * @param newValue to be set
     * @return The data value previously at index
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    public E set(int index, E newValue)
      {
        if (index >= size()) 
            return null;
        Node<E> n = head;
        
        while (index > 0)
        {
            n = n.next;
            index--;
        }
        
        E result = n.data;
        n.data = newValue;
        return result;
      }


    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * @param obj the object to get the index of
     * @return the index of given object
     */
    public int indexOf(Object obj)
      {
        int index = 0;

        if (obj == null)
          {
            for (Node<E> node = head;  node != null;  node = node.next)
              {
                if (node.data == null)
                    return index;
                else
                    index++;
              }
          }
        else
          {
            for (Node<E> node = head;  node != null;  node = node.next)
              {
                if (obj.equals(node.data))
                    return index;
                else
                    index++;
              }
          }

        return -1;
    }


    /**
     * @return <tt>true</tt> if this list contains no elements.
     */
    public boolean isEmpty()
      {
        return size == 0;
      }


    /**
     * Removes the element at the specified position in this list.  Shifts
     * any subsequent elements to the left (subtracts one from their indices).
     *
     * @param index where element is to be removed
     * @return the element previously at the specified position
     *
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    public E remove(int index)
      {
        if (index < 0 || index > size())
        {
            throw new IndexOutOfBoundsException();
        }
        else if (size == 1)
        {
            // removing only element
            E removed = head.data;
            clear();
            return removed;
        }
        else if (index == 0)
        {
            // removing first element
            E removed = head.data;
            head = head.next;
            size--;
            return removed;
        }
        else
        {
            // position beforeI before the node to remove
            Node<E> beforeI = head;
            for (int i = 1; i < index; i++)
                {
                    beforeI = beforeI.next;
                }

            // position afterI after the node to remove
            Node<E> afterI = beforeI.next.next;

            // remember old data
            E removed = beforeI.next.data;

            // link beforeI to afterI
            beforeI.next = afterI;

            size--;

            return removed;
        }
                
      }


    /**
     * @return the number of elements in this list.
     */
    public int size()
      {
        int count = 0;
        Node<E> current = head;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
      }


    /**
     * Returns an iterator over the elements in this list in proper sequence.
     */
    @Override
    public Iterator<E> iterator()
      {
        return new LinkedListIterator(head);
      }


    /**
     * Returns a string representation of this list.
     */
    @Override
    public String toString()
    {
        if (head == null) {
            return "[]";
        } 
        else {
            String result = "[" + head.data;
            Node<E> current = head.next;
            while (current != null) {
                    result += ", " + current.data;
                    current = current.next;
            }
            result += "]";
            return result;
        }
    }


    /*
     * Compares the specified object with this list for equality. Returns true
     * if and only if both lists contain the same elements in the same order.
     */
    @Override
    @SuppressWarnings("rawtypes")
    public boolean equals(Object obj)
      {
        if (obj == this)
            return true;

        if (!(obj instanceof LinkedList))
            return false;

        // cast obj to a linked list
        LinkedList listObj = (LinkedList) obj;

        // compare elements in order
        Node<E> node1 = head;
        Node    node2 = listObj.head;

        while (node1 != null && node2 != null)
          {
            // check to see if data values are equal
            if (node1.data == null)
              {
                if (node2.data != null)
                    return false;
              }
            else
              {
                if (!node1.data.equals(node2.data))
                    return false;
              }

            node1 = node1.next;
            node2 = node2.next;
          }

        return node1 == null && node2 == null;
      }


    /**
     * Returns the hash code value for this list.
     */
    @Override
    public int hashCode()
      {
        int hashCode = 1;
        Node<E> node = head;

        while (node != null)
          {
            E obj = node.data;
            hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
            node = node.next;
          }

        return hashCode;
      }
  }
