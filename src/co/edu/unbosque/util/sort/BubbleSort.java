package co.edu.unbosque.util.sort;

import co.edu.unbosque.model.Politician;

public class BubbleSort {

	public static int comparacion;
	public static int intercambio;
	public static long tiempo;

	public static void bubbleSort(Politician[] politicos) {
		comparacion = 0;
		intercambio = 0;
		tiempo = 0;
		long start = System.nanoTime();
		sort(politicos, politicos.length);
		long end = System.nanoTime();
		tiempo = end - start;
		System.out.println("BubbleSort");
		System.out.println("Tamaño Arreglo " + politicos.length);
		System.out.println("Comparaciones: " + comparacion);
		System.out.println("Intercambios: " + intercambio);
		System.out.println("Tiempo (ns): " + tiempo);
	}

	private static void sort(Politician arr[], int n) {
		boolean swapped;
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - i - 1; j++) {
				comparacion++;
				if (arr[j].getMoneyToRob() > arr[j + 1].getMoneyToRob()) {
					Politician temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					intercambio++;
					swapped = true;
				}
			}
			if (!swapped)
				break;
		}
	}

}
