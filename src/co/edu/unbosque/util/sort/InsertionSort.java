package co.edu.unbosque.util.sort;

import co.edu.unbosque.model.Politician;

public class InsertionSort {

	public static int comparacion;
	public static int intercambio;
	public static long tiempo;

	public static void insertionSort(Politician[] politicos) {
		comparacion = 0;
		intercambio = 0;
		tiempo = 0;
		long start = System.nanoTime();
		sort(politicos);
		long end = System.nanoTime();
		tiempo = end - start;
		System.out.println("InsertionSort");
		System.out.println("Tamaño Arreglo " + politicos.length);
		System.out.println("Comparaciones: " + comparacion);
		System.out.println("Intercambios: " + intercambio);
		System.out.println("Tiempo (ns): " + tiempo);
	}

	private static void sort(Politician arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			Politician key = arr[i];
			int j = i - 1;

			while (j >= 0) {
				comparacion++;
				if (arr[j].getMoneyToRob() > key.getMoneyToRob()) {
					arr[j + 1] = arr[j];
					j = j - 1;
				} else {
					break;
				}
			}
			arr[j + 1] = key;
			intercambio++;
		}
	}
}
