package model.services;

import java.io.IOException;

import javax.swing.JOptionPane;

import model.entities.Candidato;
import model.entities.Curriculo;
import util.LinkedList;
import util.ArquivosUsuario;
import util.ArquivosCandidato;
import util.ArquivosCandidatoFinal;
import util.ArquivosCurriculo;

public class CandidatoService {
	
	public LinkedList<Candidato> findAll() {
		return null;
	}
	
	public void RealizaInscricao (String cpf) throws IOException {	

		ArquivosUsuario usu = new ArquivosUsuario();
		ArquivosCandidato can= new ArquivosCandidato();
		ArquivosCurriculo cur= new ArquivosCurriculo();
		Candidato user = new Candidato();
		Curriculo curriculo= new Curriculo();
		
		int D;
		
		user=(Candidato)usu.lerUsuario(cpf);
		
		user.setDataNascimento(JOptionPane.showInputDialog("Digite data de Nascimento DD/MM/AAAA"));
		user.setTelefone(JOptionPane.showInputDialog("Digite telefone"));
		user.setEndereco(JOptionPane.showInputDialog("Digite endereço"));
		D =  Integer.parseInt(JOptionPane.showInputDialog("Se possuir alguma deficiência Digite 1, caso contrario 2"));
		if (D == 1) {
			user.setDeficiencia(true);
		}else if(D==2) {
			user.setDeficiencia(false);
		}
		
		String textoCandidato= user.toString();
		can.gravaCandidato(textoCandidato);
		
		//Cadastrar Curriculo
		JOptionPane.showMessageDialog(null, "Cadastre o curriculo");
		String[] infoCandidato = textoCandidato.split(",");
		curriculo.setCpf(infoCandidato[0]);
		curriculo.setNome(infoCandidato[1]);
		curriculo.setEndereco(infoCandidato[6]);
		curriculo.setObjetivo(JOptionPane.showInputDialog("Digite o objetivo"));
		curriculo.setFormacao(JOptionPane.showInputDialog("Digite a formação"));
		curriculo.setExperiencia(JOptionPane.showInputDialog("Digite a experiência"));
		
		
		String textoCurriculo=curriculo.toString();
		cur.gravarCurriculo(textoCurriculo);

	}
	
	public void acompanhaInscricao(String cpf) throws IOException {
		ArquivosCandidatoFinal usu = new ArquivosCandidatoFinal();
		Candidato user = new Candidato();
		
		user=(Candidato)usu.lerCandidatoFinal(cpf);
		
		if(user.getStatus()==null) {
			user.setStatus("AGUARDANDO");
		}
		JOptionPane.showMessageDialog(null, user.getNome()+", "+user.getEmail()+", "+user.getNota()+", "+user.getStatus());
		
	}
	
	public void solicitaRecurso(String cpf) throws IOException {
		ArquivosUsuario usu = new ArquivosUsuario();
		Candidato user = new Candidato();
		
		user=(Candidato)usu.lerUsuario(cpf);
		
		if(user.getStatus()=="APROVADO"){
			JOptionPane.showMessageDialog(null, "Candidato aprovado, não é possivel solicitar recurso");
		}
		
		String motivoRecurso = JOptionPane.showInputDialog("Especifique motivo do recurso");
		System.out.println(motivoRecurso);
	}
}
