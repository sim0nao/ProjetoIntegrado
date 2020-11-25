package model.services;

import java.io.IOException;

import javax.swing.JOptionPane;

import model.entities.Candidato;
import model.entities.Edital;
import util.ArquivoEdital;
import util.ArquivosCandidatoFinal;
import util.DynamicStack;
import util.LinkedList;
import util.QuickSort;

public class PresidenteService {



	public Edital criarEdital() {
		Edital edital = new Edital();

		edital.setID(Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do edital")));
		edital.setDefini�oesDoCurso(JOptionPane.showInputDialog("Digite as defini�oes do curso"));
		edital.setNumeroDeVagas(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de vagas ampla concorrencia")));
		edital.setNumeroDeVagasDeficientes(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de vagas deficientes")));
		edital.setPublicoAlvo(JOptionPane.showInputDialog("Digite publico alvo"));
		edital.setPeriodoInscricao(JOptionPane.showInputDialog("Digite periodo de inscri��o DD/MM/AAAA - DD/MM/AAAA"));

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
	
	public String mostraFinalOrdenado() throws IOException {
		
		ArquivosCandidatoFinal arqCan= new ArquivosCandidatoFinal();
		
		LinkedList<Candidato> listaCandidatos = arqCan.lerCandidatosVetor();
		int tamanho=listaCandidatos.size();
		Candidato[] candidatos = new Candidato[tamanho];
		int[] candidatosAux = new int[tamanho];
		for(int i=0;i<tamanho;i++) {
			candidatos[i]=listaCandidatos.removeStart();
			candidatosAux[i]=Integer.parseInt(candidatos[i].getNota());
		}
		
		QuickSort ordena= new QuickSort();
		int start=0;
		int end=tamanho-1;
		
		ordena.sort(candidatosAux, start, end, candidatos);
		
		String mostra="";
		for(int i=tamanho-1;i>=0;i--) {
			mostra += "Nome: "+candidatos[i].getNome()+", Nota:  "
					+candidatos[i].getNota()+",  Situa��o documento: "+candidatos[i].getStatus() + "\n";	
		}
		return mostra;
	}


}