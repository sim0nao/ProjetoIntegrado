package model.services;

import model.entities.Candidato;
import util.DoublyLinkedList;

public class CraService {

	public void validarDocumentos(DoublyLinkedList<Candidato> listaCandidatos) {
		CpsService cps = new CpsService();
		cps.validarDocumento(listaCandidatos);
	}

}
