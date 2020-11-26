package model.entities;



public class Edital {

	
	private int ID;
	private String DefiniçoesDoCurso;
	private int NumeroDeVagas;
	private int NumeroDeVagasDeficientes;
	private String PublicoAlvo;
	private String PeriodoInscricao;

	
	
	public Edital() {
	
		
	}
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDefiniçoesDoCurso() {
		return DefiniçoesDoCurso;
	}
	public void setDefiniçoesDoCurso(String definiçoesDoCurso) {
		DefiniçoesDoCurso = definiçoesDoCurso;
	}
	public int getNumeroDeVagas() {
		return NumeroDeVagas;
	}
	public void setNumeroDeVagas(int numeroDeVagas) {
		NumeroDeVagas = numeroDeVagas;
	}
	public String getPublicoAlvo() {
		return PublicoAlvo;
	}
	public void setPublicoAlvo(String publicoAlvo) {
		PublicoAlvo = publicoAlvo;
	}
	public String getPeriodoInscricao() {
		return PeriodoInscricao;
	}
	public void setPeriodoInscricao(String periodoInscricao) {
		PeriodoInscricao = periodoInscricao;
	}
	
	
	public int getNumeroDeVagasDeficientes() {
		return NumeroDeVagasDeficientes;
	}
	public void setNumeroDeVagasDeficientes(int numeroDeVagasDeficientes) {
		NumeroDeVagasDeficientes = numeroDeVagasDeficientes;
	}
	@Override
	public String toString() {
		return ID + "," + DefiniçoesDoCurso + "," + NumeroDeVagas + "," + NumeroDeVagasDeficientes + "," + PublicoAlvo + "," + PeriodoInscricao ;
	}
	
	
}
