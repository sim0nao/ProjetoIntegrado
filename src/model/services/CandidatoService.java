package model.services;

import javax.swing.JOptionPane;

import model.entities.Candidato;
import util.LinkedList;

public class CandidatoService {
	
	public LinkedList<Candidato> findAll() {
		return null;
	}
	
	public void RealizaInscricao () {
		int D;
		
		Candidato user = new Candidato ();
		user.setDataNascimento(JOptionPane.showInputDialog("Digite data de Nascimento DD/MM/AAAA"));
		user.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("Digite telefone")));
		user.setEndereco(JOptionPane.showInputDialog("Digite endereço"));
		D =  Integer.parseInt(JOptionPane.showInputDialog("Se possuir alguma deficiência Digite 1, caso contrario 2"));
		if (D == 1) {
			user.setDeficiencia(true);
		}else if(D==2) {
			user.setDeficiencia(false);
		}
		 
		System.out.println(user.getNome() +" "+ user.getEmail()+""+user.getCpf()+ "  " +user);
	}
	
	public void acompanhaInscricao() {
		
	}
	
	public void solicitaRecurso() {
		
	}
}
