package model.services;

import java.io.IOException;

import javax.swing.JOptionPane;

import model.entities.Candidato;
import util.ArquivosCurriculo;
import util.DoublyLinkedList;
import util.Node;

public class CpsService {
	

	public String avaliarCurriculo(DoublyLinkedList<Candidato> listaCandidatos) throws IOException {
		
		ArquivosCurriculo cur = new ArquivosCurriculo();
		
		String nota="";
		String mostraCandidatos = listaCandidatos.showLinkedList();
		String cpf=JOptionPane.showInputDialog(mostraCandidatos+"\n DIGITE O CPF DO CANDIDATO DESEJADO");
		nota=JOptionPane.showInputDialog("CURRÍCULO \n"+cur.lerCurriculo(cpf)+"\n Digite a nota da avaliação");
		
		//Atribuir nota para o curriculo candidato.setNota
		Node<Candidato> current = listaCandidatos.getFirstNode();
		while (current != null) {
			int CPF=Integer.parseInt(current.data.getCpf());
			if(CPF==Integer.parseInt(cpf)) {
				current.data.setNota(nota);
			}
			current = current.next;
		}
		return listaCandidatos.showLinkedList();
	}

	
	public String validarDocumento(DoublyLinkedList<Candidato> listaCandidatos) {
		
		String status="";	
		String mostraCandidatos = listaCandidatos.showLinkedList();
		String cpf=JOptionPane.showInputDialog(mostraCandidatos+"\n DIGITE O CPF DO CANDIDATO DESEJADO");
		status=JOptionPane.showInputDialog("Imagem"+"\n Digite 'APROVADO' ou 'REPROVADO'");
		
		//Atribuir nota para o curriculo candidato.setNota
		Node<Candidato> current = listaCandidatos.getFirstNode();
		while (current != null) {
			int CPF=Integer.parseInt(current.data.getCpf());
			if(CPF==Integer.parseInt(cpf)) {
				current.data.setStatus(status);
			}
			current = current.next;
		}
		return listaCandidatos.showLinkedList();
	}

}
