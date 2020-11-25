package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ArquivoEdital {
	
	
	public void gravaEdital(String edital) throws IOException{
		File dir = new File("C:\\TEMP");
		File arq = new File("C:\\TEMP", "Edital.txt" );
		
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			String conteudo = edital+"\n";
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
	
	public String lerEdital() throws IOException {
		File dir = new File("C:\\TEMP");
		File arq = new File("C:\\TEMP", "Edital.txt");
		
		String mostraCandidatos="CPF/Nome/Email \n";

		if (dir.exists() && dir.isDirectory()) {
			if (arq.exists() && arq.isFile()) {
				FileInputStream fluxo = new FileInputStream(arq);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) { // procurando End Of File (EOF)
					String[] info= linha.split(",");
					mostraCandidatos+=info[0]+info[1]+info[2]+info[3]+info[4]+info[5]+"\n";
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
