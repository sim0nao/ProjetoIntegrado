package util;

public class Node<E> {
	public E data;
	Node<E> previous;
	public Node<E> next;
	

	public Node(E data) {
		this.data = data;
		previous = null;
		next = null;
	}
}
