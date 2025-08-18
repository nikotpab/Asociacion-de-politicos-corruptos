package co.edu.unbosque.util.sort;

import co.edu.unbosque.model.Politician;

public class SelectionSort {

	public static int comparacion;
	public static int intercambio;
	public static long tiempo;

	public static void selectionSort(Politician[] politicos) {
		comparacion = 0;
		intercambio = 0;
		tiempo = 0;
		long start = System.nanoTime();
		sort(politicos);
		long end = System.nanoTime();
		tiempo = end - start;
		System.out.println("SelectionSort");
		System.out.println("Tamaño Arreglo " + politicos.length);
		System.out.println("Comparaciones: " + comparacion);
		System.out.println("Intercambios: " + intercambio);
		System.out.println("Tiempo (ns): " + tiempo);
	}

	private static void sort(Politician[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int min_idx = i;

			for (int j = i + 1; j < n; j++) {
				comparacion++;
				if (arr[j].getMoneyToRob() < arr[min_idx].getMoneyToRob()) {
					min_idx = j;
				}
			}

			Politician temp = arr[i];
			arr[i] = arr[min_idx];
			arr[min_idx] = temp;
			intercambio++;
		}
	}

}
