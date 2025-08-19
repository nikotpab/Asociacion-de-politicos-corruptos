package co.edu.unbosque.util.exception;

public class NonEmptyStringValidation {
	private NonEmptyStringValidation() {
	}

	public static void validate(String value, String fieldName) {
		if (value == null || value.trim().isEmpty()) {
			throw new IllegalArgumentException(fieldName + " no puede estar vacío.");
		}
	}
}
