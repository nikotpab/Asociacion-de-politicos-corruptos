package co.edu.unbosque.util.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

import co.edu.unbosque.model.Politician;
import co.edu.unbosque.view.PopUpWindow;

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
		try {
			Document document = new Document();
			String dest = "estadisticas/selectionsort.pdf";
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

			Phrase header = new Phrase("Se ordenó con Selection Sort, el tamaño del arreglo es " + politicos.length
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
