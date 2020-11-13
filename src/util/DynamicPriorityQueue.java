package util;

import javax.swing.JOptionPane;

import model.entities.Candidato;

public class DynamicPriorityQueue<E> {
	private Node<E> firstNode;
	
	public DynamicPriorityQueue() {
		firstNode = null;
	}
	
	public boolean isEmpty() {
		return firstNode == null;
	}
	
	public void add(E data) {
		Node<E> node = new Node<E>(data);
		Node<E> resp;
		if (isEmpty()) {
			resp = firstNode = node;
		} else {
			Node<E> aux = firstNode;
			if (node.data instanceof Candidato) {
				Candidato c1 = (Candidato) node.data;
				Candidato c2 = (Candidato) aux.data;
				if (c1.getPrioridade() > c2.getPrioridade()) {
					node.next = aux;
					firstNode = node;
					return;
				}
			}
			
			int count = 1;
			while (aux.next != null) {
				aux = aux.next;
				count++;
			}
			
			Node<E> aux2 = firstNode;
			while (count > 1) {
				
				if (node.data instanceof Candidato) {
					Candidato c1 = (Candidato) node.data;
					Candidato c2 = (Candidato) aux2.next.data;
					
					if (c1.getPrioridade() > c2.getPrioridade()) {
						node.next = aux2.next;
						aux2.next = node;
						return;
						
					}
				}
				aux2 = aux2.next;
				count--;
			}
			aux.next = node;
			resp = aux.next;
		}
		
		if(resp == null) {
			JOptionPane.showMessageDialog(null, "Erro ao adicionar");
			return ;
		}
	}
	
	public E remove() {
		E resp = null;
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "Lista vazia!");
			return resp;
		} 
		
		resp = firstNode.data;
		firstNode = firstNode.next;
		
		return resp;
	}

	public String showDynamicPriorityQueue() {
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
