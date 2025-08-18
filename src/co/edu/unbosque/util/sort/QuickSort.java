package co.edu.unbosque.util.sort;

import co.edu.unbosque.model.Politician;

public class QuickSort {

	public static int comparacion;
	public static int intercambio;
	public static long tiempo;

	public static void quickSort(Politician[] politicos) {
		comparacion = 0;
		intercambio = 0;
		tiempo = 0;
		long start = System.nanoTime();
		sort(politicos, 0, politicos.length - 1);
		long end = System.nanoTime();
		tiempo = end - start;
		System.out.println("QuickSort");
		System.out.println("Tamaño Arreglo " + politicos.length);
		System.out.println("Comparaciones: " + comparacion);
		System.out.println("Intercambios: " + intercambio);
		System.out.println("Tiempo (ns): " + tiempo);
	}

	private static void sort(Politician[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);

			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	private static int partition(Politician[] arr, int low, int high) {
		Politician pivot = arr[high];
		long pivotValue = pivot.getMoneyToRob();
		int i = low - 1;

		for (int j = low; j <= high - 1; j++) {
			comparacion++;
			if (arr[j].getMoneyToRob() < pivotValue) {
				i++;
				swap(arr, i, j);
			}
		}

		swap(arr, i + 1, high);
		return i + 1;
	}

	private static void swap(Politician[] arr, int i, int j) {
		Politician temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		intercambio++;
	}

}
