package model.entities;

public class Candidato  extends Usuario2{

	private String DataNascimento;
	private int Telefone;
	private String Endereco;
	private boolean Deficiencia;
	private int Nota;
	private int prioridade;
	
	public String getDataNascimento() {
		return DataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		DataNascimento = dataNascimento;
	}
	public int getTelefone() {
		return Telefone;
	}
	public void setTelefone(int telefone) {
		Telefone = telefone;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public boolean isDeficiencia() {
		return Deficiencia;
	}
	public void setDeficiencia(boolean deficiencia) {
		Deficiencia = deficiencia;
	}
	public int getNota() {
		return Nota;
	}
	public void setNota(int nota) {
		Nota = nota;
	}
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	@Override
	public String toString() {
		return  "DataNascimento=" + DataNascimento + ", Telefone=" + Telefone + ", Endereco=" + Endereco
				+ ", Deficiencia=" + Deficiencia + ", Nota=" + Nota;
	}
	@Override
	public void visualisarEdital() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
