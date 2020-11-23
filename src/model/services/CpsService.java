package model.services;

import java.io.IOException;

import javax.swing.JOptionPane;
import util.Arquivo;

public class CpsService {

	public void avaliarCurriculo() throws IOException {
		int nota=0;
		
		Arquivo arq = new Arquivo();
		String mostraCandidatos = arq.lerCandidato();
		String cpf=JOptionPane.showInputDialog(mostraCandidatos+"\n DIGITE O CPF DO CANDIDATO DESEJADO");
		nota=Integer.parseInt(JOptionPane.showInputDialog(arq.lerCurriculo(cpf)+"\n Digite a nota da avaliação"));
		//Atribuir nota para o curriculo candidato.setNota
	}

	public void validarDocumento() {
		
	}

}
