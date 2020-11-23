package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ArquivosCurriculo {

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
