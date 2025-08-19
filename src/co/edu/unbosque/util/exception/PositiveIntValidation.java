package co.edu.unbosque.util.exception;

public class PositiveIntValidation {
	private PositiveIntValidation() {
	}

	public static void validate(int value, String fieldName) {
		if (value <= 0) {
			throw new IllegalArgumentException(fieldName + " debe ser mayor que cero.");
		}
	}
}
