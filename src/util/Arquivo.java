package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import model.entities.CPS;
import model.entities.CRA;
import model.entities.Candidato;
import model.entities.Presidente;
import model.entities.Usuario;

public class Arquivo {

	public String lerArquivo(String user) throws IOException {

		Usuario usuario;
		File dir = new File("C:\\TEMP");
		File arq = new File("C:\\TEMP", "Usuarios.txt");

		if (dir.exists() && dir.isDirectory()) {
			if (arq.exists() && arq.isFile()) {
				FileInputStream fluxo = new FileInputStream(arq);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) { // procurando End Of File (EOF)
					String[] dados = linha.split(",");
					
					if (dados[0].equals(user)) {
						if(dados[4].contains("Presidente")) {
							usuario = new Presidente();
						}else if(dados[4].contains("CPS")) {
							usuario= new CPS();
						}else if(dados[4].contains("CRA")) {
							usuario = new CRA();
						}else {
							usuario = new Candidato();
						}
						usuario.setNome(dados[0]);
						usuario.setEmail(dados[1]);
						usuario.setSenha(dados[2]);
						usuario.setCpf(Integer.parseInt(dados[3]));
						buffer.close();
						leitor.close();
						fluxo.close();
						return dados[4];
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} else {
				System.out.println("Usuário não encontrado");
			}
		} else {
			throw new IOException("Diretório inválido");
		}
		return null;
	}
	

	
	
	
	public void gravarArquivo() throws IOException {
		File dir = new File("C:\\TEMP");
		
		if (dir.mkdir()) {
			System.out.println("Diretório Criado");
		} else {
			System.out.println("Diretório já existente");
		}
		
		File arq = new File("C:\\TEMP", "Usuarios.txt" );
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			String conteudo = geraTxt();
			FileWriter fileWriter = new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(conteudo);
			print.flush();
			print.close();
			fileWriter.close();
		}else {
			throw new IOException("Diretório inválido");
		}
	}
	//Gerar texto Usuário
	private String geraTxt() {
		StringBuffer buffer = new StringBuffer();
			String nome = JOptionPane.showInputDialog("Digite o nome");
			String email = JOptionPane.showInputDialog("Digite o email");
			String senha = JOptionPane.showInputDialog("Digite a senha");
			String cpf = JOptionPane.showInputDialog("Digite o cpf");
			String posicao= JOptionPane.showInputDialog("Digite o acesso (Presidente/CPS/CRA/Candidato)");		
			buffer.append("\n"+nome+","+email+","+senha+","+cpf+","+posicao);

		return buffer.toString();
	}

}
