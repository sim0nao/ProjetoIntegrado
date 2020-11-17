package application;

import javax.swing.JOptionPane;

public class TelaAuxiliar {
	
	public void candidatoTela() {
		int op = 0;

		while (op != 9) {
			op = Integer.parseInt(JOptionPane
					.showInputDialog("CANDIDATO"+"\nDigite 1: Realizar inscrição" + "\nDigite 2: Acompanhar inscrição"
							+ "\nDigite 3: Solicitar recurso" + "\nDigite 9: Voltar"));
			switch (op) {
			case 1:
				//realizaInscrição()
				break;

			case 2:
				//acompanhaInscricao()
				break;

			case 3:
				//solicitaRecurso()
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
			op = Integer.parseInt(
					JOptionPane.showInputDialog("PRESIDENTE"+"\nDigite 1: Criar edital" + "\nDigite 2: Alterar edital"
							+ "\nDigite 3: Visualizar edital" + "\nDigite 9: Voltar"));
			switch (op) {
			case 1:
				break;

			case 2:
				break;

			case 3:
				break;

			case 9:
				break;

			default:
				break;

			}
		}
	}
	
	public void cpsTela() {
		int op = 0;

		while (op != 9) {
			op = Integer.parseInt(JOptionPane.showInputDialog("CPS"+"\nDigite 1: Avaliar currículo"
					+ "\nDigite 2: Validar documentos" + "\nDigite 9: Voltar"));
			switch (op) {
			case 1:
				break;

			case 2:
				break;

			case 3:
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
			op = Integer.parseInt(JOptionPane.showInputDialog("CRA"+"\nDigite 1: Validar documentos"
					+ "\nDigite 2: Visualizar edital" + "\nDigite 9: Voltar"));
			switch (op) {
			case 1:
				break;

			case 2:
				break;

			case 3:
				break;

			case 9:
				break;

			default:
				break;

			}
		}
	}

}
