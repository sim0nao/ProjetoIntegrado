package util;

import javax.swing.JOptionPane;


public class RecursiveDoublyLinkedList<E> {
	private Node<E> firstNode;
	
	public RecursiveDoublyLinkedList() {
		firstNode = null;
	}
	
	
	public boolean isEmpty() {
		return firstNode == null;
	}
	
	
	public void addEnd(E data) {
		Node<E> node = new Node<E>(data);	
		Node<E> aux = firstNode;
		addEnd2(data, node, aux);
	}
	
	private void addEnd2(E data, Node<E> node, Node<E> aux) {
		if (isEmpty()) {
			firstNode = node;
			return;
		}
		
		if (aux.next == null) {
			aux.next = node;
			node.previous = aux;
			node.next = null;
			return;
		}
		aux = aux.next;
		addEnd2(data, node, aux);
	}

	
	public void addStart(E data) {
		Node<E> node = new Node<E>(data);
		if (!isEmpty()) {
			node.next = firstNode;
			firstNode.previous = node;
		}
		firstNode = node;
	}
	
	public E removeEnd() {
		E resp = null;
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "Lista vazia!");
			return resp;
		}

		if (firstNode.next == null) {
			resp = firstNode.data;
			firstNode = null;
			return resp;
		}
		
		Node<E> aux1 = firstNode;
		Node<E> aux2 = firstNode;
		resp = removeEnd2(aux1, aux2).data;
		return resp;
	}
	
	private Node<E> removeEnd2(Node<E> aux1, Node<E> aux2) {
		if (aux1.next == null) {
			aux1.previous = null;
			aux2.next = null;
			return aux1;	
		}
		aux2 = aux1;
		aux1 = aux1.next;
		return removeEnd2(aux1, aux2);
	}
	
	
	public E removeStart() {
		E resp = null;
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "Lista vazia!");
			return resp;
		} 
		
		resp = firstNode.data;
		firstNode = firstNode.next;
		if (!isEmpty()) {
			firstNode.previous = null;
		}
		return resp;
	}

	public String showLinkedList() {
		String text = "";
		Node<E> first = firstNode;
		return showLinkedList2(first, text);
	}
	
	private String showLinkedList2(Node<E> first, String text) {
		if (isEmpty()) {
			return "Lista vazia!";
		}
		
		if (first == null) {
			return text;
		}
		
		text += first.data + "\n";
		return showLinkedList2(first.next, text);
	}

}
