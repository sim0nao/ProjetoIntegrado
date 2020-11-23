package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ArquivosCandidato {
	
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
}
