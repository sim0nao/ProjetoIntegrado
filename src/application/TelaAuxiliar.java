package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import model.entities.Candidato;
import model.services.CandidatoService;
import model.services.CpsService;
import model.services.CraService;
import model.services.PresidenteService;
import util.ArquivosCandidato;
import util.ArquivosCandidatoFinal;
import util.DoublyLinkedList;

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
	
	public void presidenteTela() {
		int op = 0;

		while (op != 9) {
			PresidenteService service = new PresidenteService();
			op = Integer.parseInt(
					JOptionPane.showInputDialog("PRESIDENTE"+"\nDigite 1: Criar edital" + "\nDigite 2: Alterar edital"
							+ "\nDigite 3: Visualizar edital" + "\nDigite 9: Voltar"));
			switch (op) {
			case 1:
				service.criarEdital();
				break;

			case 2:
				service.alterarEdital();
				break;

			case 3:
				service.visualizarEdital();
				break;

			case 9:
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
				arqFinal.gravaCandidatoFinal(textoCandidato);
				break;

			default:
				break;

			}
		}
	}
	
	public void craTela() throws IOException {
		int op = 0;
		
		DoublyLinkedList<Candidato> listaCandidatos = new DoublyLinkedList<Candidato>();
		ArquivosCandidato can = new ArquivosCandidato();
		can.lerCandidato(listaCandidatos);
		
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
