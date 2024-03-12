/**
 * 
 */
package application;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.Comparator;

public class SortedDoubleLinkedList_STUDENT_Test {

	@Test
	public void testAdd() {
		SortedDoubleLinkedList<Integer> sortedList = new SortedDoubleLinkedList<Integer>(Comparator.naturalOrder());
		sortedList.add(3);
		sortedList.add(1);
		sortedList.add(2);

		assertEquals(1, (int) sortedList.getFirst());
		assertEquals(3, (int) sortedList.getLast());
		assertEquals(3, sortedList.getSize());
	}

	@Test
	public void testSortNodes() {
		SortedDoubleLinkedList<Integer> sortedList = new SortedDoubleLinkedList<Integer>(Comparator.naturalOrder());
		sortedList.add(3);
		sortedList.add(1);
		sortedList.add(2);
		sortedList.sortNodes();

		assertEquals(1, (int) sortedList.getFirst());
		assertEquals(3, (int) sortedList.getLast());
		assertEquals(3, sortedList.getSize());
	}
	@Test
	public void testAddToFront() {
		try {
			SortedDoubleLinkedList<String> sortedList = new SortedDoubleLinkedList<String>(Comparator.naturalOrder());
			sortedList.addToFront("apple");
			assertEquals(-1,1);
		} catch (UnsupportedOperationException e) {
			assertEquals(1,1);
		}
	}
	@Test
	public void testAddToEnd() {
		try {
			SortedDoubleLinkedList<String> sortedList = new SortedDoubleLinkedList<String>(Comparator.naturalOrder());
			sortedList.addToEnd("banana");
			assertEquals(-1,1);
		} catch (UnsupportedOperationException e) {
			assertEquals(1,1);
		}

	}
}
