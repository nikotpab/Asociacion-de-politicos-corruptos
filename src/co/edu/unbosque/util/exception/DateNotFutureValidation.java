package co.edu.unbosque.util.exception;

import java.util.Date;

public class DateNotFutureValidation {
	private DateNotFutureValidation() {
	}

	public static void validate(Date date, String fieldName) {
		if (date != null && date.after(new Date())) {
			throw new IllegalArgumentException(fieldName + " no puede ser futura.");
		}
	}
}
