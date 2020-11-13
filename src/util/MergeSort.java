package util;

public class MergeSort {

	public void sort(int array[], int start, int end) {
		if (start < end) {
			int mid = (start + end) /2;
			sort(array, start, mid);
			sort(array, mid+1, end);
			merge(array, start, mid, mid+1, end);
		}
	}
	
	private void merge(int array[], int startA, int endA, int startB, int endB) {
		int s1 = startA;
		int s2 = startB;
		int sAux = startA;
		int aux[] = new int[array.length];
		while (s1 <= endA && s2 <= endB) {
			if (array[s1] <= array[s2]) {
				aux[sAux++] = array[s1++];
			} else {
				aux[sAux++] = array[s2++];
			}
		}
		while (s1 <= endA)
			aux[sAux++] = array[s1++];
		while (s2 <= endB)
			aux[sAux++] = array[s2++];
		
		for (int i = startA; i <= endB; i++) {
			array[i] = aux[i];
		}
	}
	
}
