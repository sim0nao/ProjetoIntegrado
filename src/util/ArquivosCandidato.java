package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import model.entities.Candidato;

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
	
	public DoublyLinkedList<Candidato> lerCandidato(DoublyLinkedList<Candidato> listaCandidatos) throws IOException {

		File dir = new File("C:\\TEMP");
		File arq = new File("C:\\TEMP", "Candidatos.txt");
		
		
		

		if (dir.exists() && dir.isDirectory()) {
			if (arq.exists() && arq.isFile()) {
				FileInputStream fluxo = new FileInputStream(arq);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) { // procurando End Of File (EOF)
					String[] info= linha.split(",");
					Candidato candidato = new Candidato();
					candidato.setCpf(info[0]);
					candidato.setNome(info[1]);
					candidato.setEmail(info[2]);
					candidato.setSenha(info[3]);
					candidato.setDataNascimento(info[4]);
					candidato.setTelefone(info[5]);
					candidato.setEndereco(info[6]);
					
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
