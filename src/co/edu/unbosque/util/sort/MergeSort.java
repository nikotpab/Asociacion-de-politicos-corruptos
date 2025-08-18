package co.edu.unbosque.util.sort;

import co.edu.unbosque.model.Politician;

public class MergeSort {

	public static int comparacion;
	public static int intercambio;
	public static long tiempo;

	public static void mergeSort(Politician[] politicos) {
		comparacion = 0;
		intercambio = 0;
		tiempo = 0;
		long start = System.nanoTime();
		sort(politicos, 0, politicos.length - 1);
		long end = System.nanoTime();
		tiempo = end - start;
		System.out.println("MergeSort");
		System.out.println("Tamaño Arreglo " + politicos.length);
		System.out.println("Comparaciones: " + comparacion);
		System.out.println("Intercambios: " + intercambio);
		System.out.println("Tiempo (ns): " + tiempo);
	}

	public static void sort(Politician arr[], int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;
			sort(arr, l, m);
			sort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}

	static void merge(Politician arr[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		Politician L[] = new Politician[n1];
		Politician R[] = new Politician[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0;
		int k = l;

		while (i < n1 && j < n2) {
			comparacion++;
			if (L[i].getMoneyToRob() <= R[j].getMoneyToRob()) {
				arr[k] = L[i];
				intercambio++;
				i++;
			} else {
				arr[k] = R[j];
				intercambio++;
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			intercambio++;
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			intercambio++;
			j++;
			k++;
		}
	}

}
