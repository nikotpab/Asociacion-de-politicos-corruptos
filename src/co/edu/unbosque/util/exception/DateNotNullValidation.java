package co.edu.unbosque.util.exception;

import java.util.Date;

public class DateNotNullValidation {
	private DateNotNullValidation() {
	}

	public static void validate(Date date, String fieldName) {
		if (date == null) {
			throw new IllegalArgumentException("Selecciona " + fieldName + ".");
		}
	}
}
