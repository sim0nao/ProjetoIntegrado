package util;

import javax.swing.JOptionPane;

public class LinkedList<E> {
	private Node<E> firstNode;
	
	public LinkedList() {
		firstNode = null;
	}
	
	public boolean isEmpty() {
		return firstNode == null;
	}
	
	public E addEnd(E data) {
		Node<E> node = new Node<E>(data);
		Node<E> resp;
		if (isEmpty()) {
			resp = firstNode = node;
		} else {
			Node<E> aux = firstNode;
			while (aux.next != null) {
				aux = aux.next;
			}
			resp = aux.next = node;
		}
		
		if (resp.data == null) {
			JOptionPane.showMessageDialog(null, "Erro ao adicionar no final");
			return null;
		}
		return resp.data;
	}

	public E addStart(E data) {
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
	
	public E add(E data, int pos) {
		Node<E> node = new Node<E>(data);
		E resp = null;
		if (pos == 1) {
			resp = addStart(data);
		} else {
			Node<E> aux = firstNode;
			int count = 1;
			
			while (aux.next != null && count < pos-1) {
				aux = aux.next;
				count++;
			}
			
			if (count == pos-1) {
				node.next = aux.next;
				aux.next = node;
				resp = aux.next.data;
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao adicionar na posição escolhida");
			}
		}
		return resp;
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
		
		return resp;
	}
	
	public E remove(int pos) {
		E resp = null;
		int i =1;
		Node<E> aux = firstNode;
		
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "Lista vazia!");
			return resp;
		}
		if (pos == 1) {
			resp = removeStart();
			return resp;
		} else {
			while (aux.next != null) {
				aux = aux.next;
				i++;
			}
			if (pos > i || pos == 0) {
				JOptionPane.showMessageDialog(null, "Posição Inválida!");
				return resp;
			} else if (pos == i) {
				resp = removeEnd();
				return resp;
			} else {
				aux = firstNode;
				Node<E> aux2 = aux;
				
				while (pos > 1) {
					aux2 = aux;
					aux = aux.next;
					pos--;
				}
				resp = aux.data;
				aux2.next = aux.next;
				return resp;
			}
		}
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
}
