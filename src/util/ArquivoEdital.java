package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;



import model.entities.Edital;

public class ArquivoEdital {
	
	
	public void gravaEdital(String edital) throws IOException{
		File dir = new File("C:\\TEMP");
		File arq = new File("C:\\TEMP", "Edital.txt" );
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			
			String conteudo = edital;
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
	
	public DynamicStack<Edital> lerEdital(DynamicStack<Edital> pilha) throws IOException {

		File dir = new File("C:\\TEMP");
		File arq = new File("C:\\TEMP", "Edital.txt");
		
		

		if (dir.exists() && dir.isDirectory()) {
			if (arq.exists() && arq.isFile()) {
				FileInputStream fluxo = new FileInputStream(arq);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) { // procurando End Of File (EOF)
					String[] info= linha.split(",");
					
					Edital edital = new Edital();
					edital.setID(Integer.parseInt(info[0]));
					edital.setDefiniçoesDoCurso(info[1]);
					edital.setNumeroDeVagas(Integer.parseInt(info[2]));
					edital.setNumeroDeVagasDeficientes(Integer.parseInt(info[3]));
					edital.setPublicoAlvo(info[4]);
					edital.setPeriodoInscricao(info[5]);
					pilha.push(edital);
					
					linha=buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			}
		} else {
			throw new IOException("Diretório inválido");
		}
		return pilha;
	}
}
