package model.services;

import java.io.IOException;

import javax.swing.JOptionPane;
import util.Arquivo;

public class CpsService {

	public void avaliarCurriculo() throws IOException {
		
		Arquivo arq = new Arquivo();
		String mostraCandidatos = arq.lerCandidato();
		String cpf=JOptionPane.showInputDialog(mostraCandidatos+"\n DIGITE O CPF DO CANDIDATO DESEJADO");
		JOptionPane.showMessageDialog(null, arq.lerCurriculo(cpf));
		//Atribuir nota para o curriculo candidato.setNota
	}

	public void validarDocumento() {
		
	}

}
