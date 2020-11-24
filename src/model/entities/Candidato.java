package model.entities;

public class Candidato  extends Usuario{

	private String DataNascimento;
	private String Telefone;
	private String Endereco;
	private boolean Deficiencia;
	private String Nota;
	private int prioridade;
	private String status;
	
	public String getDataNascimento() {
		return DataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		DataNascimento = dataNascimento;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String info) {
		Telefone = info;
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
	public String getNota() {
		return Nota;
	}
	public void setNota(String info) {
		Nota = info;
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
				+ ", " + Deficiencia + ", " + Nota +", "+ status;
	}
	
	@Override
	public void visualisarEdital() {
		// TODO Auto-generated method stub
		
	}
	
}
