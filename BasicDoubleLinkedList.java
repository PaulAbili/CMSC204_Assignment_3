package application;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;

/**
 * BasicDoubleLinkedList represents a basic double linked list data structure.
 * 
 * @author Paul Abili
 * @param <T> The type of elements stored in the list.
 */
public class BasicDoubleLinkedList<T> implements Iterable<T>{
    protected Node<T> head;
    protected Node<T> tail;
    protected int size;

    /**
     * Constructs an empty BasicDoubleLinkedList.
     */
    public BasicDoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Retrieves the first element of the list.
     * 
     * @return The first element of the list.
     */
    public T getFirst() {
        return head.data;
    }

    /**
     * Retrieves the last element of the list.
     * 
     * @return The last element of the list.
     */
    public T getLast() {
        return tail.data;
    }
    
    /**
     * Retrieves and removes the first element of the list.
     * 
     * @return The first element of the list.
     */
    public T retrieveFirstElement() {
        T first = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return first;
    }

    /**
     * Retrieves and removes the last element of the list.
     * 
     * @return The last element of the list.
     */
    public T retrieveLastElement() {
        T last = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return last;
    }
    
    /**
     * Gets the size of the list.
     * 
     * @return The size of the list.
     */
    public int getSize() {
        return size;
    }

    /**
     * Adds an element to the front of the list.
     * 
     * @param data The data to add.
     */
    public void addToFront(T data) {
        Node<T> temp = new Node<T>(data, null, null);
        if(size == 0) {
            head = temp;
            tail = temp;
        } else {
            head.prev = temp;
            temp.next = head;
            head = temp;
        }
        size++;
    }

    /**
     * Adds an element to the end of the list.
     * 
     * @param data The data to add.
     */
    public void addToEnd(T data) {
        Node<T> temp = new Node<T>(data, null, null);
        if(size == 0) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
        size++;
    }


    /**
     * Removes the first occurrence of the specified element from the list.
     * 
     * @param targetData The data to remove.
     * @param comparator The comparator to use for equality testing.
     * @return The removed node.
     */
    public Node<T> remove(T targetData, Comparator<T> comparator){
        Node<T> current = head;
        while(current != null) {
            if (comparator.compare(current.data, targetData) == 0) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }   
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                current.prev = null;
                current.next = null;

                return current;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Converts the list to an ArrayList.
     * 
     * @return An ArrayList containing the elements of the list.
     */
    public ArrayList<T> toArrayList(){
        ArrayList<T> toList = new ArrayList<T>(size);
        Node<T> current = head;
        for(int i = 0; i < size; i++){
            toList.add(current.data);
            current = current.next;
        }
        return toList;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     * 
     * @return An iterator over the elements in this list in proper sequence.
     */
    public DoubleLinkedListIterator<T> iterator(){
        return new DoubleLinkedListIterator<T>();
    }

    /**
     * DoubleLinkedListIterator provides an iterator implementation for BasicDoubleLinkedList.
     */
    protected class DoubleLinkedListIterator<T> implements ListIterator<T>{
        private Node<T> currentNode;

        /**
         * Constructs a DoubleLinkedListIterator.
         */
        public DoubleLinkedListIterator() {
            currentNode = (Node<T>) head;
        }

        /**
         * Retrieves the next element in the list.
         * 
         * @return The next element in the list.
         * @throws NoSuchElementException if there are no more elements in the list.
         */
        public T next() throws NoSuchElementException {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            T nextData = currentNode.data;
            if(!hasNext() && currentNode.next != null) {
                
            } else {
            currentNode = currentNode.next;
            }
            
            return nextData;
        }

        /**
         * Checks if there is a next element in the list.
         * 
         * @return true if there is a next element, false otherwise.
         */
        public boolean hasNext() {
            return currentNode != null;
        }

        /**
         * Retrieves the previous element in the list.
         * 
         * @return The previous element in the list.
         * @throws NoSuchElementException if there are no more elements in the list.
         */
        public T previous() throws NoSuchElementException {
            if(!hasPrevious()) {
                throw new NoSuchElementException();
            }
            currentNode = currentNode.prev;
            return currentNode.data;
        }

        /**
         * Checks if there is a previous element in the list.
         * 
         * @return true if there is a previous element, false otherwise.
         */
        public boolean hasPrevious(){
            if(currentNode == null) {
                return true;
            }
            return currentNode.prev != null;
        }

        /**
         * Removes the last element returned by the iterator (optional operation).
         * 
         * @throws UnsupportedOperationException if the remove operation is not supported.
         */
        public void remove() throws UnsupportedOperationException{
            throw new UnsupportedOperationException();
        }

        /**
         * Inserts the specified element into the list (optional operation).
         * 
         * @throws UnsupportedOperationException if the add operation is not supported.
         */
        public void add(Object arg0){
            throw new UnsupportedOperationException();
        }

        /**
         * Returns the index of the next element (optional operation).
         * 
         * @throws UnsupportedOperationException if the nextIndex operation is not supported.
         */
        public int nextIndex() throws UnsupportedOperationException{
            throw new UnsupportedOperationException();
        }

        /**
         * Returns the index of the previous element (optional operation).
         * 
         * @throws UnsupportedOperationException if the previousIndex operation is not supported.
         */
        public int previousIndex() throws UnsupportedOperationException{
            throw new UnsupportedOperationException();
        }

        /**
         * Replaces the last element returned by the iterator with the specified element (optional operation).
         * 
         * @throws UnsupportedOperationException if the set operation is not supported.
         */
        public void set(Object arg0) throws UnsupportedOperationException{
            throw new UnsupportedOperationException();
        }
    }

    protected static class Node<T> {
        protected T data;
        protected Node<T> prev;
        protected Node<T> next;

        protected Node() {
            this(null,null,null);
        }

        protected Node(Node<T> other) {
            this(other.data, other.prev, other.next);
        }

        protected Node(T dataNode, Node<T> prev, Node<T> next){
            data = dataNode;
            this.prev = prev;
            this.next = next;
        }

    }
}