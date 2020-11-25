package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import model.entities.Usuario;
import util.ArquivosUsuario;

public class Main {

	public static void main(String[] args) throws IOException {
		TelaAuxiliar tela = new TelaAuxiliar();
		ArquivosUsuario usu= new ArquivosUsuario();
		Usuario usuario=null;
		String user="";

		while (!user.equals("SAIR")) {
			user = JOptionPane.showInputDialog("BEM-VINDO AO PROJETO INTEGRADO\n" + "\nDigite o CPF do usu�rio"
					+ "\nDigite 'cadastrar' para inserir usu�rio" + "\nDigite sair para finalizar");
			
			user=user.toUpperCase(); //Estrutura para tratar erros de digita��o
			
			if (!user.equals("SAIR") && !user.equals("CADASTRAR")) {
				try {
					usuario = usu.lerUsuario(user);
					user=usu.tipo(user);
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
					usu.gravarUsuario();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case "SAIR":
				JOptionPane.showMessageDialog(null, "Saindo");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Usu�rio n�o localizado");
				break;

			}

		}
	}

}

