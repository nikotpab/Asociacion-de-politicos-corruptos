package co.edu.unbosque.model;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Random;

public class PoliticianRepository {

	public static Politician[][] generarMatrixPoliticos(int k, int m) {
		if (k * m < 10) {
			throw new IllegalArgumentException("El valor de k * m debe ser mayor o igual a 10.");
		}

		Politician[][] matrix = new Politician[k][m];
		Random random = new Random();
		int id = 0;

		for (int i = 0; i < k; i++) {
			for (int j = 0; j < m; j++) {
				long dineroRobado = 1_000_000L + (long) (random.nextDouble() * (100_000_000_000L - 1_000_000L));

				Calendar calendar = Calendar.getInstance();
				int year = 1950 + random.nextInt(51);
				int month = random.nextInt(12);
				int day = 1 + random.nextInt(28);
				calendar.set(year, month, day);
				Date fechaNacimiento = calendar.getTime();

				matrix[i][j] = new Politician(id, dineroRobado, fechaNacimiento, "n" + id++);
			}
		}
		return matrix;
	}

	public static Politician[] generarPoliticos(int n) {
		if (n < 10) {
			throw new IllegalArgumentException("El valor de n debe ser mayor o igual a 10.");
		}

		Politician[] politicos = new Politician[n];
		Random random = new Random();

		for (int id = 0; id < politicos.length; id++) {

			long dineroRobar = 1_000_000L + (long) (random.nextDouble() * (100_000_000_000L - 1_000_000L));

			Calendar calendar = Calendar.getInstance();
			int year = 1950 + random.nextInt(51);
			int month = random.nextInt(12);
			int day = 1 + random.nextInt(28);
			calendar.set(year, month, day);
			Date fechaNacimiento = calendar.getTime();

			politicos[id] = new Politician(id, dineroRobar, fechaNacimiento, "n" + id);
		}
		return politicos;
	}

	public static Politician[] generarOrdenInverso(int n) {
		Politician[] politicos = generarPoliticos(n);
		Arrays.sort(politicos, (a, b) -> Long.compare(b.getMoneyToRob(), a.getMoneyToRob()));
		return politicos;
	}

	public static Politician[] generarParcialmenteOrdenado(int n) {
		Politician[] politicos = generarPoliticos(n);
		Arrays.sort(politicos, 0, n / 2, Comparator.comparingLong(Politician::getMoneyToRob));
		return politicos;
	}

	public static Politician[] generarDesordenado(int n) {
		return generarPoliticos(n);
	}

}
