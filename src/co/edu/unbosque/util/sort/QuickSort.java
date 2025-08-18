package co.edu.unbosque.util.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

import co.edu.unbosque.model.Politician;
import co.edu.unbosque.view.PopUpWindow;

public class QuickSort {

	public static int comparacion;
	public static int intercambio;
	public static long tiempo;

	public static void quickSort(Politician[] politicos) {
		comparacion = 0;
		intercambio = 0;
		tiempo = 0;
		long start = System.nanoTime();
		sortByMoneyToRob(politicos, 0, politicos.length - 1);
		long end = System.nanoTime();
		tiempo = end - start;
		try {
			Document document = new Document();
			String dest = "estadisticas/quicksort.pdf";
			File folder = new File("estadisticas");
			if (!folder.exists()) {
				folder.mkdirs();
			}
			PdfWriter.getInstance(document, new FileOutputStream(dest));
			document.open();

			Image logo = Image.getInstance("src/assets/capital.png");
			logo.scaleToFit(200, 200);
			logo.setAlignment(Image.ALIGN_CENTER);
			document.add(logo);

			Font title = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
			Paragraph titulo = new Paragraph("APOCO: Asociación de Politicos Corruptos", title);
			titulo.setAlignment(Paragraph.ALIGN_CENTER);
			titulo.setSpacingAfter(20);
			document.add(titulo);

			Phrase header = new Phrase("Se ordenó con Quick Sort, el tamaño del arreglo es " + politicos.length
					+ ", se realizaron " + comparacion + " comparaciones y " + intercambio
					+ " intercambios. Tiempo de ejecución (ns): " + tiempo);
			document.add(header);
			document.close();
			PopUpWindow.pdfCreated();
		} catch (FileNotFoundException ex) {
			PopUpWindow.pdfFailed();
		} catch (DocumentException e) {
			PopUpWindow.pdfFailed();
		} catch (MalformedURLException e) {
			PopUpWindow.pdfFailed();
		} catch (IOException e) {
			PopUpWindow.pdfFailed();
		}
	}

	public static void matrixQuickSort(Politician[][] matrix) {
		comparacion = 0;
		intercambio = 0;
		tiempo = 0;
		long start = System.nanoTime();
		for (int i = 0; i < matrix.length; i++) {
			Politician[] fila = matrix[i];
			sortByMoneyToRob(fila, 0, fila.length - 1);
		}
		for (int j = 0; j < matrix[0].length; j++) {
			Politician[] columna = new Politician[matrix.length];
			for (int i = 0; i < matrix.length; i++) {
				columna[i] = matrix[i][j];
			}
			sortByBirthDate(columna, 0, columna.length - 1);
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][j] = columna[i];
			}
		}
		long end = System.nanoTime();
		tiempo = end - start;
		System.out.println("MatrixQuickSort");
		System.out.println("Tamaño Matriz " + matrix.length + "x" + matrix[0].length);
		System.out.println("Comparaciones: " + comparacion);
		System.out.println("Intercambios: " + intercambio);
		System.out.println("Tiempo (ns): " + tiempo);
	}

	private static void sortByMoneyToRob(Politician[] arr, int low, int high) {
		if (low < high) {
			int pi = partitionByMoneyToRob(arr, low, high);
			sortByMoneyToRob(arr, low, pi - 1);
			sortByMoneyToRob(arr, pi + 1, high);
		}
	}

	private static int partitionByMoneyToRob(Politician[] arr, int low, int high) {
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

	private static void sortByBirthDate(Politician[] arr, int low, int high) {
		if (low < high) {
			int pi = partitionByBirthDate(arr, low, high);
			sortByBirthDate(arr, low, pi - 1);
			sortByBirthDate(arr, pi + 1, high);
		}
	}

	private static int partitionByBirthDate(Politician[] arr, int low, int high) {
		Politician pivot = arr[high];
		Date pivotDate = pivot.getBirthDate();
		int i = low - 1;
		for (int j = low; j <= high - 1; j++) {
			comparacion++;
			if (arr[j].getBirthDate().after(pivotDate)) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return i + 1;
	}

}
