package model.services;

import java.io.IOException;

import javax.swing.JOptionPane;

import model.entities.Edital;
import util.ArquivoEdital;
import util.DynamicStack;

public class PresidenteService {



	public Edital criarEdital() {
		Edital edital = new Edital();

		edital.setID(Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do edital")));
		edital.setDefiniçoesDoCurso(JOptionPane.showInputDialog("Digite as definiçoes do curso"));
		edital.setNumeroDeVagas(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de vagas ampla concorrencia")));
		edital.setNumeroDeVagasDeficientes(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de vagas deficientes")));
		edital.setPublicoAlvo(JOptionPane.showInputDialog("Digite publico alvo"));
		edital.setPeriodoInscricao(JOptionPane.showInputDialog("Digite periodo de inscrição DD/MM/AAAA - DD/MM/AAAA"));

		return edital;

	}

	public void alterarEdital() {

	}

	
	public void visualizarEdital(DynamicStack<Edital> pilha) {
		System.out.println(pilha.showDynamicStack());
	}

	
	public void GravaArquivo(DynamicStack<Edital> pilha) {
		ArquivoEdital arqEdital = new ArquivoEdital();
		
		String linha = pilha.showDynamicStack();;
		String[] info= linha.split("\n");
		String dados = "";
	
		//Organiza o showDynamicStack para ser gravado em arquivo
		for (int i = info.length - 1; i >= 0 ; i--) {
			dados+= (info[i]) +"\n";
		}
		
		try {
			//grava pilha inteira em arquivo
			arqEdital.gravaEdital(dados);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public DynamicStack<Edital> carregaArquivo(DynamicStack<Edital> pilha) {
		ArquivoEdital arqEdital = new ArquivoEdital();

		try {
		arqEdital.lerEdital(pilha);	
		} catch (IOException e) {
			e.printStackTrace();
		}

		return pilha;
	}



}