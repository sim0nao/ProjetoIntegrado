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

	public Usuario lerArquivo(String user) throws IOException {

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
						if(dados[4].contains("PRESIDENTE")) {
							usuario = new Presidente();
						}else if(dados[4].contains("CPS")) {
							usuario= new CPS();
						}else if(dados[4].contains("CRA")) {
							usuario = new CRA();
						}else {
							usuario = new Candidato();
						}
						usuario.setNome(dados[1]);
						usuario.setEmail(dados[2]);
						usuario.setSenha(dados[3]);
						usuario.setCpf(dados[0]);
						buffer.close();
						leitor.close();
						fluxo.close();
						return usuario;
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
	

	
	
	
	public void gravarUsuario() throws IOException {
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
			posicao=posicao.toUpperCase();		
			System.out.println(posicao);
			
			buffer.append("\n"+cpf+","+nome+","+email+","+senha+","+posicao);

		return buffer.toString();
	}
	
	
	
	public void gravaCandidato(String textoCandidato) throws IOException{
		File dir = new File("C:\\TEMP");
		File arq = new File("C:\\TEMP", "Candidatos.txt" );
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			String conteudo = textoCandidato+"\n";
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
	
	
	public String lerCandidato() throws IOException {

		File dir = new File("C:\\TEMP");
		File arq = new File("C:\\TEMP", "Candidatos.txt");
		
		String mostraCandidatos="CPF/Nome/Email \n";

		if (dir.exists() && dir.isDirectory()) {
			if (arq.exists() && arq.isFile()) {
				FileInputStream fluxo = new FileInputStream(arq);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) { // procurando End Of File (EOF)
					String[] info= linha.split(",");
					mostraCandidatos+=info[0]+info[1]+info[2]+"\n";
					linha=buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			}
		} else {
			throw new IOException("Diretório inválido");
		}
		return mostraCandidatos;
	}
	
	public String tipo(String user) throws IOException {

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
			}
		} else {
			throw new IOException("Diretório inválido");
		}
		return null;
	}
	
	
	public void gravarCurriculo(String textoCandidato) throws IOException {
		File dir = new File("C:\\TEMP");
		
		if (dir.mkdir()) {
			System.out.println("Diretório Criado");
		} else {
			System.out.println("Diretório já existente");
		}
		
		File arq = new File("C:\\TEMP", "Curriculos.txt" );
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			String conteudo = textoCandidato+"\n";
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
	
	public String lerCurriculo(String cpf) throws IOException {

		File dir = new File("C:\\TEMP");
		File arq = new File("C:\\TEMP", "Curriculos.txt");

		if (dir.exists() && dir.isDirectory()) {
			if (arq.exists() && arq.isFile()) {
				FileInputStream fluxo = new FileInputStream(arq);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) { // procurando End Of File (EOF)
					String[] dados = linha.split(",");				
					if (dados[0].equals(cpf)) {
						buffer.close();
						leitor.close();
						fluxo.close();
						return linha;
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

}
