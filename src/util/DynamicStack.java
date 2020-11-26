package util;

import javax.swing.JOptionPane;

public class DynamicStack<E> {
	private Node<E> firstNode;
	
	public DynamicStack() {
		firstNode = null;
	}
	
	public boolean isEmpty() {
		return firstNode == null;
	}
	

	public E push(E data) {
		Node<E> node = new Node<E>(data);
		Node<E> resp;
		node.next = firstNode;
		resp = firstNode = node;

		if (resp.data == null) {
			JOptionPane.showMessageDialog(null, "Erro ao adicionar no final");
			return null;
		}
		return resp.data;
	}
	
	public E pop() {
		E resp = null;
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "Lista vazia!");
			return resp;
		} 
		
		resp = firstNode.data;
		firstNode = firstNode.next;
		
		return resp;
	}

	public String showDynamicStack() {
		String aux="";
		
		if (isEmpty()) {
			return "Pilha vazia!";
		}

		Node<E> current = firstNode;
		while (current != null) {
			aux += current.data +  "\n" ;
			current = current.next;
		}
		return aux;
	}
	
	public E showTop() {
		E top = firstNode.data;
		return top;
	}
}
