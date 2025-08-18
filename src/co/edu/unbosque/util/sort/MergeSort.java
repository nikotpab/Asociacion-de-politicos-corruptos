package co.edu.unbosque.util.sort;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

import co.edu.unbosque.model.Politician;
import co.edu.unbosque.view.PopUpWindow;

public class MergeSort {

	public static int comparacion;
	public static int intercambio;
	public static long tiempo;

	public static void mergeSort(Politician[] politicos) {
		comparacion = 0;
		intercambio = 0;
		tiempo = 0;
		long start = System.nanoTime();
		sortByBirthDate(politicos, 0, politicos.length - 1);
		long end = System.nanoTime();
		tiempo = end - start;
		try {
			Document document = new Document();
			String dest = "estadisticas/mergesort.pdf";
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

			Phrase header = new Phrase("Se ordenó con Merge Sort, el tamaño del arreglo es " + politicos.length
					+ ", se realizaron " + comparacion + " comparaciones y " + intercambio
					+ " intercambios. Tiempo de ejecución (ns): " + tiempo);
			document.add(header);
			XYSeries serie = new XYSeries("");
			serie.add(tiempo / 8, comparacion / 8);
			serie.add(tiempo / 4, comparacion / 4);
			serie.add(tiempo / 2, comparacion / 2);
			serie.add(tiempo, comparacion);

			XYSeriesCollection dataset = new XYSeriesCollection();
			dataset.addSeries(serie);

			document.add(new Paragraph("\n"));

			JFreeChart chart = ChartFactory.createXYLineChart("Gráfico tiempo vs comparaciones", "Tiempo (ns)",
					"Comparaciones", dataset, PlotOrientation.VERTICAL, true, true, false);

			BufferedImage bi = chart.createBufferedImage(300, 300);
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			ImageIO.write(bi, "png", bs);
			bs.flush();
			byte[] png = bs.toByteArray();

			Image chartImg = Image.getInstance(png);

			document.add(chartImg);
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

	public static void matrixMergeSort(Politician[][] matrix) {
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
		try {
			Document document = new Document();
			String dest = "estadisticas/mergesort.pdf";
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

			Phrase header = new Phrase("Se ordenó con Merge Sort, el tamaño de la matriz es " + matrix[0].length + "x"
					+ matrix.length + ", se realizaron " + comparacion + " comparaciones y " + intercambio
					+ " intercambios. Tiempo de ejecución (ns): " + tiempo);
			document.add(header);

			XYSeries serie = new XYSeries("");
			serie.add(tiempo / 8, comparacion / 8);
			serie.add(tiempo / 4, comparacion / 4);
			serie.add(tiempo / 2, comparacion / 2);
			serie.add(tiempo, comparacion);

			XYSeriesCollection dataset = new XYSeriesCollection();
			dataset.addSeries(serie);

			document.add(new Paragraph("\n"));

			JFreeChart chart = ChartFactory.createXYLineChart("Gráfico tiempo vs comparaciones", "Tiempo (ns)",
					"Comparaciones", dataset, PlotOrientation.VERTICAL, true, true, false);

			BufferedImage bi = chart.createBufferedImage(300, 300);
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			ImageIO.write(bi, "png", bs);
			bs.flush();
			byte[] png = bs.toByteArray();

			Image chartImg = Image.getInstance(png);

			document.add(chartImg);
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

	private static void sortByMoneyToRob(Politician arr[], int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;
			sortByMoneyToRob(arr, l, m);
			sortByMoneyToRob(arr, m + 1, r);
			mergeByMoneyToRob(arr, l, m, r);
		}
	}

	private static void mergeByMoneyToRob(Politician arr[], int l, int m, int r) {
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

	private static void sortByBirthDate(Politician arr[], int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;
			sortByBirthDate(arr, l, m);
			sortByBirthDate(arr, m + 1, r);
			mergeByBirthDate(arr, l, m, r);
		}
	}

	private static void mergeByBirthDate(Politician arr[], int l, int m, int r) {
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
			if (L[i].getBirthDate().after(R[j].getBirthDate())) {
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
