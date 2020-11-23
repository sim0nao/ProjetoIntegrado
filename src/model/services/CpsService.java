package model.services;

import java.io.IOException;

import javax.swing.JOptionPane;
import util.ArquivosCandidato;
import util.ArquivosCurriculo;

public class CpsService {

	public void avaliarCurriculo() throws IOException {
		int nota=0;
		
		ArquivosCandidato can = new ArquivosCandidato();
		ArquivosCurriculo cur = new ArquivosCurriculo();
		
		String mostraCandidatos = can.lerCandidato();
		String cpf=JOptionPane.showInputDialog(mostraCandidatos+"\n DIGITE O CPF DO CANDIDATO DESEJADO");
		nota=Integer.parseInt(JOptionPane.showInputDialog(cur.lerCurriculo(cpf)+"\n Digite a nota da avaliação"));
		//Atribuir nota para o curriculo candidato.setNota
	}

	public void validarDocumento() {
		
	}

}
