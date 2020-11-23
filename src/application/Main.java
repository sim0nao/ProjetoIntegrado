package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import model.entities.Usuario;
import util.Arquivo;

public class Main {

	public static void main(String[] args) throws IOException {
		TelaAuxiliar tela = new TelaAuxiliar();
		Arquivo arq= new Arquivo();
		Usuario usuario=null;
		String user="";

		while (!user.equals("SAIR")) {
			user = JOptionPane.showInputDialog("BEM-VINDO AO PROJETO INTEGRADO\n" + "\nDigite o CPF do usuário"
					+ "\nDigite 'cadastrar' para inserir usuário" + "\nDigite sair para finalizar");
			
			user=user.toUpperCase();
			
			if (!user.equals("SAIR") && !user.equals("CADASTRAR")) {
				try {
					usuario = arq.lerArquivo(user);
					user=arq.tipo(user);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(user==null){user="default";}
			switch (user) {
			case "CANDIDATO":
				tela.candidatoTela(usuario.getCpf());
				break;

			case "PRESIDENTE":
				tela.presidenteTela();
				break;

			case "CRA":
				tela.craTela();
				break;

			case "CPS":
				tela.cpsTela();
				break;
						

			case "CADASTRAR":
				try {
					arq.gravarUsuario();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case "SAIR":
				JOptionPane.showMessageDialog(null, "Saindo");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Usuário não localizado");
				break;

			}

		}
	}

}

