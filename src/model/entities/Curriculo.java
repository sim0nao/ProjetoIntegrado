package model.entities;

public class Curriculo {
	
	private String cpf;
	private String nome;
	private String endereco;
	private String objetivo;
	private String formacao;
	private String experiencia;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf2) {
		this.cpf = cpf2;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	public String getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}
	@Override
	public String toString() {
		return cpf + ", nome=" + nome + ", endereco=" + endereco + ", objetivo=" + objetivo
				+ ", formacao=" + formacao + ", experiencia=" + experiencia;
	}
	
}
