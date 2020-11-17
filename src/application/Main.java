package application;

import java.io.IOException;

import javax.swing.JOptionPane;
import util.Arquivo;

public class Main {

	public static void main(String[] args) {
		TelaAuxiliar tela = new TelaAuxiliar();
		Arquivo arq= new Arquivo();
		String user = "";

		while (!user.equals("sair")) {
			user = JOptionPane.showInputDialog("BEM-VINDO AO PROJETO INTEGRADO\n" + "\nDigite o usuário"
					+ "\nDigite cadastrar para inserir usuário" + "\nDigite sair para finalizar");
			
			if (!user.equals("sair")) {
				try {
					user = arq.lerArquivo(user);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			switch (user) {
			case "Candidato":
				tela.candidatoTela();
				break;

			case "Presidente":
				tela.presidenteTela();
				break;

			case "CRA":
				tela.craTela();
				break;

			case "CPS":
				tela.cpsTela();
				break;
			

			case "cadastrar":
				// metodo cadastra usuario
				break;

			case "sair":
				JOptionPane.showMessageDialog(null, "Saindo");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Usuário não localizado");
				break;

			}

		}
	}

}

