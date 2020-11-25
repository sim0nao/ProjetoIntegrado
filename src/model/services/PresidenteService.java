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


		try {
			arqEdital.gravaEdital(pilha.showDynamicStack());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public DynamicStack<Edital> carregaArquivo(DynamicStack<Edital> pilha) {
		ArquivoEdital arqEdital = new ArquivoEdital();

		try {
		System.out.println(arqEdital.lerEdital());	
		} catch (IOException e) {

			e.printStackTrace();
		}

		return pilha;
	}
	
	public String mostraFinalOrdenado() throws IOException {
		
		ArquivosCandidatoFinal arqCan= new ArquivosCandidatoFinal();
		
		LinkedList<Candidato> listaCandidatos = arqCan.lerCandidatosVetor();
		int tamanho=listaCandidatos.size();
		//passando a lista encadeada para um vetor de forma manual
		Candidato[] candidatos = new Candidato[tamanho];
		int[] candidatosAux = new int[tamanho];
		
		for(int i=0;i<tamanho;i++) {
			candidatos[i]=listaCandidatos.removeStart();
			candidatosAux[i]=Integer.parseInt(candidatos[i].getNota());
		}
		
		//utilização do Quick sort para ordenar os vetores
		QuickSort ordena= new QuickSort();
		int start=0;
		int end=tamanho-1;
		
		ordena.sort(candidatosAux, start, end, candidatos);
		
		String mostra="";
		for(int i=tamanho-1;i>=0;i--) {
			mostra += "Nome: "+candidatos[i].getNome()+", Nota:  "
					+candidatos[i].getNota()+",  Situação documento: "+candidatos[i].getStatus() + "\n";	
		}
		return mostra;
	}


}