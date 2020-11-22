package model.services;

import java.io.IOException;

import javax.swing.JOptionPane;

import model.entities.Candidato;
import util.LinkedList;
import util.Arquivo;

public class CandidatoService {
	
	public LinkedList<Candidato> findAll() {
		return null;
	}
	
	public void RealizaInscricao (String cpf) throws IOException {
		
		int D;
		Arquivo arq = new Arquivo();
		Candidato user = new Candidato();
		
		user=(Candidato)arq.lerArquivo(cpf);
		
		user.setDataNascimento(JOptionPane.showInputDialog("Digite data de Nascimento DD/MM/AAAA"));
		user.setTelefone(Long.parseLong(JOptionPane.showInputDialog("Digite telefone")));
		user.setEndereco(JOptionPane.showInputDialog("Digite endereço"));
		D =  Integer.parseInt(JOptionPane.showInputDialog("Se possuir alguma deficiência Digite 1, caso contrario 2"));
		if (D == 1) {
			user.setDeficiencia(true);
		}else if(D==2) {
			user.setDeficiencia(false);
		}
		 
		System.out.println(user.getNome() +", "+ user.getEmail()+", "+user.getCpf()+ ", " +user);
		String textoCandidato= user.toString();
		arq.gravaCandidato(textoCandidato);
	}
	
	public void acompanhaInscricao(String cpf) {
		
	}
	
	public void solicitaRecurso(String cpf) {
		
	}
}
