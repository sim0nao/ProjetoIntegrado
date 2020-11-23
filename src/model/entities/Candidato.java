package model.entities;

public class Candidato  extends Usuario{

	private String DataNascimento;
	private long Telefone;
	private String Endereco;
	private boolean Deficiencia;
	private int Nota;
	private int prioridade;
	private String status;
	
	public String getDataNascimento() {
		return DataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		DataNascimento = dataNascimento;
	}
	public long getTelefone() {
		return Telefone;
	}
	public void setTelefone(long telefone) {
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return getCpf() + ", " +getNome() + ", " + getEmail() + ", " + getSenha()
				+", " + DataNascimento + ", " + Telefone + ", " + Endereco
				+ ", " + Deficiencia + ", " + Nota;
	}
	
	@Override
	public void visualisarEdital() {
		// TODO Auto-generated method stub
		
	}
	
}
