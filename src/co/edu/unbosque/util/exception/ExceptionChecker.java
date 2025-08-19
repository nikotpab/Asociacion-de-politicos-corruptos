package co.edu.unbosque.util.exception;

import java.util.Date;
import java.util.List;

public class ExceptionChecker {
	private ExceptionChecker() {
	}

	public static void nonEmpty(String value, String fieldName) {
		NonEmptyStringValidation.validate(value, fieldName);
	}

	public static int parseInt(String text, String fieldName) {
		return IntegerValidation.parse(text, fieldName);
	}

	public static long parseLong(String text, String fieldName) {
		return LongValidation.parse(text, fieldName);
	}

	public static void dateNotNull(Date date, String fieldName) {
		DateNotNullValidation.validate(date, fieldName);
	}

	public static void dateNotFuture(Date date, String fieldName) {
		DateNotFutureValidation.validate(date, fieldName);
	}

	public static <T> void listNotEmpty(List<T> list, String fieldName) {
		ListNotEmptyValidation.validate(list, fieldName);
	}

	public static <T> void matrixWellFormed(T[][] m, String fieldName) {
		MatrixWellFormedValidation.validate(m, fieldName);
	}

	public static void positiveInt(int value, String fieldName) {
		PositiveIntValidation.validate(value, fieldName);
	}

	public static void selectionNotNull(Object sel, String fieldName) {
		SelectionNotNullValidation.validate(sel, fieldName);
	}
}
