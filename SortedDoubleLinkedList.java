package application;

import java.util.Comparator;

/**
 * SortedDoubleLinkedList represents a sorted doublelinked list data structure.
 * Extends BasicDoubleLinkedList.
 * 
 * @param <T> The type of elements stored in the list.
 * @author Paul Abili
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{

	private Comparator<T> comparator;

	/**
	 * Constructs a SortedDoubleLinkedList with the specified comparator.
	 * 
	 * @param comparator The comparator to use for sorting.
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	/**
	 * Adds an element to the list and maintains sorting order.
	 * 
	 * @param data The data to add.
	 */
	public void add(T data) {
		super.addToFront(data);
		this.sortNodes();
	}

	/**
	 * Sorts the nodes in the list 
	 */
	public void sortNodes() {
		if (size <= 1) {
			return; 
		}
		boolean swapped;
		do {
			swapped = false;
			Node<T> current = head;
			while (current.next != null) {
				if (((Comparable<T>) current.data).compareTo(current.next.data) > 0) {
					T temp = current.data;
					current.data = current.next.data;
					current.next.data = temp;
					swapped = true;
				}
				current = current.next;
			}
		} while (swapped);
	}

	/**
	 * Throws UnsupportedOperationException since adding to front is invalid for a sorted list.
	 * 
	 * @param data The data to add.
	 * @throws UnsupportedOperationException Always thrown since adding to front is not supported.
	 */
	@Override
	public void addToFront(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}

	/**
	 * Throws UnsupportedOperationException since adding to end is invalid for a sorted list.
	 * 
	 * @param data The data to add.
	 * @throws UnsupportedOperationException Always thrown since adding to end is not supported.
	 */
	@Override
	public void addToEnd(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}

	/**
	 * Removes the specified element from the list using the comparator.
	 * 
	 * @param data The data to remove.
	 * @param comparator The comparator to use for equality testing.
	 * @return The removed node.
	 */
	@Override
	public Node<T> remove(T data, Comparator<T> comparator){
		return super.remove(data, comparator);
	}

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 * 
	 * @return An iterator over the elements in this list in proper sequence.
	 */
	@Override
	public DoubleLinkedListIterator<T> iterator(){
		return super.iterator();
	}
}
