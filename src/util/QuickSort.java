package util;

public class QuickSort {

	public void sort(int array[], int start, int end) {
		int division;
		if (start < end) {
			division = partition(array, start, end);
			sort(array, start, division-1);
			sort(array, division+1, end);
		}
	}
	
	private int partition(int array[], int start, int end) {
		int pivo = array[start];
		int s = start+1; 
		int e = end;
		int aux;
		while (s <= e) {
			while (s <= end && array[s] <= pivo)
				++s;
			while (pivo < array[e])
				--e;
			if (s < e) {
				aux = array[s];
				array[s] = array[e];
				array[e] = aux;
				++s;
				--e;
			}
		}
		if (start != e) {
			array[start] = array[e];
			array[e] = pivo;
		}
		return e;
	}
	
}
