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


 //set os atributos no objeto edital e retona para ser inserido na pilha
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

	
	public void visualizaUltimoEdital(DynamicStack<Edital> pilha) {
		String dados = "";
		
		
		
		dados += "ID - " + pilha.showTop().getID();
		dados += "  Definiçoes Do Curso - " + pilha.showTop().getDefiniçoesDoCurso();	
		dados += "  NumeroDe Vagas - " + pilha.showTop().getNumeroDeVagas();
		dados += "  NumeroDeVagasDeficientes - " + pilha.showTop().getNumeroDeVagasDeficientes();
		dados += "  Publico Alvo - " + pilha.showTop().getPublicoAlvo();
		dados += "  Periodo Inscricao - " + pilha.showTop().getPeriodoInscricao();
		System.out.println(dados);
		
	}
	
	//mostra todos os editais na pilha
	public void visualizarEdital(DynamicStack<Edital> pilha) {
		System.out.println(pilha.showDynamicStack());
		
	
	}

	//grava em arquivo todos os editais em pilha
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
    //Ao iniciar o programa resgada os editais do arquivo e move para a pilha.
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