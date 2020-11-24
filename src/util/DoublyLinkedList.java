package util;

import javax.swing.JOptionPane;

public class DoublyLinkedList<E> {
	private Node<E> firstNode;
	
	public DoublyLinkedList() {
		firstNode = null;
	}
	
	public boolean isEmpty() {
		return firstNode == null;
	}
	
	public void addEnd(E data) {
		Node<E> node = new Node<E>(data);
		if (isEmpty()) {
			firstNode = node;
		} else {
			Node<E> aux = firstNode;
			while (aux.next != null) {
				aux = aux.next;
			}
			aux.next = node;
			node.previous = aux;
			node.next = null;
		}
		
	}

	public void addStart(E data) {
		Node<E> node = new Node<E>(data);
		if(!isEmpty()) {
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
		} else {
			Node<E> aux1 = firstNode;
			Node<E> aux2 = firstNode;
			
			while (aux1.next != null) {
				aux2 = aux1;
				aux1 = aux1.next;
			}
			
			resp = aux1.data;
			aux1.previous = null;
			aux2.next = null;
		}
		return resp;
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
		String aux="";
		
		if (isEmpty()) {
			return "Lista vazia!";
		}

		Node<E> current = firstNode;
		while (current != null) {
			aux += "\n"+ current.data;
			current = current.next;
		}
		return aux;
	}
	
	public Node<E> getFirstNode() {
		Node<E> current=firstNode;
		return current;
		}
		
}
