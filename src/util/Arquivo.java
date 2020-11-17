package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import model.entities.Usuario2;

public class Arquivo {

	public String lerArquivo(String user) throws IOException {

		Usuario2 usuario = new Usuario2();
		String qlqcoisa = "não acho";
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
		return qlqcoisa;
	}
	

	
	
	//
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

	private String geraTxt() {
		StringBuffer buffer = new StringBuffer();
		String linha="";
		while(!linha.equalsIgnoreCase("fim")) {
			linha=JOptionPane.showInputDialog(null, "");
			if(!linha.equalsIgnoreCase("fim")) {
				buffer.append(linha+"\r\n");
			}
		}
		return buffer.toString();
	}

}
