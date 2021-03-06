package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import model.entities.Candidato;
import model.entities.Edital;
import model.services.CandidatoService;
import model.services.CpsService;
import model.services.CraService;
import model.services.PresidenteService;
import util.ArquivosCandidato;
import util.ArquivosCandidatoFinal;
import util.DoublyLinkedList;
import util.DynamicStack;

public class TelaAuxiliar {
	
	public void candidatoTela(String cpf) throws IOException {
		int op = 0;

		while (op != 9) {
			CandidatoService service = new CandidatoService();
			
			
			op = Integer.parseInt(JOptionPane
					.showInputDialog("CANDIDATO"+"\nDigite 1: Realizar inscri��o" + "\nDigite 2: Acompanhar inscri��o"
							+ "\nDigite 3: Solicitar recurso" + "\nDigite 9: Voltar"));
			switch (op) {
			case 1:
			   service.RealizaInscricao(cpf);
				break;

			case 2:
				service.acompanhaInscricao(cpf);
				break;

			case 3:
				service.solicitaRecurso(cpf);
				break;

			case 9:
				break;

			default:
				break;

			}
		}
	}
	
	public void presidenteTela() throws IOException {
		DynamicStack<Edital> pilha = new DynamicStack<Edital>();
		PresidenteService service = new PresidenteService();
		service.carregaArquivo(pilha);
		//Nas fun��es do Presidente foi utilizado uma estrutura de pilha para trabalahr os dados
		int op = 0;

		while (op != 9) {


			op = Integer.parseInt(
					JOptionPane.showInputDialog("PRESIDENTE"+"\nDigite 1: Criar edital" + "\nDigite 2: Alterar ultimo edital "
							+"\nDigite 3: Vizualizar ultimo edital" + "\nDigite 4: Visualizar todos os editais" + "\nDigite 5: Mostrar candidatos por nota"+"\nDigite 9: Voltar"));
			switch (op) {
			case 1:
				
				pilha.push(service.criarEdital()); //adiciona edital na pilha
				break;

			case 2:
				service.alterarEdital();
				JOptionPane.showMessageDialog(null, "Ultimo edital sera excluido por favor reinserir as informa�oes");
				pilha.pop();
				pilha.push(service.criarEdital());
				break;
			
			case 3:
				
				service.visualizaUltimoEdital(pilha);
				break;
			
			
			case 4:
				service.visualizarEdital(pilha);
				
				break;
				

			case 5:
				JOptionPane.showMessageDialog(null, service.mostraFinalOrdenado());//utiliza do metodo Quick Sort para ordenar

			

			case 9:
				service.GravaArquivo(pilha); //grava��o no arquivo ao sair da tela do usu�rio
				break;

			default:
				break;
			}
		}
	}
	
	public void cpsTela() throws IOException {
		int op = 0;
		DoublyLinkedList<Candidato> listaCandidatos = new DoublyLinkedList<Candidato>();
		ArquivosCandidato can = new ArquivosCandidato();
		ArquivosCandidatoFinal arqFinal = new ArquivosCandidatoFinal();
		
		//Em CPS a lista duplamente encadeada � implementada para gerir as informa��es de candidatos
		
		String textoCandidato="";
		
		can.lerCandidato(listaCandidatos);
		
		while (op != 9) {
			CpsService service = new CpsService();
			op = Integer.parseInt(JOptionPane.showInputDialog("CPS"+"\nDigite 1: Avaliar curr�culo"
					+ "\nDigite 2: Validar documentos" + "\nDigite 9: Voltar"));
			switch (op) {
			case 1:
				textoCandidato=service.avaliarCurriculo(listaCandidatos);
				break;

			case 2:
				textoCandidato=service.validarDocumento(listaCandidatos);
				break;

			case 9:
				arqFinal.gravaCandidatoFinal(textoCandidato);//grava��o no arquivo ao sair da tela do usu�rio
				break;

			default:
				break;

			}
		}
	}
	
	public void craTela() throws IOException {
		DoublyLinkedList<Candidato> listaCandidatos = new DoublyLinkedList<Candidato>();
		ArquivosCandidato can = new ArquivosCandidato();
		
		can.lerCandidato(listaCandidatos);
		
		//m�todo semelhante as fun��es do CPS
		
		int op = 0;	
		while (op != 9) {
			CraService service = new CraService();
			op = Integer.parseInt(JOptionPane.showInputDialog("CRA"+"\nDigite 1: Validar documentos"
															+ "\nDigite 9: Voltar"));
			switch (op) {
			case 1:
				service.validarDocumentos(listaCandidatos);
				break;

			case 9:
				break;

			default:
				break;

			}
		}
	}

}