package application;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.Comparator;
import java.util.ArrayList;

public class BasicDoubleLinkedList_STUDENT_Test {

	@Test
	public void testAddToFront() {
		BasicDoubleLinkedList<Integer> list = new BasicDoubleLinkedList<>();
		list.addToFront(1);
		list.addToFront(2);
		list.addToFront(3);

		assertEquals(3, (int) list.getFirst());
		assertEquals(1, (int) list.getLast());
		assertEquals(3, list.getSize());
	}

	@Test
	public void testAddToEnd() {
		BasicDoubleLinkedList<String> list = new BasicDoubleLinkedList<>();
		list.addToEnd("apple");
		list.addToEnd("banana");
		list.addToEnd("orange");

		assertEquals("apple", list.getFirst());
		assertEquals("orange", list.getLast());
		assertEquals(3, list.getSize());
	}


	@Test
	public void testRetrieveFirstElement() {
		BasicDoubleLinkedList<Integer> list = new BasicDoubleLinkedList<>();
		list.addToEnd(1);
		list.addToEnd(2);
		list.addToEnd(3);

		assertEquals(1, (int) list.retrieveFirstElement());
		assertEquals(2, (int) list.getFirst());
		assertEquals(2, list.getSize());
	}

	@Test
	public void testRetrieveLastElement() {
		BasicDoubleLinkedList<String> list = new BasicDoubleLinkedList<>();
		list.addToEnd("apple");
		list.addToEnd("banana");
		list.addToEnd("orange");

		assertEquals("orange", list.retrieveLastElement());
		assertEquals("apple", list.getFirst());
		assertEquals(2, list.getSize());
	}

	@Test
	public void testToArrayList() {
		BasicDoubleLinkedList<String> list = new BasicDoubleLinkedList<>();
		list.addToEnd("apple");
		list.addToEnd("banana");
		list.addToEnd("orange");

		ArrayList<String> arrayList = list.toArrayList();

		assertEquals("apple", arrayList.get(0));
		assertEquals("banana", arrayList.get(1));
		assertEquals("orange", arrayList.get(2));
	}

}
