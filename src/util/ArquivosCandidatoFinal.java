package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import model.entities.Candidato;
import model.entities.Usuario;

public class ArquivosCandidatoFinal {
	public void gravaCandidatoFinal(String textoCandidato) throws IOException{
		File dir = new File("C:\\TEMP");
		File arq = new File("C:\\TEMP", "CandidatosFinal.txt" );
		
		if (dir.exists() && dir.isDirectory()) {
			String conteudo = textoCandidato;
			FileWriter fileWriter = new FileWriter(arq, false);
			//fileWriter setado como false para garantir que apenas a ultima alteração seja salva no arquivo
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(conteudo);
			print.flush();
			print.close();
			fileWriter.close();
		}else {
			throw new IOException("Diretório inválido");
		}
	}
	
	public Usuario lerCandidatoFinal(String cpf) throws IOException {
		File dir = new File("C:\\TEMP");
		File arq = new File("C:\\TEMP", "CandidatosFinal.txt");	
		
		Candidato candidato = new Candidato();

		if (dir.exists() && dir.isDirectory()) {
			if (arq.exists() && arq.isFile()) {
				FileInputStream fluxo = new FileInputStream(arq);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) { // procurando End Of File (EOF)
					String[] info= linha.split(", ");
						if(info[0].equals(cpf)) {
							candidato.setCpf(info[0]);
							candidato.setNome(info[1]);
							candidato.setEmail(info[2]);
							candidato.setNota(info[8]);
							candidato.setStatus(info[9]);
							buffer.close();
							leitor.close();
							fluxo.close();
							return candidato;
						}			
					linha=buffer.readLine();
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
	
	
	public LinkedList<Candidato> lerCandidatosVetor() throws IOException {	
		LinkedList<Candidato> listaCandidatos = new LinkedList<Candidato>();
		
		File dir = new File("C:\\TEMP");
		File arq = new File("C:\\TEMP", "CandidatosFinal.txt");	
			
		if (dir.exists() && dir.isDirectory()) {
			if (arq.exists() && arq.isFile()) {
				FileInputStream fluxo = new FileInputStream(arq);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) { // procurando End Of File (EOF)
					String[] info= linha.split(", ");
					Candidato candidato = new Candidato();
					candidato.setCpf(info[0]);
					candidato.setNome(info[1]);
					candidato.setEmail(info[2]);
					candidato.setNota(info[8]);
					candidato.setStatus(info[9]);
					listaCandidatos.addEnd(candidato);
					linha=buffer.readLine();					
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			}
		} else {
			throw new IOException("Diretório inválido");
		}
		return listaCandidatos;
	}
}
