package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import model.entities.Edital;
import model.services.CandidatoService;
import model.services.CpsService;
import model.services.CraService;
import model.services.PresidenteService;

import util.DynamicStack;

public class TelaAuxiliar {
	
	public void candidatoTela(String cpf) throws IOException {
		int op = 0;

		while (op != 9) {
			CandidatoService service = new CandidatoService();
			op = Integer.parseInt(JOptionPane
					.showInputDialog("CANDIDATO"+"\nDigite 1: Realizar inscrição" + "\nDigite 2: Acompanhar inscrição"
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
		DynamicStack<Edital> pilha = new DynamicStack<Edital>();
		PresidenteService service = new PresidenteService();
		//service.carregaArquivo(pilha);
		//necessario ajustar o ler arquivo e adicionar a pilha
		int op = 0;

		while (op != 9) {
			
			
			op = Integer.parseInt(
					JOptionPane.showInputDialog("PRESIDENTE"+"\nDigite 1: Criar edital" + "\nDigite 2: Alterar ultimo edital "
							+ "\nDigite 3: Visualizar edital" + "\nDigite 9: Voltar"));
			switch (op) {
			case 1:
				pilha.push(service.criarEdital());
				break;

			case 2:
				JOptionPane.showMessageDialog(null, "Ultimo edital sera excluido por favor reinserir as informaçoes");
				pilha.pop();
				pilha.push(service.criarEdital());
				break;

			case 3:
				service.visualizarEdital(pilha);
				break;

			case 9:
				service.GravaArquivo(pilha);//necessario adicionar limpar o arquivo quando realizar nova gravação para nao haver conflito
				break;

			default:
				break;

			}
		}
	}
	
	public void cpsTela() throws IOException {
		int op = 0;

		while (op != 9) {
			CpsService service = new CpsService();
			op = Integer.parseInt(JOptionPane.showInputDialog("CPS"+"\nDigite 1: Avaliar currículo"
					+ "\nDigite 2: Validar documentos" + "\nDigite 9: Voltar"));
			switch (op) {
			case 1:
				service.avaliarCurriculo();
				break;

			case 2:
				service.validarDocumento();
				break;

			case 9:
				break;

			default:
				break;

			}
		}
	}
	
	public void craTela() {
		int op = 0;

		while (op != 9) {
			CraService service = new CraService();
			op = Integer.parseInt(JOptionPane.showInputDialog("CRA"+"\nDigite 1: Validar documentos"
															+ "\nDigite 9: Voltar"));
			switch (op) {
			case 1:
				service.validarDocumentos();
				break;

			case 9:
				break;

			default:
				break;

			}
		}
	}

}
