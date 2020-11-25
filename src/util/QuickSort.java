package util;

import model.entities.Candidato;

public class QuickSort {

	public void sort(int array[], int start, int end, Candidato vetorAux[]) {
		int division;
		if (start < end) {
			division = partition(array, start, end,vetorAux);
			sort(array, start, division-1,vetorAux);
			sort(array, division+1, end,vetorAux);
		}
	}
	
	private int partition(int array[], int start, int end,Candidato vetorAux[]) {
		int pivo = array[start];
		int s = start+1; 
		int e = end;
		int aux;
		Candidato aux2;
		Candidato pivo2=vetorAux[start];
		
		while (s <= e) {
			while (s <= end && array[s] <= pivo)
				++s;
			while (pivo < array[e])
				--e;
			if (s < e) {
				aux = array[s];
				array[s] = array[e];
				array[e] = aux;
				
				aux2=vetorAux[s];
				vetorAux[s]=vetorAux[e];
				vetorAux[e]=aux2;
				
				++s;
				--e;
			}
		}
		if (start != e) {
			array[start] = array[e];
			array[e] = pivo;
			
			vetorAux[start]=vetorAux[e];
			vetorAux[e]=pivo2;
		}
		return e;
	}
	
}
